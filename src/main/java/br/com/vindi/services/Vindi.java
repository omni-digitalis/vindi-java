package br.com.vindi.services;

import br.com.vindi.config.VindiConfig;
import br.com.vindi.exceptions.RequestFailedException;
import br.com.vindi.models.Client;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * The main communication class, it tries to initialize the VindiConfig
 */
public final class Vindi {

    private ClientService clientService;

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

    private void setup() {
        final var credentials = Credentials.basic(VindiConfig.getApiUser(), VindiConfig.getPrivKey());

        final var okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    final var authRequest = chain.request()
                            .newBuilder()
                            .addHeader("Authorization", credentials)
                            .build();

                    return chain.proceed(authRequest);
                })
                .build();

        var retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(VindiConfig.getApiUrl())
                .build();

        // create all necessary services
        clientService = retrofit.create(ClientService.class);
    }

}
