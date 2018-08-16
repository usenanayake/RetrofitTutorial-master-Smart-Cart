package com.tuts.prakash.retrofittutorial.activity;

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

import android.os.Handler;

import com.tuts.prakash.retrofittutorial.R;
import com.tuts.prakash.retrofittutorial.adapter.CustomAdapter;
import com.tuts.prakash.retrofittutorial.menu;
import com.tuts.prakash.retrofittutorial.model.RetroPhoto;
import com.tuts.prakash.retrofittutorial.network.GetDataService;
import com.tuts.prakash.retrofittutorial.network.RetrofitClientInstance;
import com.tuts.prakash.retrofittutorial.payment;
import com.tuts.prakash.retrofittutorial.userRegister;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    private TextView textView7;

    private final Handler handler = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView7 = findViewById(R.id.textView7);
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();


       // Intent intent = getIntent();
//        this.mHandler = new Handler();
//
//        this.mHandler.postDelayed(m_Runnable,5000);


        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {

            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn= (Button) findViewById(R.id.pay);

        btn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, payment.class));
                    }
                }
        );

        Button btn1= (Button) findViewById(R.id.refresh);

        btn1.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                    }
                }
        );

        //createSum();

        //createSum(photoList);


//        finish();
//        startActivity(intent);
//        finish();
//        startActivity(getIntent());

        doTheAutoRefresh();

    }








    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<RetroPhoto> photoList) {

        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



        createSum(photoList);
       // this.textView7.setText("Total");
    }

   private void createSum(List<RetroPhoto> photoList) {
        int sum = 0;

//       for(int l=0; l<=5; l++){
//           sum =  sum +1;
//       }

        for(RetroPhoto retroPhoto: photoList) {
            sum = sum + (Integer.parseInt(retroPhoto.getprice()));
        }
        updateUI(sum);
    }

    private void updateUI(int sum) {
        this.textView7.setText(Integer.toString(sum));

    }


    private void doTheAutoRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Write code for your refresh logic
                //doTheAutoRefresh();
            }
        }, 5000);
    }

}
