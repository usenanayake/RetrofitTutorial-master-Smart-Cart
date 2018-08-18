package com.tuts.prakash.retrofittutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tuts.prakash.retrofittutorial.model.PostDetailsRequest;
import com.tuts.prakash.retrofittutorial.model.PostDetailsRespond;
import com.tuts.prakash.retrofittutorial.model.PostUserRequest;
import com.tuts.prakash.retrofittutorial.model.PostUserRespond;
import com.tuts.prakash.retrofittutorial.network.PostData;
import com.tuts.prakash.retrofittutorial.network.PostUser;
import com.tuts.prakash.retrofittutorial.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class userRegister extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private EditText email;
    private EditText contact;
   // private EditText name1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        Button btn= (Button) findViewById(R.id.register);

        btn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {


                        name = findViewById(R.id.name);
                        String value1 = name.getText().toString();

                        password = findViewById(R.id.password);
                        String value2 = password.getText().toString();

                        email = findViewById(R.id.email);
                        String value3 = email.getText().toString();

                        contact = findViewById(R.id.contact);
                        String value4 = contact.getText().toString();


                        PostUser service = RetrofitClientInstance.getRetrofitInstance().create(PostUser.class);

                        PostUserRequest post = new PostUserRequest(value1,value2,value3,value4,"Customer");
                        Call<PostUserRespond> call = service.savePost(post);
                        //service.deleteGist("fwgw");
                        call.enqueue(new Callback<PostUserRespond>() {

                            @Override
                            public void onResponse(Call<PostUserRespond> call, Response<PostUserRespond> response) {
                                System.out.println("Success");
                                Toast.makeText(userRegister.this, "Success", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<PostUserRespond> call, Throwable t) {
                                System.out.println("invalid");
                                Toast.makeText(userRegister.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                                t.printStackTrace();
                            }
                        });


                        startActivity(new Intent(userRegister.this, login1.class));
                    }
                }
        );



        TextView txt= (TextView) findViewById(R.id.login);

        txt.setOnClickListener(
                new TextView.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(userRegister.this, login1.class));
                    }
                }
        );

    }
}
