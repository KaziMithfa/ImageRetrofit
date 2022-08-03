package com.example.imageretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recylerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recylerView = findViewById(R.id.recylerviewId);

        getProducts();
    }

    private void getProducts() {

        Call<List<ProductResultModel>> call = RetrofitClient.getInstance().getApi().getProducts();

        call.enqueue(new Callback<List<ProductResultModel>>() {
            @Override
            public void onResponse(Call<List<ProductResultModel>> call, Response<List<ProductResultModel>> response) {

                if(response.isSuccessful()){
                    List<ProductResultModel>imageList = response.body();
                    setProducts(imageList);


                }

            }

            @Override
            public void onFailure(Call<List<ProductResultModel>> call, Throwable t) {

            }
        });




    }

    private void setProducts(List<ProductResultModel> imageList) {
        recylerView.setLayoutManager(new LinearLayoutManager(this));
        ImageAdapter imageAdapter = new ImageAdapter(this,imageList);
        recylerView.setAdapter(imageAdapter);

    }
}