package com.example.imageretrofit;

import com.google.gson.annotations.SerializedName;

public class ProductResultModel {

    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("image")
    String image;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
