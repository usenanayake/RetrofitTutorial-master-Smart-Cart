package com.tuts.prakash.retrofittutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        Button txt= (Button) findViewById(R.id.pay);

        txt.setOnClickListener(
                new TextView.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(payment.this, menu.class));
                    }
                }
        );


    }
}
