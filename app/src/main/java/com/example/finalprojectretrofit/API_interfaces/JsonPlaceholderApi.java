package com.example.finalprojectretrofit.API_interfaces;

import com.example.finalprojectretrofit.Models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceholderApi {

    @GET("/demo/")
    Call<List<Post>> getPosts();

    @POST("/demo/")
    Call<Post> createPost(@Body Post post);
}
