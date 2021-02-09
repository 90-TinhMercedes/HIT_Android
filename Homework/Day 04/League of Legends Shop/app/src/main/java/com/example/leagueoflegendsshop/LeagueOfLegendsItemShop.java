package com.example.leagueoflegendsshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class LeagueOfLegendsItemShop extends AppCompatActivity {
    RecyclerView rcvLoLItem;
    List<LeagueOfLegendsItem> list = new ArrayList<>();

    TextView tvAmountOrder, tvPrice, tvPay, tvSumAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_of_legends_item_shop);

        rcvLoLItem = (RecyclerView) findViewById(R.id.rcvLoLItem);
        list.add(new LeagueOfLegendsItem(R.drawable.item_01,"Búa Rìu Sát Thần", "MFG: 06/07/2020", 3300, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_02,"Chuỳ Hấp Huyết", "MFG: 27/07/2020", 3300, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_03,"Cuồng Cung", "MFG: 27/07/2020", 2800, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_04,"Dạ Kiếm Draktharr", "MFG: 27/07/2020", 3200, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_05,"Đồng Hồ Cát", "MFG: 27/07/2020", 2900, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_06,"Huyết Kiếm", "MFG: 27/07/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_07,"Lưỡi Hái Bóng Đêm", "MFG: 27/07/2020", 3200, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_08,"Ma Vũ Song Kiếm", "MFG: 27/07/2020", 2900, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_09,"Móc Diệt Thuỷ Quái", "MFG: 27/07/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_10,"Móng Vuốt Sterak", "MFG: 27/07/2020", 3100, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_11,"Nanh Nashor", "MFG: 27/07/2020", 3000, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_12,"Quỷ Thư Morello", "MFG: 27/07/2020", 2500, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_13,"Súng Hải Tặc", "MFG: 27/07/2020", 3000, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_14,"Tam Hợp Kiếm", "MFG: 27/07/2020", 3333, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_15,"Thương Phục Hận", "MFG: 27/07/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_16,"Tim Băng", "MFG: 27/07/2020", 2700, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_17,"Vô Cực Kiếm", "MFG: 27/07/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));
        list.add(new LeagueOfLegendsItem(R.drawable.item_18,"Vọng Âm Luden", "MFG: 27/07/2020", 3400, 0, R.drawable.dollars, R.drawable.plus_item, R.drawable.minus_item));

        ItemLoLAdapter itemLoLAdapter = new ItemLoLAdapter(list, LeagueOfLegendsItemShop.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LeagueOfLegendsItemShop.this, RecyclerView.VERTICAL, false);

        rcvLoLItem.setLayoutManager(layoutManager);
        rcvLoLItem.setAdapter(itemLoLAdapter);

        itemLoLAdapter.setWhenClickItem(new WhenClickItem() {
            @Override
            public void clickPlusItem(LeagueOfLegendsItem leagueOfLegendsItem) {

                Toast.makeText(LeagueOfLegendsItemShop.this, "Plus", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickMinusItem(LeagueOfLegendsItem leagueOfLegendsItem) {
                Toast.makeText(LeagueOfLegendsItemShop.this, "Minus", Toast.LENGTH_SHORT).show();
            }
        });

    }


}