package br.com.vindi.services;

import br.com.vindi.models.PaymentProfile;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PaymentProfileService {

    @POST("payment_profiles")
    Call<PaymentProfile> createPaymentProfile(@Body PaymentProfile paymentProfile);

}
