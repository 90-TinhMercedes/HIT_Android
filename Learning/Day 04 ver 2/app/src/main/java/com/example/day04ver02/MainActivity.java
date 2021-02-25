package com.example.day04ver02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtAge;
    private Button btnSubmit;
    private String name;
    private int age;
    private RecyclerView rcChampLoL;
    private ChampLoLAdapter adapter;
    private List<ChampLoL> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mappings();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtName.getText().toString().isEmpty() && edtAge.getText().toString().isEmpty()){
                    edtName.setError("Nhập tên.");
                    edtAge.setError("Nhập tuổi.");
                    Toast.makeText(MainActivity.this, "Nhập đủ thông tin.", Toast.LENGTH_SHORT).show();
                } else if (edtAge.getText().toString().isEmpty()){
                    edtAge.setError("Nhập tuổi.");
                } else if (edtName.getText().toString().isEmpty()){
                    edtName.setError("Nhập tên.");
                }
                else {
                    name = edtName.getText().toString().trim();
                    age = Integer.parseInt(edtAge.getText().toString().trim());
                    Intent intent = new Intent(MainActivity.this, IntentEvent.class);
                    intent.putExtra("name", name);
                    intent.putExtra("age", age);
                    startActivity(intent);
                }
            }
        });

        list = new ArrayList<>();
        list.add(new ChampLoL(R.drawable.logo_lol, "Katarina", "Ác Kiếm"));
        list.add(new ChampLoL(R.drawable.logo_lol, "Katarina", "Ác Kiếm"));
        list.add(new ChampLoL(R.drawable.logo_lol, "Katarina", "Ác Kiếm"));
        list.add(new ChampLoL(R.drawable.logo_lol, "Katarina", "Ác Kiếm"));
        list.add(new ChampLoL(R.drawable.logo_lol, "Katarina", "Ác Kiếm"));
        list.add(new ChampLoL(R.drawable.logo_lol, "Katarina", "Ác Kiếm"));
        list.add(new ChampLoL(R.drawable.logo_lol, "Katarina", "Ác Kiếm"));
        list.add(new ChampLoL(R.drawable.logo_lol, "Katarina", "Ác Kiếm"));
        list.add(new ChampLoL(R.drawable.logo_lol, "Katarina", "Ác Kiếm"));
        list.add(new ChampLoL(R.drawable.logo_lol, "Katarina", "Ác Kiếm"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        adapter = new ChampLoLAdapter(list, MainActivity.this);

        rcChampLoL.setAdapter(adapter);
        rcChampLoL.setLayoutManager(layoutManager);

        adapter.setWhenClickItem(new WhenClickItem() {
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

    private void Mappings() {
        edtName = (EditText) findViewById(R.id.edtName);
        edtAge = (EditText) findViewById(R.id.edtAge);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        rcChampLoL = (RecyclerView) findViewById(R.id.rcChampLoL);
    }
}