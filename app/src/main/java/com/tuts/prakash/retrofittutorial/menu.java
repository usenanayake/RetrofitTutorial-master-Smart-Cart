package com.tuts.prakash.retrofittutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tuts.prakash.retrofittutorial.activity.MainActivity;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btn= (Button) findViewById(R.id.cart);

        btn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(menu.this, cart.class));
                    }
                }
        );



        Button btn2= (Button) findViewById(R.id.promo);

        btn2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(menu.this, promo.class));
                    }
                }
        );



        Button btn3= (Button) findViewById(R.id.logout);

        btn3.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(menu.this, login1.class));
                    }
                }
        );


    }
}
