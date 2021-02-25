package com.example.day05ver1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.day05ver1.databinding.ActivityMainBinding;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        getFragment(Fragment1.newInstance());
//        Button btn1 = findViewById(R.id.btnFragment1);
//        Button btn2 = findViewById(R.id.btnFragment2);
//        getFragment(Fragment1.newInstance());
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getFragment(Fragment1.newInstance());
//            }
//        });
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getFragment(Fragment2.newInstance());
//            }
//        });

//        binding.btnFragment1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getFragment(Fragment1.newInstance());
//            }
//        });
//
//        binding.btnFragment2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getFragment(Fragment2.newInstance());
//            }
//        });



    }

    public void getFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_fragment, fragment).commit();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCLoseApp(CloseApp closeApp){
        finish();
    }


}