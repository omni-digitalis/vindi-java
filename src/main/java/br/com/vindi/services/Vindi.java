package br.com.vindi.services;

import br.com.vindi.config.VindiConfig;
import br.com.vindi.exceptions.RequestFailedException;
import br.com.vindi.models.Bill;
import br.com.vindi.models.Customer;
import br.com.vindi.models.PaymentProfile;
import br.com.vindi.models.Product;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * The main communication class, it tries to initialize the VindiConfig
 */
public final class Vindi {

    private Retrofit retrofit;

    public Vindi(String privateKey, String publicKey) throws Exception {
        VindiConfig.init(privateKey, publicKey);
        setup();
    }

    public Vindi() throws Exception {
        VindiConfig.init();
        setup();
    }

    public Customer createClient(Customer customer) throws Exception {
        var service = getService(CustomerService.class);
        var response = request(service.createClient(customer));

        return response.get(Customer.MAP_KEY);
    }

    public PaymentProfile createPaymentProfile(PaymentProfile paymentProfile) throws Exception {
        var service = getService(PaymentProfileService.class);
        var response = request(service.createPaymentProfile(paymentProfile));

        return response.get(PaymentProfile.MAP_KEY);
    }

    public PaymentProfile findPaymentProfileBy(Long paymentProfileId) throws Exception {
        var service = getService(PaymentProfileService.class);
        var response = request(service.findPaymentProfileBy(paymentProfileId));

        return response.get(PaymentProfile.MAP_KEY);
    }

    public List<PaymentProfile> findPaymentProfileBy(String customerId, String status, String paymentMethod)
            throws Exception {
        var service = getService(PaymentProfileService.class);
        var response = request(service.findPaymentProfileBy(customerId, status, paymentMethod));

        return response.get(PaymentProfile.MAP_LIST_KEY);
    }

    public Product createProduct(Product product) throws Exception {
        var service = getService(ProductService.class);
        var response = request(service.createProduct(product));

        return response.get(Product.MAP_KEY);
    }

    public Bill createBill(Bill bill) throws Exception {
        var service = getService(BillService.class);
        var response = request(service.createBill(bill));

        return response.get(Bill.MAP_KEY);
    }

    public <C extends Call<R>, R> R request(C call) throws RequestFailedException, IOException {
        var response = call.execute();
        var body = response.body();

        if (!response.isSuccessful() || body == null) {
            throw new RequestFailedException("Vindi Call Endpoint: " + call.request().url().toString()
                    + " Request Error: " + (response.errorBody() != null ? response.errorBody().string() : null));
        }

        return body;
    }

    public <S> S getService(Class<S> service) {
        return retrofit.create(service);
    }

    private void setup() {
        final var credentials = Credentials.basic(VindiConfig.getPrivKey(), null);

        final var okHttpClient = new OkHttpClient.Builder().addInterceptor(chain -> {
            final var authRequest = chain.request().newBuilder().addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", credentials + ":").build();

            return chain.proceed(authRequest);
        }).build();

        this.retrofit = new Retrofit.Builder().client(okHttpClient).addConverterFactory(GsonConverterFactory.create())
                .baseUrl(VindiConfig.getApiUrl()).build();
    }

}
