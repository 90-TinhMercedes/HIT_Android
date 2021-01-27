package com.example.alarmlayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity5 extends AppCompatActivity {

    ImageView imgHitIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        imgHitIcon = (ImageView) findViewById(R.id.imageHitIcon);
        imgHitIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}