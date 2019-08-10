package br.com.vindi.services;

import br.com.vindi.models.Product;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ProductService {

    @POST("products")
    Call<Product> createProduct(@Body Product product) throws Exception;
}
