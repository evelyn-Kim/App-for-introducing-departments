package com.example.it;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class activity3 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        Button my7button = (Button) findViewById(R.id.button7);
        Button my8button = (Button) findViewById(R.id.button8);
        Button my9button = (Button) findViewById(R.id.button9);

        my7button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        my8button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        my9button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my9Intent = new Intent(activity3.this, activity4.class);
                startActivity(my9Intent);
            }
        });
    }
}