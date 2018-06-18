package com.tuts.prakash.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tuts.prakash.retrofittutorial.activity.MainActivity;
import com.tuts.prakash.retrofittutorial.model.PostDetailsRequest;
import com.tuts.prakash.retrofittutorial.model.PostDetailsRespond;
import com.tuts.prakash.retrofittutorial.model.RetroPhoto;
import com.tuts.prakash.retrofittutorial.network.GetDataService;
import com.tuts.prakash.retrofittutorial.network.PostData;
import com.tuts.prakash.retrofittutorial.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        PostData service = RetrofitClientInstance.getRetrofitInstance().create(PostData.class);

        PostDetailsRequest post = new PostDetailsRequest("name", "price");
        Call<PostDetailsRespond> call = service.savePost(post);
        call.enqueue(new Callback<PostDetailsRespond>() {

            @Override
            public void onResponse(Call<PostDetailsRespond> call, Response<PostDetailsRespond> response) {
                System.out.println("Hello, World");
                Toast.makeText(login.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostDetailsRespond> call, Throwable t) {
                System.out.println("invalid");
                Toast.makeText(login.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
