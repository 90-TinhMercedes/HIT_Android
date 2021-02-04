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

    ListView listView;
    RecyclerView rcStudents;
    List<ChampLoL> list = new ArrayList<>();
    RecyclerView rcChampLoL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        listView = (ListView) findViewById(R.id.listView);
//        List<String> list = new ArrayList<>();
//        list.add("Tình");
//        list.add("Nam");
//        list.add("Tùng");
//        list.add("Tâm");
//        list.add("Oanh");
//        list.add("Tình");
//        list.add("Nam");
//        list.add("Tùng");
//        list.add("Tâm");
//        list.add("Oanh");
//        list.add("Tình");
//        list.add("Nam");
//        list.add("Tùng");
//        list.add("Tâm");
//        list.add("Oanh");
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, list.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });

        rcChampLoL = (RecyclerView) findViewById(R.id.rcChampLoL);
        list.add(new ChampLoL(R.drawable.ic_launcher_background, "Veigar", "Tiểu Quỷ"));
        list.add(new ChampLoL(R.drawable.ic_launcher_background, "Yasuo", "Tiểu Quỷ"));
        list.add(new ChampLoL(R.drawable.ic_launcher_background, "Zed", "Tiểu Quỷ"));
        list.add(new ChampLoL(R.drawable.ic_launcher_background, "Master Yi", "Tiểu Quỷ"));
        list.add(new ChampLoL(R.drawable.ic_launcher_background, "Yone", "Tiểu Quỷ"));

        ChampAdapter champAdapter = new ChampAdapter(list, MainActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2, RecyclerView.HORIZONTAL, false);

        rcChampLoL.setLayoutManager(layoutManager);
        rcChampLoL.setAdapter(champAdapter);
        champAdapter.setWhenOnClickItem(new WhenOnClickItem() {
            @Override
            public void onClickImage(ChampLoL champLoL) {
                Toast.makeText(MainActivity.this, champLoL.getAvatar(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickChamp(ChampLoL champLoL) {
                Toast.makeText(MainActivity.this, champLoL.getChamp(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCLickInfo(ChampLoL champLoL) {
                Toast.makeText(MainActivity.this, champLoL.getInfo(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}