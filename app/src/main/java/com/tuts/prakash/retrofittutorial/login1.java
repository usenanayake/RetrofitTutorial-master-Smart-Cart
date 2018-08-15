package com.tuts.prakash.retrofittutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        Button btn= (Button) findViewById(R.id.login);

        btn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(login1.this, menu.class));
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
