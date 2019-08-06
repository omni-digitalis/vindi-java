package br.com.vindi.services;

import br.com.vindi.config.VindiConfig;
import br.com.vindi.exceptions.RequestFailedException;
import br.com.vindi.models.Client;
import br.com.vindi.models.PaymentProfile;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The main communication class, it tries to initialize the VindiConfig
 */
public final class Vindi {

    private ClientService clientService;
    private PaymentProfileService paymentProfileService;

    public Vindi(String privateKey) throws Exception {
        VindiConfig.init(privateKey);
        setup();
    }

    public Vindi() throws Exception {
        VindiConfig.init();
        setup();
    }

    public Client createClient(Client client) throws Exception {
        Call<Client> request = clientService.createClient(client);

        var response = request.execute();
        if (!response.isSuccessful()) {
            throw new RequestFailedException("Create Client Request: " + (response.errorBody() != null ? response.errorBody().string() : null));
        }

        return response.body();
    }

    public PaymentProfile createPaymentProfile(PaymentProfile paymentProfile) throws Exception {
        Call<PaymentProfile> request = paymentProfileService.createPaymentProfile(paymentProfile);

        var response = request.execute();
        if (!response.isSuccessful()) {
            throw new RequestFailedException("Create Payment Profile Request: " + (response.errorBody() != null ? response.errorBody().string() : null));
        }

        return response.body();
    }

    private void setup() {
        final var credentials = Credentials.basic(VindiConfig.getPrivKey(), null);

        final var okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    final var authRequest = chain.request()
                            .newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .addHeader("Authorization", credentials + ":")
                            .build();

                    return chain.proceed(authRequest);
                })
                .build();

        var retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(VindiConfig.getApiUrl())
                .build();

        // create all necessary services
        clientService = retrofit.create(ClientService.class);
        paymentProfileService = retrofit.create(PaymentProfileService.class);
    }

}
