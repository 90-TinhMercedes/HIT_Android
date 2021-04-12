package com.example.cardview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PhotoView extends AppCompatActivity {
    private com.github.chrisbanes.photoview.PhotoView photoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        photoView = findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.avatar_facebook);


    }
}