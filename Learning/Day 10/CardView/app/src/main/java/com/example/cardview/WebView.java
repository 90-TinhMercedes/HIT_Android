package com.example.cardview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {
    private android.webkit.WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        webView = findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }

    }
}