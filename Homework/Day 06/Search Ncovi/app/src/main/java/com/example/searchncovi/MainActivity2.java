package com.example.searchncovi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    ProgressBar progressBarLoadApp;
    ImageView imgBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        progressBarLoadApp = findViewById(R.id.progress_load_app);
        imgBackground = findViewById(R.id.img_covid);

        CountDownTimer countDownTimer = new CountDownTimer(2500, 20) {
            @Override
            public void onTick(long millisUntilFinished) {
                int current = progressBarLoadApp.getProgress();
                progressBarLoadApp.setProgress(current + 1);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                progressBarLoadApp.setVisibility(View.INVISIBLE);
                Toast.makeText(getBaseContext(), "Search Ncovi version 1.0", Toast.LENGTH_LONG).show();
            }
        };
        countDownTimer.start();

        imgBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Search Ncovi version 1.0", Toast.LENGTH_LONG).show();
            }
        });


    }
}