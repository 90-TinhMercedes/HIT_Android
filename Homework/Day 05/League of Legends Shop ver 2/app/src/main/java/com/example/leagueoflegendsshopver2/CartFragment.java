package com.example.leagueoflegendsshopver2;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leagueoflegendsshopver2.databinding.FragmentCartBinding;
import com.example.leagueoflegendsshopver2.databinding.FragmentLoginBinding;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    FragmentCartBinding binding;
    Dialog dialogConfirm, dialogCancel;
    Button btnConfirmYes, btnConfirmNo, btnCancelYes, btnCancelNo;
    ProgressBar progressBar, progressBarCancel;
    TextView tvQuestionConfirm, tvQuestionCancel;
    public static CartFragment newInstance(String sumPrice, List<LeagueOfLegendsItem> listCart) {

        Bundle args = new Bundle();
        args.putString("sumPrice", sumPrice);
        args.putParcelableArrayList("listOrder", (ArrayList<? extends Parcelable>) listCart);

        CartFragment fragment = new CartFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false);
        String sumPrice = getArguments().getString("sumPrice");
        List<LeagueOfLegendsItem> listOrder = getArguments().getParcelableArrayList("listOrder");

        binding.tvSumPriceCart.setText(sumPrice);

        ItemLoLAdapter adapter = new ItemLoLAdapter(listOrder, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        binding.rcvListOrder.setAdapter(adapter);
        binding.rcvListOrder.setLayoutManager(layoutManager);

        //set dialog cho button Confirm
        dialogConfirm = new Dialog(getContext());
        dialogConfirm.setContentView(R.layout.dialog_confirm_pay);
        dialogConfirm.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.background_dialog_dangky));
        dialogConfirm.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogConfirm.setCancelable(true);
        dialogConfirm.getWindow().getAttributes().windowAnimations = R.style.animation;
        MappingsDialogConfirm();

        //set dialog cho button Cancel
        dialogCancel = new Dialog(getContext());
        dialogCancel.setContentView(R.layout.dialog_cancel_pay);
        dialogCancel.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.background_dialog_dangky));
        dialogCancel.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogCancel.setCancelable(true);
        dialogCancel.getWindow().getAttributes().windowAnimations = R.style.animation;
        MappingsDialogCancel();

        progressBar.setVisibility(View.INVISIBLE);
        progressBarCancel.setVisibility(View.INVISIBLE);
        binding.btnConfirmPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvQuestionConfirm.setText("Xác nhận thanh toán " + binding.tvSumPriceCart.getText().toString() + " $ cho đơn hàng?");
                dialogConfirm.show();

            }
        });

        btnConfirmYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                        binding.tvSumPriceCart.setText("000000");
                        listOrder.clear();
                        adapter.notifyDataSetChanged();
                        Toast.makeText(getContext(), "Xác nhận thanh toán đơn hàng thành công.", Toast.LENGTH_SHORT).show();
                        dialogConfirm.dismiss();
                    }
                }, 2500);
            }
        });
        btnConfirmNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogConfirm.dismiss();
            }
        });

        binding.btnCancelPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvQuestionCancel.setText("Quý khách muốn huỷ toàn bộ đơn hàng và order lại?");
                dialogCancel.show();
            }
        });
        btnCancelYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarCancel.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBarCancel.setVisibility(View.INVISIBLE);
                        listOrder.clear();
                        binding.tvSumPriceCart.setText("000000");
                        dialogCancel.dismiss();
                        Toast.makeText(getContext(), "Đơn hàng đã được huỷ. Màn hình sẽ chuyển hướng trong 3s", Toast.LENGTH_LONG).show();
                        adapter.notifyDataSetChanged();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Fragment fragment = ShoppingFragment.newInstance();
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
                            }
                        },3500);

                    }
                }, 2500);
            }
        });
        btnCancelNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCancel.dismiss();
            }
        });



        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = ShoppingFragment.newInstance();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
            }
        });

        return binding.getRoot();
    }

    private void MappingsDialogCancel() {
        btnCancelYes = dialogCancel.findViewById(R.id.btn_cancel_yes);
        btnCancelNo = dialogCancel.findViewById(R.id.btn_cancel_no);
        progressBarCancel = dialogCancel.findViewById(R.id.progress_bar_cancel);
        tvQuestionCancel = dialogCancel.findViewById(R.id.tv_question_pay_cancel);
    }

    private void MappingsDialogConfirm() {
        btnConfirmYes = dialogConfirm.findViewById(R.id.btn_confirm_yes);
        btnConfirmNo = dialogConfirm.findViewById(R.id.btn_confirm_no);
        progressBar = dialogConfirm.findViewById(R.id.progress_bar_confirm);
        tvQuestionConfirm = dialogConfirm.findViewById(R.id.tv_question_pay_confirm);
    }
}
