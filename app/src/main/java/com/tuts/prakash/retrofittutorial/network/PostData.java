package com.tuts.prakash.retrofittutorial.network;



import com.tuts.prakash.retrofittutorial.model.PostDetailsRequest;
import com.tuts.prakash.retrofittutorial.model.PostDetailsRespond;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostData {

    @POST("/api/v1/productItem")
    Call<PostDetailsRespond> savePost(@Body PostDetailsRequest postDetailsRequest);
//
//    // delete Gist
//    @DELETE("gists/{id}")
//    Call<ResponseBody> deleteGist(@Path("id") String id);
}
