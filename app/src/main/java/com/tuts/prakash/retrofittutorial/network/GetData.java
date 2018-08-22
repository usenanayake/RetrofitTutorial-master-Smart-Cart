package com.tuts.prakash.retrofittutorial.network;

import com.tuts.prakash.retrofittutorial.model.PostDetailsRequest;
import com.tuts.prakash.retrofittutorial.model.PostDetailsRespond;
import com.tuts.prakash.retrofittutorial.model.RetroPhoto;

import java.util.List;
import retrofit2.http.DELETE;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GetData {

    @GET("/api/v1/productitems")
    Call<List<RetroPhoto>> getAllPhotos();

   @DELETE("gists/{id}")
    Call<PostDetailsRequest> deleteGist(@Path("id") String id);
}
