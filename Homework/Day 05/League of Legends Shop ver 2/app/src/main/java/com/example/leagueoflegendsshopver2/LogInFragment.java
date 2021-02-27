package com.example.leagueoflegendsshopver2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.leagueoflegendsshopver2.databinding.FragmentLoginBinding;

import org.greenrobot.eventbus.EventBus;

import java.util.regex.Pattern;

public class LogInFragment extends Fragment {

    FragmentLoginBinding binding;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[A-Z])" +
                    "(?=.*[a-z])" +
                    "(?=.*[!@#$%&*=+^])" +
                    "(?=\\S+$)" +
                    ".{6,}" +
                    "$");

    public static LogInFragment newInstance() {

        Bundle args = new Bundle();

        LogInFragment fragment = new LogInFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        binding.progressLoadLogIn.setVisibility(View.INVISIBLE);
        binding.btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.edtUsername.getText().toString();
                String password = binding.edtPassword.getText().toString();

                if (!validateUsername() || !validatePassword()) {
                    return;
                }
                binding.progressLoadLogIn.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "Log in successful!", Toast.LENGTH_SHORT).show();
                        binding.progressLoadLogIn.setVisibility(View.INVISIBLE);
                        Fragment fragment = ShoppingFragment.newInstance();
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
                    }
                }, 3000);
            }
        });

        binding.imgTurnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Are you sure you want to exit app?");
                builder.setMessage("App: League of Legends Shop");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EventBus.getDefault().post(new ECloseApp());
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

        return binding.getRoot();
    }

    private boolean validatePassword() {
        String passwordInput = binding.edtPassword.getText().toString();
        if (passwordInput.isEmpty()) {
            binding.edtPassword.setError("Mật khẩu không thể bỏ trống.");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            binding.edtPassword.setError("Mật khẩu phải có ít nhất 01 ký tự chữ, 01 ký tự chữ hoa, 01 ký tự số, 01 ký tự đặc biệt và tối thiểu 06 ký tự.");
            return false;
        } else {
            binding.edtPassword.setError(null);
            return true;
        }
    }

    private boolean validateUsername() {
        String usernameInput = binding.edtUsername.getText().toString();
        if (usernameInput.isEmpty()) {
            binding.edtUsername.setError("Tên tài khoản không thể bỏ trống.");
            return false;
        } else {
            binding.edtUsername.setError(null);
            return true;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(getActivity());
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(getActivity());
    }
}
