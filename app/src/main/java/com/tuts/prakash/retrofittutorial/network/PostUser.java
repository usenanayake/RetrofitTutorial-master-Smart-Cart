package com.tuts.prakash.retrofittutorial.network;

import com.tuts.prakash.retrofittutorial.model.PostUserRequest;
import com.tuts.prakash.retrofittutorial.model.PostUserRespond;

import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.http.Body;

public interface PostUser {

    @POST("/signup")
    Call<PostUserRespond> savePost(@Body PostUserRequest postUserRequest);
}
