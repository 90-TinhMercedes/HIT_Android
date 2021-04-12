package com.example.cardview;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoViewDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        VideoView videoView = findViewById(R.id.video_view);
        String videoAddress = "https://fcdc32b94b16.ngrok.io/video/stream/mp4/toystory";
        Uri vidUri = Uri.parse(videoAddress);
        videoView.setVideoURI(vidUri);
        videoView.start();
    }


}