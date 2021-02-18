package com.example.day04ver02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcChampLoL;
    private ChampLoLAdapter champLoLAdapter;
    private List<ChampLoL> champLoLList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcChampLoL = findViewById(R.id.rcChampLoL);
        champLoLList = new ArrayList<>();
        champLoLList.add(new ChampLoL(R.drawable.logo_lol, "Yasuo", "Kẻ Bất Dung Thứ"));
        champLoLList.add(new ChampLoL(R.drawable.logo_lol, "Yasuo", "Kẻ Bất Dung Thứ"));
        champLoLList.add(new ChampLoL(R.drawable.logo_lol, "Yasuo", "Kẻ Bất Dung Thứ"));
        champLoLList.add(new ChampLoL(R.drawable.logo_lol, "Yasuo", "Kẻ Bất Dung Thứ"));
        champLoLList.add(new ChampLoL(R.drawable.logo_lol, "Yasuo", "Kẻ Bất Dung Thứ"));
        champLoLList.add(new ChampLoL(R.drawable.logo_lol, "Yasuo", "Kẻ Bất Dung Thứ"));
        champLoLList.add(new ChampLoL(R.drawable.logo_lol, "Yasuo", "Kẻ Bất Dung Thứ"));
        champLoLList.add(new ChampLoL(R.drawable.logo_lol, "Yasuo", "Kẻ Bất Dung Thứ"));
        champLoLList.add(new ChampLoL(R.drawable.logo_lol, "Yasuo", "Kẻ Bất Dung Thứ"));
        champLoLList.add(new ChampLoL(R.drawable.logo_lol, "Yasuo", "Kẻ Bất Dung Thứ"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        champLoLAdapter = new ChampLoLAdapter(champLoLList, MainActivity.this);

        rcChampLoL.setLayoutManager(layoutManager);
        rcChampLoL.setAdapter(champLoLAdapter);

        champLoLAdapter.setWhenClickItem(new WhenClickItem() {
            @Override
            public void clickAvatar(ChampLoL champLoL) {
                Toast.makeText(MainActivity.this, "League of Legends", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickChamp(ChampLoL champLoL) {
                Toast.makeText(MainActivity.this, champLoL.getChamp(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickInfo(ChampLoL champLoL) {
                Toast.makeText(MainActivity.this, champLoL.getInfo(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}