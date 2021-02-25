package com.example.day05ver1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.day05ver1.databinding.LayoutFragment1Binding;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {

    LayoutFragment1Binding binding;

    public static Fragment1 newInstance() {
        
        Bundle args = new Bundle();
        
        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        View view = inflater.inflate(R.layout.layout_fragment1, container, false);
//        return view;
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment1, container, false);
        binding.btnMoveToFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Person> list = new ArrayList<>();
                list.add(new Person("HIT Tinhmercedes", 20));
                list.add(new Person("HIT LoveVeigar", 20));
                list.add(new Person("HIT Diep", 20));
                list.add(new Person("HIT Doan", 20));
                Fragment fragment = Fragment2.newInstance("Chí Tình", new Person("TinhMercedes", 20), list);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layout_fragment, fragment).addToBackStack(null).commit();
            }
        });


        return binding.getRoot();
    }
}
