package com.example.day05ver1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.day05ver1.databinding.LayoutFragment2Binding;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    LayoutFragment2Binding binding;

    public static Fragment2 newInstance(String name, Person person, List<Person> list) {

        Bundle args = new Bundle();
        args.putString("name", name);
        args.putParcelable("person", person);
        args.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) list);

        Fragment2 fragment = new Fragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        View view = inflater.inflate(R.layout.layout_fragment2, container, false);
//        return view;
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment2, container, false);
        binding.btnMoveToFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = Fragment1.newInstance();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layout_fragment, fragment).addToBackStack(null).commit();
            }
        });
        String name = getArguments().getString("name");
//        Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();

        Person person = getArguments().getParcelable("person");
        Toast.makeText(getContext(), person.getName() + "\n" + person.getAge(), Toast.LENGTH_SHORT).show();

        List<Person> list = getArguments().getParcelableArrayList("list");
//        Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
        binding.btnMoveToActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), MainActivity2.class);
//                startActivity(intent);

                EventBus.getDefault().post(new CloseApp());

//                Intent intent = new Intent(getContext(), MainActivity3.class);
//                startActivity(intent);
            }
        });


        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(getContext());
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(getContext());
    }
}
