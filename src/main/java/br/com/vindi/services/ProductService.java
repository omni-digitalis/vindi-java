package br.com.vindi.services;

import br.com.vindi.models.Product;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.Map;

public interface ProductService {

    @POST("products")
    Call<Map<String, Product>> createProduct(@Body Product product) throws Exception;

}
