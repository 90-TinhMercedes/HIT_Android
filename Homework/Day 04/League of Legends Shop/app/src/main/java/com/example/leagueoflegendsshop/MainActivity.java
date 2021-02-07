package com.example.leagueoflegendsshop;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout txtILPassword, txtILConfirmPassword, txtILUsername, txtILPhoneNumber;
    private EditText edtPassword, edtConfirmPassword, edtUsername, edtPhoneNumber;
    private Button btnCancel, btnConfirm, btnDangKy;
    private Dialog dialogDangKy;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         // có ít nhất 01 ký tự số
                    "(?=.*[a-z])" +         // có ít nhất 01 ký chữ thường
                    "(?=.*[A-Z])" +         // có ít nhất 01 ký chữ hoa
                    "(?=.*[!@#$%^&*=+])" +  // có ít nhất 01 ký tự đặc biệt
                    "(?=\\S+$)" +           // không được có khoảng trắng (space)
                    ".{6,}" +               // có ít nhất 6 ký tự
                    "$");
    private static final Pattern PHONE_NUMBER_PATTERN =
            Pattern.compile("^[0-9].{9,}$");


    ProgressBar prgbCreateAccount;
    ImageView imgCreateAccSuccessful;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDangKy = (Button) findViewById(R.id.btnDangKy);
        prgbCreateAccount = (ProgressBar) findViewById(R.id.prgbCreateAccount);
        imgCreateAccSuccessful = (ImageView) findViewById(R.id.imgCreateAccSuccessful);
        prgbCreateAccount.setVisibility(View.INVISIBLE);
        imgCreateAccSuccessful.setVisibility(View.INVISIBLE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        dialogDangKy = new Dialog(MainActivity.this);
        dialogDangKy.setContentView(R.layout.dialog_dangky);
        dialogDangKy.setCancelable(false);
        dialogDangKy.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_dialog_dangky));
        dialogDangKy.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogDangKy.getWindow().getAttributes().windowAnimations = R.style.animation;

        Mappings();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDangKy.dismiss();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatePassword() | !validateUsername() | !validateConfirmPassword() | !validatePhoneNumber()) {
                    return;
                }
                prgbCreateAccount.setVisibility(View.VISIBLE);
                dialogDangKy.dismiss();
                Toast.makeText(MainActivity.this, "Please wait...", Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        prgbCreateAccount.setVisibility(View.INVISIBLE);
                        imgCreateAccSuccessful.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "Create account successful!", Toast.LENGTH_LONG).show();
                    }
                }, 4500);
            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDangKy.show();
            }
        });

        imgCreateAccSuccessful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCreateAccSuccessful.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void Mappings() {
        txtILPassword = (TextInputLayout) dialogDangKy.findViewById(R.id.textInputPassword);
        txtILConfirmPassword = (TextInputLayout) dialogDangKy.findViewById(R.id.textInputConfirmPassword);
        txtILUsername = (TextInputLayout) dialogDangKy.findViewById(R.id.textInputUsername);
        txtILPhoneNumber = (TextInputLayout) dialogDangKy.findViewById(R.id.textInputPhoneNumber);
        edtUsername = (EditText) dialogDangKy.findViewById(R.id.edtUsername);
        edtPassword = (EditText) dialogDangKy.findViewById(R.id.edtPassword);
        edtConfirmPassword = (EditText) dialogDangKy.findViewById(R.id.edtConfirmPassword);
        edtPhoneNumber = (EditText) dialogDangKy.findViewById(R.id.edtPhoneNumber);
        btnCancel = dialogDangKy.findViewById(R.id.btnCancel);
        btnConfirm = dialogDangKy.findViewById(R.id.btnConfirm);
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
            txtILPassword.setError("Mật khẩu bao gồm ít nhất 01 ký tự chữ thường, 01 ký tự chữ hoa, 01 ký tự số và 01 ký tự đặc biệt.");
            return false;
        } else {
            txtILPassword.setError(null);
            return true;
        }
    }

    private boolean validateConfirmPassword() {
        String passwordInput = txtILPassword.getEditText().getText().toString().trim();
        String confirmPasswordInput = txtILConfirmPassword.getEditText().getText().toString().trim();

        if (confirmPasswordInput.isEmpty()) {
            txtILConfirmPassword.setError("Xác nhận mật khẩu.");
            return false;
        } else if (confirmPasswordInput.compareTo(passwordInput) != 0) {
            txtILConfirmPassword.setError("Hai mật khẩu phải giống nhau.");
            return false;
        } else {
            txtILConfirmPassword.setError(null);
            return true;
        }
    }

    private boolean validatePhoneNumber() {
        String phoneNumberInput = txtILPhoneNumber.getEditText().getText().toString().trim();

        if (phoneNumberInput.isEmpty()) {
            txtILPhoneNumber.setError("Số điện thoại không thể bỏ trống. Sau khi quên mật khẩu, dùng số điện thoại để khôi phục.");
            return false;
        } else if (!PHONE_NUMBER_PATTERN.matcher(phoneNumberInput).matches()) {
            txtILPhoneNumber.setError("Nhập đúng số điện thoại.");
            return false;
        } else {
            txtILPhoneNumber.setError(null);
            return true;
        }
    }


    public void confirmInput(View view) {
        if (!validatePassword() | !validateUsername()) {
            return;
        }
    }

}