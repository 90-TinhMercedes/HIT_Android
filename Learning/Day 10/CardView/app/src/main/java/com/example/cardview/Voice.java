package com.example.cardview;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Voice extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    private EditText editText;
    private SeekBar seekBarPitch, seekBarSpeed;
    private Button btnSpeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Mappings();

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(new Locale("VI"));
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.d("TTS", "Language not supported");
                    } else {
                        btnSpeak.setEnabled(true);
                    }
                } else {
                    Log.d("TTS", "Initialization failed");
                }
            }
        });

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }

    private void speak() {
        String text = editText.getText().toString();
        float pitch = (float) seekBarPitch.getProgress() / 50;
        if (pitch < 0.1) pitch = 0.1f;
        float speed = (float) seekBarSpeed.getProgress() / 50;
        if (speed < 0.1) speed = 0.1f;

        textToSpeech.setPitch(pitch);
        textToSpeech.setSpeechRate(speed);
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    private void Mappings() {
        editText = findViewById(R.id.edit_text);
        seekBarPitch = findViewById(R.id.seek_bar_pitch);
        seekBarSpeed = findViewById(R.id.seek_bar_speed);
        btnSpeak = findViewById(R.id.btn_say_text);
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}