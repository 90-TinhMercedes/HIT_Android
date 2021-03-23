package com.example.sharepreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static final String SHARE_PRE_NAME = "Account";
    EditText edtUsername, edtPassword;
    CheckBox cbSavePassword;
    Button btnLogIn, btnRead;
    SQLHelper sqlHelper;
    List<Account> accountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mappings();
        sqlHelper = new SQLHelper(this);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbSavePassword.isChecked()) {
                    SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PRE_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", String.valueOf(edtUsername.getText()));
                    editor.putString("password", String.valueOf(edtPassword.getText()));
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Save successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Log in successful!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PRE_NAME, MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "null");
                String password = sharedPreferences.getString("password", "null");
                Toast.makeText(MainActivity.this, username + "\n" + password, Toast.LENGTH_SHORT).show();

            }
        });

//        sqlHelper.insertAccount(new Account("ChiTinhVeigar", "hello"));
//        sqlHelper.insertAccount(new Account("TinhMercedes", "hello"));
//        sqlHelper.updateAccount(5, new Account("90_TinhMercedes", "tinhhandsome"));
//        sqlHelper.deleteAccount(4);
//        sqlHelper.deleteAllAccounts();
        accountList = sqlHelper.getAllAccount();
        Log.d("ListSize", "onCreate: " + accountList.size());



    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PRE_NAME, MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "null");
        String password = sharedPreferences.getString("password", "null");
        edtUsername.setText(username);
        edtPassword.setText(password);
    }

    private void Mappings() {
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        cbSavePassword = findViewById(R.id.check_box_save_password);
        btnLogIn = findViewById(R.id.btn_log_in);
        btnRead = findViewById(R.id.btn_read);
    }
}