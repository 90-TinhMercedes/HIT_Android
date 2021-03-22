package com.example.day08ver01;

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

import com.example.day08ver01.databinding.LayoutFragment02Binding;

import java.util.ArrayList;
import java.util.List;

public class Fragment02 extends Fragment {

    LayoutFragment02Binding binding;

    public static Fragment02 newInstance(List<Account> list) {

        Bundle args = new Bundle();
//        args.putParcelable("account", account);
        args.putParcelableArrayList("listAccount", (ArrayList<? extends Parcelable>) list);
        Fragment02 fragment = new Fragment02();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment_02, container, false);

        binding.btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Account account = getArguments().getParcelable("account");
//                Toast.makeText(getContext(), "Username: " + account.getUsername() + "\nPassword: " + account.getPassword(), Toast.LENGTH_SHORT).show();
                List<Account> list = getArguments().getParcelableArrayList("listAccount");
                Toast.makeText(getContext(), "Size: " + list.size(), Toast.LENGTH_SHORT).show();
                Fragment fragment01 = Fragment01.newInstance("Nguyen Vu Chi Tinh", 20);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment01).addToBackStack(null).commit();
//                Toast.makeText(getContext(), "90_TinhMercedes Love Veigar", Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }













}
