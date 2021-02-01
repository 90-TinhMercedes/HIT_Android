package com.example.alarmlayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity5 extends AppCompatActivity {

    Calendar calendar;
    TimePicker timePicker;
    Button btnConfirm, btnBack;
    ImageView imgHitIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnBack = (Button) findViewById(R.id.btnBack);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        calendar = Calendar.getInstance();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());

                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                String strHour = String.valueOf(hour);
                String strMinute = String.valueOf(minute);
                if(minute < 10){
                    strMinute = "0" + String.valueOf(minute);
                }

                Toast.makeText(MainActivity5.this, "Time: " + strHour + ":" + strMinute, Toast.LENGTH_LONG).show();
            }
        });

    }
}