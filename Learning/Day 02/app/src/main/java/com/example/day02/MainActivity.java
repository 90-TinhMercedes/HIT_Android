package com.example.day02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editUsername, editPassword;
    Button buttonLoin;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mappings(); // ánh xạ


        buttonLoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                Log.d("TAG", "username = " + username + "\tpassword = " + password);
                textViewResult.setText("Username: " + username + "\n" + "Password: ******");
                Toast.makeText(getBaseContext(), "Login complete!", Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void Mappings(){
        editUsername = findViewById(R.id.editTextUsername);
        editPassword = findViewById(R.id.editTextPassword);
        buttonLoin = findViewById(R.id.buttonLogin);
        textViewResult = findViewById(R.id.textViewResult);
    }
}