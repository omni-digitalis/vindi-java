package br.com.vindi.services;

import br.com.vindi.models.Bill;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.Map;

public interface BillService {

    @POST("bills")
    Call<Map<String, Bill>> createBill(@Body Bill bill) throws Exception;

}
