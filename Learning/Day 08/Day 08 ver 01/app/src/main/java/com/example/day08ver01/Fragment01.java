package com.example.day08ver01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.day08ver01.databinding.LayoutFragment01Binding;

import java.util.ArrayList;
import java.util.List;

public class Fragment01 extends Fragment {

    LayoutFragment01Binding binding;
    List<Account> list = new ArrayList<>();
    public static Fragment01 newInstance(String name, int age) {

        Bundle args = new Bundle();
//        args.putString("name", name);
//        args.putInt("age", age);
        Fragment01 fragment = new Fragment01();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment_01, container, false);
//        String name = getArguments().getString("name", "null");
//        int age = getArguments().getInt("age", 20);
//        Toast.makeText(getContext(), "Name: " + name + "\nAge: " + age, Toast.LENGTH_SHORT).show();
        list.add(new Account("TinhMercedes", "veigar01"));
        list.add(new Account("TinhHandsome", "veigar02"));
        list.add(new Account("TinhMainVeigar", "veigar01"));
        list.add(new Account("TinhDepTrai", "veigar01"));
        list.add(new Account("TinhVjp", "veigar01"));
        binding.btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Fragment fragment02 = Fragment02.newInstance(new Account("ChiTinhHaUI", "tinhhandsome"));
                Fragment fragment02 = Fragment02.newInstance(list);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment02).addToBackStack(null).commit();

//                Toast.makeText(getContext(), "90_TinhMercedes", Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }


}
