package com.example.cardview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static CardView cardViewPower, cardViewWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        cardViewPower = findViewById(R.id.card_view_power);
        cardViewWeb = findViewById(R.id.card_view_web);
        cardViewPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Power.class);
                startActivity(intent);
            }
        });
        cardViewWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebView.class);
                startActivity(intent);
            }
        });


    }
}