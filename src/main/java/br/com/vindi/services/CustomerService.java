package br.com.vindi.services;

import br.com.vindi.models.Customer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.Map;

public interface CustomerService {

    @POST("customers")
    Call<Map<String, Customer>> createClient(@Body Customer customer) throws Exception;

}
