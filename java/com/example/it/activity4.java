package com.example.it;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class activity4 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);

        Button my10button = (Button) findViewById(R.id.button10);
        Button my11button = (Button) findViewById(R.id.button11);

        my10button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        my11button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my11intent = new Intent(activity4.this, MainActivity.class);
                my11intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                my11intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(my11intent);
                finish();
            }
        });

    }
}