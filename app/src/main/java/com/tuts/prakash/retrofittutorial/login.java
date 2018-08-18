package com.tuts.prakash.retrofittutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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


    private EditText name1;
    private EditText price1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        Button btn= (Button) findViewById(R.id.send);

        btn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        name1 = findViewById(R.id.name);
                        String value = name1.getText().toString();

                        price1 = findViewById(R.id.price);
                        String value2 =  price1.getText().toString();

                        //startActivity(new Intent(login.this, menu.class));

                        PostData service = RetrofitClientInstance.getRetrofitInstance().create(PostData.class);

                        PostDetailsRequest post = new PostDetailsRequest("socks",value2);
                        Call<PostDetailsRespond> call = service.savePost(post);
                        //service.deleteGist("fwgw");
                        call.enqueue(new Callback<PostDetailsRespond>() {

                            @Override
                            public void onResponse(Call<PostDetailsRespond> call, Response<PostDetailsRespond> response) {
                                System.out.println("Success");
                                Toast.makeText(login.this, "Success", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<PostDetailsRespond> call, Throwable t) {
                                System.out.println("invalid");
                                Toast.makeText(login.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                                t.printStackTrace();
                            }
                        });


                        startActivity(new Intent(login.this, menu.class));
                    }
                }
        );






    }
}
