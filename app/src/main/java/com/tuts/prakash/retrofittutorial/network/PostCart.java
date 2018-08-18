package com.tuts.prakash.retrofittutorial.network;

import com.tuts.prakash.retrofittutorial.model.PostCartRequest;
import com.tuts.prakash.retrofittutorial.model.PostCartRespond;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostCart {

    @POST("/api/v1/myCart")
    Call<PostCartRespond> savePost(@Body PostCartRequest postCartRequest);
}
