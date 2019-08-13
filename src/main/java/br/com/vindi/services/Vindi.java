package br.com.vindi.services;

import br.com.vindi.config.VindiConfig;
import br.com.vindi.exceptions.RequestFailedException;
import br.com.vindi.models.Bill;
import br.com.vindi.models.Customer;
import br.com.vindi.models.PaymentProfile;
import br.com.vindi.models.Product;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

/**
 * The main communication class, it tries to initialize the VindiConfig
 */
public final class Vindi {

    private CustomerService customerService;
    private PaymentProfileService paymentProfileService;
    private ProductService productService;
    private BillService billService;

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
        var body = response.body();

        if (!response.isSuccessful() || body == null) {
            throw new RequestFailedException("Create Customer Request: " + (response.errorBody() != null ? response.errorBody().string() : null));
        }

        return body.get(Customer.class.getSimpleName().toLowerCase());
    }

    public PaymentProfile createPaymentProfile(PaymentProfile paymentProfile) throws Exception {
        final var request = paymentProfileService.createPaymentProfile(paymentProfile);
        final var response = request.execute();
        final var body = response.body();

        if (!response.isSuccessful() || body == null) {
            throw new RequestFailedException("Create Payment Profile Request: " + (response.errorBody() != null ? response.errorBody().string() : null));
        }

        return body.get("payment_profile");
    }

    public PaymentProfile findPaymentProfileBy(Long paymentProfileId) throws Exception {
        final var request = paymentProfileService.findPaymentProfileBy(paymentProfileId);
        final var response = request.execute();
        final var body = response.body();

        if (!response.isSuccessful() || body == null) {
            throw new RequestFailedException("Find Payment Profile Request Failed: " + (response.errorBody() != null ? response.errorBody().string() : null));
        }

        return body.get("payment_profile");
    }

    public List<PaymentProfile> findPaymentProfileBy(String customerId, String status, String paymentMethod) throws Exception {
        final var request = paymentProfileService.findPaymentProfileBy(customerId, status, paymentMethod);
        final var response = request.execute();
        final var body = response.body();

        if (!response.isSuccessful() || body == null) {
            throw new RequestFailedException("Find Payment Profile Request Failed: " + (response.errorBody() != null ? response.errorBody().string() : null));
        }

        return body.get("payment_profiles");
    }

    public Product createProduct(Product product) throws Exception {
        final var request = productService.createProduct(product);
        final var response = request.execute();
        final var body = response.body();

        if (!response.isSuccessful() || body == null) {
            throw new RequestFailedException("Create Product Request: " + (response.errorBody() != null ? response.errorBody().string() : null));
        }

        return body.get(Product.class.getSimpleName().toLowerCase());
    }

    public Bill createBill(Bill bill) throws Exception {
        var request = billService.createBill(bill);

        var response = request.execute();
        if (!response.isSuccessful() || response.body() == null) {
            throw new RequestFailedException("New Bill Request: " + (response.errorBody() != null ? response.errorBody().string() : null));
        }

        return response.body().get(Bill.class.getSimpleName().toLowerCase());
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
        billService = retrofit.create(BillService.class);
    }


}
