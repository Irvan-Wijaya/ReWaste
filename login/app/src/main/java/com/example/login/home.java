package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    Button btnPoints, btnBooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnPoints = findViewById(R.id.btnPoints);
        btnBooth = findViewById(R.id.btnBooth);


        btnPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindahPoint = new Intent(home.this, Point.class);
                startActivity(pindahPoint);
            }
        });

        btnBooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindahPeta = new Intent(home.this, MapsActivity.class);
                startActivity(pindahPeta);
            }
        });
    }
}