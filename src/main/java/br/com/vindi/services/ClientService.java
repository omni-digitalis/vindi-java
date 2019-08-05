package br.com.vindi.services;

import br.com.vindi.models.Client;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ClientService {

    @POST("/customers")
    Call<Client> createClient(@Body Client client)throws Exception;

}
