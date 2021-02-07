package com.example.leagueoflegendsshop;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         // có ít nhất 01 ký tự số
                    "(?=.*[a-z])" +         // có ít nhất 01 ký chữ thường
                    "(?=.*[A-Z])" +         // có ít nhất 01 ký chữ hoa
                    "(?=.*[!@#$%^&*=+])" +  // có ít nhất 01 ký tự đặc biệt
                    "(?=\\S+$)" +           // không được có khoảng trắng (space)
                    ".{6,}" +               // có ít nhất 6 ký tự
                    "$");
    private TextInputLayout txtILPassword, txtILConfirmPassword, txtILUsername;
    private EditText edtPassword, edtConfirmPassword, edtUsername;
    private Button btnCancel, btnConfirm, btnDangKy;
    private Dialog dialog;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDangKy = (Button) findViewById(R.id.btnDangKy);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_dangky);
        dialog.setCancelable(false);
        Mappings();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validatePassword() | !validateUsername()){
                    return;
                }
                dialog.dismiss();
            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });


    }



    private void Mappings() {

        txtILPassword = (TextInputLayout) dialog.findViewById(R.id.textInputPassword);
        txtILConfirmPassword = (TextInputLayout) dialog.findViewById(R.id.textInputConfirmPassword);
        txtILUsername = (TextInputLayout) dialog.findViewById(R.id.textInputUsername);
        edtUsername = (EditText) dialog.findViewById(R.id.edtUsername);
        edtPassword = (EditText) dialog.findViewById(R.id.edtPassword);
        edtConfirmPassword = (EditText) dialog.findViewById(R.id.edtConfirmPassword);
        btnCancel = dialog.findViewById(R.id.btnCancel);
        btnConfirm = dialog.findViewById(R.id.btnConfirm);
    }

    private boolean validateUsername() {
        String inputUsername = txtILUsername.getEditText().getText().toString().trim();
        if (inputUsername.isEmpty()) {
            txtILUsername.setError("Tên đăng nhập không thể bỏ trống.");
            return false;
        } else if (inputUsername.length() > 15) {
            txtILUsername.setError("Tên tài khoản không quá 15 ký tự.");
            return false;
        } else {
            txtILUsername.setError(null);
            return true;
        }
    }


    private boolean validatePassword() {
        String passwordInput = txtILPassword.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            txtILPassword.setError("Mật khẩu không thể bỏ trống.");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            txtILPassword.setError("Nhập lại mật khẩu.");
            return false;
        } else {
            txtILPassword.setError(null);
            return true;
        }
    }

    public void confirmInput(View view) {
        if (!validatePassword() | !validateUsername()) {
            return;
        }
    }

}