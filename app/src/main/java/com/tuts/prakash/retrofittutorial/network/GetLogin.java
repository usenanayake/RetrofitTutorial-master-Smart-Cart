package com.tuts.prakash.retrofittutorial.network;

import com.tuts.prakash.retrofittutorial.model.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetLogin {

    @GET("/login")
    Call<List<RetroPhoto>> getAllLogins();
}
