package com.example.searchncovi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.net.URL;


public class RulesAndPolicyFragment extends Fragment {
    TextView tvLinkFacebook;

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
        View view = inflater.inflate(R.layout.fragment_rules_and_policy, container, false);
        tvLinkFacebook = view.findViewById(R.id.tv_link_facebook);

        tvLinkFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLinkFacebook = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/90.TinhMercedes"));
                startActivity(intentLinkFacebook);
            }
        });


        return view;
    }
}