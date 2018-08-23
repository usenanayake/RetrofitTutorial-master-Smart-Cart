package com.tuts.prakash.retrofittutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class promo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);


        Button txt= (Button) findViewById(R.id.menu);

        txt.setOnClickListener(
                new TextView.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(promo.this, menu.class));
                    }
                }
        );

    }
}
