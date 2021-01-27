package com.example.alarmlayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        //        actionBar.hide();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.menu);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setTitle(" Alarm"); // đặt lại tiêu đề cho Activity




    }
}