package com.example.leagueoflegendsshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LeagueOfLegendsItemShop extends AppCompatActivity {
    RecyclerView rcvLoLItem;
    List<LeagueOfLegendsItem> listMenu;
    List<LeagueOfLegendsItem> listCart;

    TextView tvAmountOrder, tvPay, tvSumAmount;
    ImageView imgLogoCart, imgLogOut;
    Dialog dialogLogOut;
    Button btnLogOutYes, btnLogOutNo;
    TextView tvQuestionLogOut;
    ProgressBar progressBarLogOut;
    CheckBox cbSavePassword;
    EditText edtUser, edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_of_legends_item_shop);
        listMenu = new ArrayList<>();
        listCart = new ArrayList<>();

        tvPay = (TextView) findViewById(R.id.tvPay);
        tvSumAmount = (TextView) findViewById(R.id.tvSumAmount);
        imgLogoCart = (ImageView) findViewById(R.id.imgLogoCart);
        imgLogOut = (ImageView) findViewById(R.id.imgTurnOff);
        cbSavePassword = (CheckBox) findViewById(R.id.cbSaveAccount);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);


        // cần phải intent checkBox bên MainActivity
//        if(cbSavePassword.isChecked()){
//            edtUser.setText(edtUser.getText());
//            edtPass.setText(edtPass.getText());
//        }  else {
//            edtUser.setText(edtUser.getText());
//            edtPass.setText("");
//        }


        rcvLoLItem = (RecyclerView) findViewById(R.id.rcvLoLItem);
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_01,"Búa Rìu Sát Thần", "MFG: 06/03/2020", 3300, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_02,"Chuỳ Hấp Huyết", "MFG: 19/05/2020", 3300, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_03,"Cuồng Cung", "MFG: 30/04/2020", 2800, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_04,"Dạ Kiếm Draktharr", "MFG: 01/05/2020", 3200, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_05,"Đồng Hồ Cát", "MFG: 08/03/2020", 2900, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_06,"Huyết Kiếm", "MFG: 20/11/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_07,"Lưỡi Hái Bóng Đêm", "MFG: 10/03/2020", 3200, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_08,"Ma Vũ Song Kiếm", "MFG: 22/12/2020", 2900, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_09,"Móc Diệt Thuỷ Quái", "MFG: 02/09/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_10,"Móng Vuốt Sterak", "MFG: 03/02/2020", 3100, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_11,"Nanh Nashor", "MFG: 26/03/2020", 3000, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_12,"Quỷ Thư Morello", "MFG: 01/06/2020", 2500, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_13,"Súng Hải Tặc", "MFG: 22/12/2020", 3000, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_14,"Tam Hợp Kiếm", "MFG: 23/12/2020", 3333, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_15,"Thương Phục Hận", "MFG: 27/02/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_16,"Tim Băng", "MFG: 19/08/2020", 2700, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_17,"Vô Cực Kiếm", "MFG: 15/08/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        listMenu.add(new LeagueOfLegendsItem(R.drawable.item_18,"Bão Tố Luden", "MFG: 27/07/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));

        ItemLoLAdapter itemLoLAdapter = new ItemLoLAdapter(listMenu, LeagueOfLegendsItemShop.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LeagueOfLegendsItemShop.this, RecyclerView.VERTICAL, false);

        rcvLoLItem.setLayoutManager(layoutManager);
        rcvLoLItem.setAdapter(itemLoLAdapter);

        itemLoLAdapter.setmIWhenClickItem(new IWhenClickItem() {
            @Override
            public void clickPlusItem(LeagueOfLegendsItem leagueOfLegendsItem) {
                int sumAmount = Integer.parseInt(tvSumAmount.getText().toString());
                int sumPay = Integer.parseInt(tvPay.getText().toString());
                sumAmount += 1;
                sumPay += leagueOfLegendsItem.getPrice();
                tvSumAmount.setText(String.valueOf(sumAmount));
                tvPay.setText(String.valueOf(sumPay));

                if (listCart.contains(leagueOfLegendsItem)){
                    leagueOfLegendsItem.setAmountOrder(leagueOfLegendsItem.getAmountOrder() + 1);
                    itemLoLAdapter.notifyDataSetChanged();
                } else {
                    listCart.add(leagueOfLegendsItem);
                    leagueOfLegendsItem.setAmountOrder(leagueOfLegendsItem.getAmountOrder() + 1);
                    itemLoLAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void clickMinusItem(LeagueOfLegendsItem leagueOfLegendsItem) {
                int sumAmount = Integer.parseInt(tvSumAmount.getText().toString());
                int sumPay = Integer.parseInt(tvPay.getText().toString());
                sumAmount -= 1;
                sumPay -= leagueOfLegendsItem.getPrice();
                tvSumAmount.setText(String.valueOf(sumAmount));
                tvPay.setText(String.valueOf(sumPay));

                if (listCart.contains(leagueOfLegendsItem)){
                    leagueOfLegendsItem.setAmountOrder(leagueOfLegendsItem.getAmountOrder() - 1);
                    itemLoLAdapter.notifyDataSetChanged();
                } else {
                    listCart.add(leagueOfLegendsItem);
                    leagueOfLegendsItem.setAmountOrder(leagueOfLegendsItem.getAmountOrder() - 1);
                    itemLoLAdapter.notifyDataSetChanged();
                }
            }
        });
        imgLogoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOrder = new Intent(LeagueOfLegendsItemShop.this, PayYourCart.class);
                intentOrder.putExtra("sumPrice", tvPay.getText().toString());
                intentOrder.putParcelableArrayListExtra("listOrder", (ArrayList<? extends Parcelable>) listCart);
                startActivity(intentOrder);
            }
        });

        dialogLogOut = new Dialog(LeagueOfLegendsItemShop.this);
        dialogLogOut.setContentView(R.layout.dialog_log_out);
        dialogLogOut.setCancelable(false);
        dialogLogOut.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_dialog_dangky));
        dialogLogOut.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogLogOut.getWindow().getAttributes().windowAnimations = R.style.animation;

        tvQuestionLogOut = (TextView) dialogLogOut.findViewById(R.id.tvQuestionLogOut);
        btnLogOutYes = (Button) dialogLogOut.findViewById(R.id.btnLogOutYes);
        btnLogOutNo = (Button) dialogLogOut.findViewById(R.id.btnLogOutNo);
        progressBarLogOut = (ProgressBar) dialogLogOut.findViewById(R.id.progressBarLogOut);

        progressBarLogOut.setVisibility(View.INVISIBLE);

        imgLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvQuestionLogOut.setText("Quý khách chắc chắn muốn đăng xuất khỏi tài khoản?");
                dialogLogOut.show();
            }
        });

        btnLogOutYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarLogOut.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBarLogOut.setVisibility(View.INVISIBLE);
                        dialogLogOut.dismiss();
                        Intent intentLogOut = new Intent(LeagueOfLegendsItemShop.this, MainActivity.class);
                        startActivity(intentLogOut);
                    }
                },3000);
            }
        });

        btnLogOutNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLogOut.dismiss();
            }
        });
    }

}