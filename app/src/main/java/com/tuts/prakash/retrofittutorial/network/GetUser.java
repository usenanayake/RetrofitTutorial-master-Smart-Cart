package com.tuts.prakash.retrofittutorial.network;

import com.tuts.prakash.retrofittutorial.model.PostUserRespond;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetUser {

    @GET("/signup")
    Call<List<PostUserRespond>> getAllUsers();
}
