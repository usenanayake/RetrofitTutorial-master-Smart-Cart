package com.tuts.prakash.retrofittutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tuts.prakash.retrofittutorial.promotion1.promotion;

public class repCart extends AppCompatActivity {

    private EditText rfid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_cart);


        Button btn= (Button) findViewById(R.id.cart);

        btn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {


                        rfid = findViewById(R.id.id);
                        String value = rfid.getText().toString();
                        Integer val = Integer.parseInt(value);

                        if (val == 1) {

                            startActivity(new Intent(repCart.this, promotion.class));
                        }else {

                            Toast.makeText(repCart.this, "Cart is unavailable", Toast.LENGTH_SHORT).show();
                        }





                    }
                }
        );

    }
}
