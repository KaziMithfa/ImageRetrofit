package com.example.imageretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    String BASE_URL = "https://fakestoreapi.com/";

    @GET("products")
    Call<List<ProductResultModel>> getProducts();

}
