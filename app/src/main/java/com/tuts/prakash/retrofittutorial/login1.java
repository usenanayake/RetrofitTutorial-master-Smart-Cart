package com.tuts.prakash.retrofittutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tuts.prakash.retrofittutorial.model.PostLoginRequest;
import com.tuts.prakash.retrofittutorial.model.PostLoginRespond;
import com.tuts.prakash.retrofittutorial.network.PostLogin;
import com.tuts.prakash.retrofittutorial.network.PostUser;
import com.tuts.prakash.retrofittutorial.network.RetrofitClientInstance;
import com.tuts.prakash.retrofittutorial.promotion1.promotion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login1 extends AppCompatActivity {

    private EditText username;
    private EditText password;

    String user;

    //TextView txtTitle;


    //TextView txt = (TextView) findViewById(R.id.title);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);



        Button btn= (Button) findViewById(R.id.login);

        btn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        username = findViewById(R.id.username);
                        String value1 = username.getText().toString();

                        password = findViewById(R.id.password);
                        String value2 = password.getText().toString();


                        String usr = username.getText().toString();
                        String pass = password.getText().toString();

                        if(usr.matches("") && pass.matches("") ){


                            Toast.makeText(login1.this, "Please fill username and password", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login1.this, login1.class));

                        }


                        if(usr.matches("rep") && pass.matches("123") ){


                            startActivity(new Intent(login1.this, repCart.class));

                        }else {




                        PostLogin service = RetrofitClientInstance.getRetrofitInstance().create(PostLogin.class);

                        PostLoginRequest post = new PostLoginRequest(value1,value2);
                        Call<PostLoginRespond> call = service.savePost(post);
                        //service.deleteGist("fwgw");
                        call.enqueue(new Callback<PostLoginRespond>() {

                            @Override
                            public void onResponse(Call<PostLoginRespond> call, Response<PostLoginRespond> response) {
                                System.out.println("sucess");



                                if(response.body().getsuccess().equals("true")){



                                    Toast.makeText(login1.this, "Success", Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(login1.this, menu.class));

//                               TextView txt = ( TextView) findViewById(R.id.result);
////
//                                txt.setText(user);


                                }
                                else {
//                                    TextView txt = ( TextView) findViewById(R.id.result);
//                                    txt.setText("Invalid Username and Password");

                                    Toast.makeText(login1.this, "Wrong Username and Password", Toast.LENGTH_SHORT).show();

                                   // startActivity(new Intent(login1.this, login1.class));

                                }


                            }

                            @Override
                            public void onFailure(Call<PostLoginRespond> call, Throwable t) {
                                System.out.println("invalid");
                                Toast.makeText(login1.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                                t.printStackTrace();
                            }
                        });




                        }


                        //startActivity(new Intent(login1.this, menu.class));
                    }
                }
        );




        TextView txt= (TextView) findViewById(R.id.register);

        txt.setOnClickListener(
                new TextView.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(login1.this, userRegister.class));
                    }
                }
        );


    }
}
