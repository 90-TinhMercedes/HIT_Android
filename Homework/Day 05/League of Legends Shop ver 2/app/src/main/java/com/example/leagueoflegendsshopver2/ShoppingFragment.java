package com.example.leagueoflegendsshopver2;

import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import com.example.leagueoflegendsshopver2.databinding.FragmentShoppingBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ShoppingFragment extends Fragment {
    ItemLoLAdapter adapter;
    FragmentShoppingBinding binding;
    List<LeagueOfLegendsItem> listItem;
    List<LeagueOfLegendsItem> listOrder;
    Dialog dialogLoadData, dialogLoadDataShop;
    TextView tvLoadData, tvLoadDataShop;
    ProgressBar progressBarLoadData, progressBarLoadDataShop;


    public static ShoppingFragment newInstance() {

        Bundle args = new Bundle();

        ShoppingFragment fragment = new ShoppingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shopping, container, false);
        listItem = new ArrayList<>();
        listOrder = new ArrayList<>();

        dialogLoadDataShop = new Dialog(getContext());
        dialogLoadDataShop.setContentView(R.layout.dialog_load_shop);
        dialogLoadDataShop.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.background_dialog_dangky));
        dialogLoadDataShop.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogLoadDataShop.setCancelable(false);
        dialogLoadDataShop.getWindow().getAttributes().windowAnimations = R.style.animation;
        MappingsDialogLoadDataShop();
        dialogLoadDataShop.show();
        CountDownTimer countDownTimer = new CountDownTimer(5000, 40) {
            @Override
            public void onTick(long millisUntilFinished) {
                int current = progressBarLoadDataShop.getProgress();
                progressBarLoadDataShop.setProgress(current + 1);
                int percentLoad = Integer.parseInt(tvLoadDataShop.getText().toString()) + 1;
                if (percentLoad >= 101){
                    tvLoadDataShop.setText("100");
                } else {
                    tvLoadDataShop.setText(String.valueOf(percentLoad));
                }

            }

            @Override
            public void onFinish() {
                Toast.makeText(getContext(), "Welcome to League of Legends Shop!", Toast.LENGTH_SHORT).show();
                dialogLoadDataShop.dismiss();
            }
        };
        countDownTimer.start();

        listItem.add(new LeagueOfLegendsItem(R.drawable.item_01, "Búa Rìu Sát Thần", "MFG: 06/03/2001", 3300, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_02, "Chuỳ Hấp Huyết", "MFG: 19/05/2020", 3300, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_03, "Cuồng Cung", "MFG: 30/04/2020", 2800, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_04, "Dạ Kiếm Draktharr", "MFG: 01/05/2020", 3200, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_05, "Đồng Hồ Cát", "MFG: 08/03/2020", 2900, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_06, "Huyết Kiếm", "MFG: 20/11/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_07, "Lưỡi Hái Bóng Đêm", "MFG: 10/03/2020", 3200, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_08, "Ma Vũ Song Kiếm", "MFG: 22/12/2020", 2900, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_09, "Móc Diệt Thuỷ Quái", "MFG: 02/09/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_10, "Móng Vuốt Sterak", "MFG: 03/02/2020", 3100, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_11, "Nanh Nashor", "MFG: 26/03/2020", 3000, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_12, "Quỷ Thư Morello", "MFG: 01/06/2020", 2500, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_13, "Súng Hải Tặc", "MFG: 22/12/2020", 3000, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_14, "Tam Hợp Kiếm", "MFG: 23/12/2020", 3333, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_15, "Thương Phục Hận", "MFG: 27/02/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_16, "Tim Băng", "MFG: 19/08/2020", 2700, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_17, "Vô Cực Kiếm", "MFG: 15/08/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listItem.add(new LeagueOfLegendsItem(R.drawable.item_18, "Bão Tố Luden", "MFG: 27/07/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));

        adapter = new ItemLoLAdapter(listItem, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        binding.rcvLolItems.setAdapter(adapter);
        binding.rcvLolItems.setLayoutManager(layoutManager);
        adapter.setmIClickItem(new IClickItem() {
            @Override
            public void clickPlusItem(LeagueOfLegendsItem item) {
                int sumAmountOrder = Integer.parseInt(binding.tvSumAmount.getText().toString());
                int sumPrice = Integer.parseInt(binding.tvSumPrice.getText().toString());
                sumAmountOrder += 1;
                sumPrice += item.getPrice();
                binding.tvSumAmount.setText(String.valueOf(sumAmountOrder));
                binding.tvSumPrice.setText(String.valueOf(sumPrice));
                if (!listOrder.contains(item)) {
                    listOrder.add(item);
                }
                item.setAmountOrder(item.getAmountOrder() + 1);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void clickMinusItem(LeagueOfLegendsItem item) {
                int sumAmountOrder = Integer.parseInt(binding.tvSumAmount.getText().toString());
                int sumSumPrice = Integer.parseInt(binding.tvSumPrice.getText().toString());
                sumAmountOrder -= 1;
                sumSumPrice -= item.getPrice();
                binding.tvSumAmount.setText(String.valueOf(sumAmountOrder));
                binding.tvSumPrice.setText(String.valueOf(sumSumPrice));
                if (!listOrder.contains(item)) {
                    listOrder.add(item);
                }
                item.setAmountOrder(item.getAmountOrder() - 1);
                adapter.notifyDataSetChanged();
            }
        });

        dialogLoadData = new Dialog(getContext());
        dialogLoadData.setContentView(R.layout.dialog_load_cart);
        dialogLoadData.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.background_dialog_dangky));
        dialogLoadData.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogLoadData.setCancelable(false);
        dialogLoadData.getWindow().getAttributes().windowAnimations = R.style.animation;
        MappingsDialogLoadData();

        binding.imgLogoYourCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLoadData.show();
                CountDownTimer countDownTimer = new CountDownTimer(5000, 40) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = progressBarLoadData.getProgress();
                        progressBarLoadData.setProgress(current + 1);
                        int percentLoad = Integer.parseInt(tvLoadData.getText().toString()) + 1;
                        if (percentLoad >= 101){
                            tvLoadData.setText("100");
                        } else {
                            tvLoadData.setText(String.valueOf(percentLoad));
                        }
                    }

                    @Override
                    public void onFinish() {
                        dialogLoadData.dismiss();
                        Fragment fragment = CartFragment.newInstance(binding.tvSumPrice.getText().toString(), listOrder);
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
                    }
                };
                countDownTimer.start();
            }
        });



        return binding.getRoot();
    }

    private void MappingsDialogLoadDataShop() {
        progressBarLoadDataShop = dialogLoadDataShop.findViewById(R.id.progress_load_data_shop);
        tvLoadDataShop = dialogLoadDataShop.findViewById(R.id.tv_percent_load_shop);
    }

    private void MappingsDialogLoadData() {
        progressBarLoadData = dialogLoadData.findViewById(R.id.progress_load_data);
        tvLoadData = dialogLoadData.findViewById(R.id.tv_percent);
    }

}
