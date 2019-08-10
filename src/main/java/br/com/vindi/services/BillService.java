package br.com.vindi.services;

import br.com.vindi.models.Bill;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BillService {

    @POST("bills")
    Call<Bill> createBill(@Body Bill bill) throws Exception;

}
