package br.com.vindi.services;

import br.com.vindi.models.PaymentProfile;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface PaymentProfileService {

    @POST("payment_profiles")
    Call<Map<String, PaymentProfile>> createPaymentProfile(@Body PaymentProfile paymentProfile);

    @GET("payment_profiles")
    Call<Map<String, List<PaymentProfile>>> findPaymentProfileBy(@Query("customer_id") String customerId,
                                                                 @Query("status") String status,
                                                                 @Query("type") String paymentMethod);

    @GET("payment_profiles/{id}")
    Call<Map<String, PaymentProfile>> findPaymentProfileBy(@Path("id") Long id);
}
