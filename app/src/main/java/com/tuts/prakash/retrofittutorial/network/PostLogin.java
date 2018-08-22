package com.tuts.prakash.retrofittutorial.network;

import com.tuts.prakash.retrofittutorial.model.PostLoginRequest;
import com.tuts.prakash.retrofittutorial.model.PostLoginRespond;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostLogin {

    @POST("/login")
    Call<PostLoginRespond> savePost(@Body PostLoginRequest postLoginRequest);
}
