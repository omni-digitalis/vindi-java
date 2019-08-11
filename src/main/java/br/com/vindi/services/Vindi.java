package br.com.vindi.services;

import br.com.vindi.config.VindiConfig;
import br.com.vindi.exceptions.RequestFailedException;
import br.com.vindi.models.Customer;
import br.com.vindi.models.PaymentProfile;
import br.com.vindi.models.Product;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The main communication class, it tries to initialize the VindiConfig
 */
public final class Vindi {

    private CustomerService customerService;
    private PaymentProfileService paymentProfileService;
    private ProductService productService;

    public Vindi(String privateKey, String publicKey) throws Exception {
        VindiConfig.init(privateKey, publicKey);
        setup();
    }

    public Vindi() throws Exception {
        VindiConfig.init();
        setup();
    }


    public Customer createClient(Customer customer) throws Exception {
        var request = customerService.createClient(customer);

        var response = request.execute();
        if (!response.isSuccessful() || response.body() == null) {
            throw new RequestFailedException("Create Customer Request: " + (response.errorBody() != null ? response.errorBody().string() : null));
        }

        return response.body().get(Customer.class.getSimpleName().toLowerCase());
    }

    public PaymentProfile createPaymentProfile(PaymentProfile paymentProfile) throws Exception {
        Call<PaymentProfile> request = paymentProfileService.createPaymentProfile(paymentProfile);

        var response = request.execute();
        if (!response.isSuccessful()) {
            throw new RequestFailedException("Create Payment Profile Request: " + (response.errorBody() != null ? response.errorBody().string() : null));
        }

        return response.body();
    }

    public Product createProduct(Product product) throws Exception {
        var request = productService.createProduct(product);

        var response = request.execute();
        if (!response.isSuccessful() || response.body() == null) {
            throw new RequestFailedException("Create Product Request: " + (response.errorBody() != null ? response.errorBody().string() : null));
        }

        return response.body().get(Product.class.getSimpleName().toLowerCase());
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
        customerService = retrofit.create(CustomerService.class);
        paymentProfileService = retrofit.create(PaymentProfileService.class);
        productService = retrofit.create(ProductService.class);
    }


}
