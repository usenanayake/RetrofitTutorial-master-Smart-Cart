package com.tuts.prakash.retrofittutorial.promotion1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tuts.prakash.retrofittutorial.R;
import com.tuts.prakash.retrofittutorial.adapter.CustomAdapter2;
import com.tuts.prakash.retrofittutorial.login1;
import com.tuts.prakash.retrofittutorial.menu;
import com.tuts.prakash.retrofittutorial.model.PostDeleteRespond;
import com.tuts.prakash.retrofittutorial.model.RetroPhoto;
import com.tuts.prakash.retrofittutorial.network.GetData;
import com.tuts.prakash.retrofittutorial.network.RetrofitClientInstance;
import com.tuts.prakash.retrofittutorial.promo;
import com.tuts.prakash.retrofittutorial.userRegister;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class promotion extends AppCompatActivity {

    private CustomAdapter2 adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);

        progressDoalog = new ProgressDialog(promotion.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetData service = RetrofitClientInstance.getRetrofitInstance().create(GetData.class);

        Call<List<RetroPhoto>> call = service.getAllPhotos();

       // service.deleteGist("fwgw");


//        Button txt= (Button) findViewById(R.id.delete);
//
//        txt.setOnClickListener(
//                new TextView.OnClickListener() {
//                    public void onClick(View v) {
//
//                        GetData service = RetrofitClientInstance.getRetrofitInstance().create(GetData.class);
//
//                        Call<PostDeleteRespond> call = service.deleteGist("124");
//
//
//                        call.enqueue(new Callback<PostDeleteRespond>() {
//
//                            @Override
//                            public void onResponse(Call<PostDeleteRespond> call, Response<PostDeleteRespond> response) {
//                                progressDoalog.dismiss();
//                                if (response.isSuccessful()) {
//                                    Toast.makeText(promotion.this, "deleted", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//
//                            @Override
//                            public void onFailure(Call<PostDeleteRespond> call, Throwable t) {
//                                progressDoalog.dismiss();
//                                Toast.makeText(promotion.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//
//                       //service.deleteGist("fwgw");
//
//                        //startActivity(new Intent(promotion.this, userRegister.class));
//                    }
//                }
//        );

       // service.deleteGist("fwgw");
        call.enqueue(new Callback<List<RetroPhoto>>() {

            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());





            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(promotion.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });



        Button txt= (Button) findViewById(R.id.logout);

        txt.setOnClickListener(
                new TextView.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(promotion.this, login1.class));
                    }
                }
        );
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<RetroPhoto> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter2(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(promotion.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
