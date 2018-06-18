package com.tuts.prakash.retrofittutorial.network;



import com.tuts.prakash.retrofittutorial.model.PostDetailsRequest;
import com.tuts.prakash.retrofittutorial.model.PostDetailsRespond;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostData {

    @POST("/api/v1/productitem")
    Call<PostDetailsRespond> savePost(@Body PostDetailsRequest postDetailsRequest);
}
