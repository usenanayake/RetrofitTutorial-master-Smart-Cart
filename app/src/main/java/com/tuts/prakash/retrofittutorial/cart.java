package com.tuts.prakash.retrofittutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tuts.prakash.retrofittutorial.activity.MainActivity;
import com.tuts.prakash.retrofittutorial.model.PostCartRequest;
import com.tuts.prakash.retrofittutorial.model.PostCartRespond;
import com.tuts.prakash.retrofittutorial.network.PostCart;
import com.tuts.prakash.retrofittutorial.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class cart extends AppCompatActivity {

    private EditText rfid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Button btn= (Button) findViewById(R.id.shop);

        btn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        rfid = findViewById(R.id.id);
                        String value = rfid.getText().toString();



                        //startActivity(new Intent(login.this, menu.class));

                        PostCart service = RetrofitClientInstance.getRetrofitInstance().create(PostCart.class);

                        PostCartRequest post = new PostCartRequest(value,"5b77c3850e55f262e6b8c593");
                        Call<PostCartRespond> call = service.savePost(post);
                        //service.deleteGist("fwgw");
                        call.enqueue(new Callback<PostCartRespond>() {

                            @Override
                            public void onResponse(Call<PostCartRespond> call, Response<PostCartRespond> response) {
                                System.out.println("Success");
                                Toast.makeText(cart.this, "Success", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<PostCartRespond> call, Throwable t) {
                                System.out.println("invalid");
                                Toast.makeText(cart.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                                t.printStackTrace();
                            }
                        });


                        startActivity(new Intent(cart.this, MainActivity.class));
                    }
                }
        );

    }
}
