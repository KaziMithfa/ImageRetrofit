package com.example.imageretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient retrofitClient = null;
    private API api;

    private RetrofitClient(){

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(API.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);

    }

    public  static synchronized RetrofitClient getInstance(){
        if(retrofitClient == null){

            retrofitClient = new RetrofitClient();

        }
        return  retrofitClient;
    }

    public API getApi(){
        return api;
    }




}
