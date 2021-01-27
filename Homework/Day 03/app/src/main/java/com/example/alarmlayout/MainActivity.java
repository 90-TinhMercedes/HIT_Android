package com.example.alarmlayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout01, relativeLayout02, relativeLayout03;
    Switch swDinner, swFilm, swCoffee;
    ImageView imgAddAlarm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mappings();

        ActionBar actionBar = getSupportActionBar();
        //        actionBar.hide();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.menu);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setTitle(" Alarm"); // đặt lại tiêu đề cho Activity

        relativeLayout01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        });

        relativeLayout02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        relativeLayout03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        swDinner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Remaining: 3 hours", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                }
            }
        });

        swFilm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Remaining: 4 hours", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                }
            }
        });

        swCoffee.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Remaining: a day", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imgAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity5.class);
                startActivity(intent);
            }
        });






    }

    private void Mappings() {
        relativeLayout01 = (RelativeLayout) findViewById(R.id.relativeLayout01);
        relativeLayout02 = (RelativeLayout) findViewById(R.id.relativeLayout02);
        relativeLayout03 = (RelativeLayout) findViewById(R.id.relativeLayout03);
        swDinner = (Switch) findViewById(R.id.switchOnOff02);
        swFilm = (Switch) findViewById(R.id.switchOnOff01);
        swCoffee = (Switch) findViewById(R.id.switchOnOff03);
        imgAddAlarm = (ImageView) findViewById(R.id.imageViewAddAlarm);
    }
}