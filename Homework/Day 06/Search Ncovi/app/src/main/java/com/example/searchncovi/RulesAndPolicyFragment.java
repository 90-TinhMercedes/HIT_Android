package com.example.searchncovi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RulesAndPolicyFragment extends Fragment {


    public RulesAndPolicyFragment() {
        // Required empty public constructor
    }


    public static RulesAndPolicyFragment newInstance(String param1, String param2) {
        RulesAndPolicyFragment fragment = new RulesAndPolicyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rules_and_policy, container, false);
    }
}