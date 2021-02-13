package com.example.leagueoflegendsshop;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout txtILPassword, txtILConfirmPassword, txtILUsername, txtILPhoneNumber;
    private EditText edtPassword, edtConfirmPassword, edtUsername, edtPhoneNumber;
    private Button btnCancel, btnConfirm, btnRegister, btnLogIn;
    private Dialog dialogRegister, dialogTurnOff;
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
            Pattern.compile("^[0-9].{8,}$");


    ProgressBar prgbCreateAccount;
    TextView tvForgotPassword;
    //    RecyclerView rcvLoLItem;
    ImageView imgTurnOff;
    List<AccountLogIn> accountLogIns;
    EditText edtUser, edtPass;
    ProgressBar prgbLogIn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MappingsSystem();
        accountLogIns = new ArrayList<>();

        dialogRegister = new Dialog(MainActivity.this);
        dialogRegister.setContentView(R.layout.dialog_register);
        dialogRegister.setCancelable(false);
        dialogRegister.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_dialog_dangky));
        dialogRegister.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogRegister.getWindow().getAttributes().windowAnimations = R.style.animation;

        prgbCreateAccount = (ProgressBar) dialogRegister.findViewById(R.id.prgbCreateAccount);
        prgbCreateAccount.setVisibility(View.INVISIBLE);
        prgbLogIn.setVisibility(View.INVISIBLE);

        MappingsDialogRegister();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogRegister.dismiss();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatePassword() | !validateUsername() | !validateConfirmPassword() | !validatePhoneNumber()) {
                    return;
                }
                prgbCreateAccount.setVisibility(View.VISIBLE); //hiển thị progress bar
                // add account vào danh sách.
                accountLogIns.add(new AccountLogIn(edtUsername.getText().toString(), edtPassword.getText().toString()));
                edtUser.setText(edtUsername.getText());

                Toast.makeText(MainActivity.this, "Please wait...", Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        prgbCreateAccount.setVisibility(View.INVISIBLE);
                        dialogRegister.dismiss();
                        Toast.makeText(MainActivity.this, "Create account successful!", Toast.LENGTH_LONG).show();
                    }
                }, 3000);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogRegister.show();
            }
        });

        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentForgotPassword = new Intent(Intent.ACTION_VIEW, Uri.parse("https://account.garena.com/recovery#/"));
                startActivity(intentForgotPassword);
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUser.getText().toString().isEmpty() && edtPass.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Quý khách chưa có Tài khoản?", Toast.LENGTH_SHORT).show();
                }
                else if (edtUser.getText().toString().isEmpty() || edtPass.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập thông tin Tài khoản và Mật khẩu.", Toast.LENGTH_SHORT).show();
                }  else {
                    for (AccountLogIn x : accountLogIns
                    ) {
                        if (edtUser.getText().toString().compareTo(x.getUsername()) == 0 && edtPass.getText().toString().compareTo(x.getPassword()) == 0) {
                            prgbLogIn.setVisibility(View.VISIBLE);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    prgbLogIn.setVisibility(View.INVISIBLE);
                                    Intent intentShop = new Intent(MainActivity.this, LeagueOfLegendsItemShop.class);
                                    startActivity(intentShop);
                                    Toast.makeText(MainActivity.this, "Welcome to League of Legends Shop!", Toast.LENGTH_LONG).show();
                                }
                            }, 3000);
                        } else  if (edtUser.getText().toString().compareTo(x.getUsername()) == 0 && edtPass.getText().toString().compareTo(x.getPassword()) != 0){
                            prgbLogIn.setVisibility(View.VISIBLE);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    prgbLogIn.setVisibility(View.INVISIBLE);
                                    Toast.makeText(MainActivity.this, "Thông tin tài khoản hoặc Mật khẩu không chính xác.", Toast.LENGTH_SHORT).show();
                                }
                            }, 3000);
                        } else if (edtUser.getText().toString().compareTo(x.getUsername()) != 0 && edtPass.getText().toString().compareTo(x.getPassword()) == 0){
                            prgbLogIn.setVisibility(View.VISIBLE);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    prgbLogIn.setVisibility(View.INVISIBLE);
                                    Toast.makeText(MainActivity.this, "Thông tin tài khoản hoặc Mật khẩu không chính xác.", Toast.LENGTH_SHORT).show();
                                }
                            }, 3000);
                        }
                    }
                }
            }
        });

        imgTurnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Are you sure you want to exit app?");
                builder.setMessage("App: League of Legends");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intentTurnOff = new Intent(Intent.ACTION_MAIN);
                        intentTurnOff.addCategory(Intent.CATEGORY_HOME);
                        startActivity(intentTurnOff);
                    }


                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });
    }

    private void MappingsSystem() {
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLogIn = (Button) findViewById(R.id.btnLogIn);
        tvForgotPassword = (TextView) findViewById(R.id.tvForgotPassword);
//        rcvLoLItem = (RecyclerView) findViewById(R.id.rcvLoLItem);
        imgTurnOff = (ImageView) findViewById(R.id.imgTurnOff);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);
        prgbLogIn = (ProgressBar) findViewById(R.id.progressBarLogIn);
    }

    private void MappingsDialogRegister() {
        txtILPassword = (TextInputLayout) dialogRegister.findViewById(R.id.textInputPassword);
        txtILConfirmPassword = (TextInputLayout) dialogRegister.findViewById(R.id.textInputConfirmPassword);
        txtILUsername = (TextInputLayout) dialogRegister.findViewById(R.id.textInputUsername);
        txtILPhoneNumber = (TextInputLayout) dialogRegister.findViewById(R.id.textInputPhoneNumber);
        edtUsername = (EditText) dialogRegister.findViewById(R.id.edtUsername);
        edtPassword = (EditText) dialogRegister.findViewById(R.id.edtPassword);
        edtConfirmPassword = (EditText) dialogRegister.findViewById(R.id.edtConfirmPassword);
        edtPhoneNumber = (EditText) dialogRegister.findViewById(R.id.edtPhoneNumber);
        btnCancel = dialogRegister.findViewById(R.id.btnCancel);
        btnConfirm = dialogRegister.findViewById(R.id.btnConfirm);
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