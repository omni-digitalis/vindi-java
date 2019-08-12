package br.com.vindi.services;

import br.com.vindi.models.PaymentProfile;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.Map;

public interface PaymentProfileService {

    @POST("payment_profiles")
    Call<Map<String, PaymentProfile>> createPaymentProfile(@Body PaymentProfile paymentProfile);

}
