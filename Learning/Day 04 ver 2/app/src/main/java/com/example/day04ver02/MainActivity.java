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

    private ChampAdapter adapter;
    private List<ChampLoL> list;
    RecyclerView rcChamp;

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

        rcChamp = findViewById(R.id.rcChampLoL);
        list = new ArrayList<>();
        list.add(new ChampLoL(R.drawable.logo_lol, "Veigar", "Bậc Thầy Tiểu Quỷ"));
        list.add(new ChampLoL(R.drawable.logo_lol, "Yasuo", "Kẻ Bất Dung Thứ"));
        list.add(new ChampLoL(R.drawable.logo_lol, "Zed", "Chúa Tể Bóng Tối"));
        list.add(new ChampLoL(R.drawable.logo_lol, "Teemo", "Trinh sát nhanh nhẹn"));
        list.add(new ChampLoL(R.drawable.logo_lol, "Katarina", "Ác Kiếm"));

        adapter = new ChampAdapter(list, MainActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);

        rcChamp.setLayoutManager(layoutManager);
        rcChamp.setAdapter(adapter);

        adapter.setWhenClickItem(new WhenClickItem() {
            @Override
            public void onClickImage(ChampLoL champLoL) {
                Toast.makeText(MainActivity.this, champLoL.getAvatar(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCLickChamp(ChampLoL champLoL) {
                Toast.makeText(MainActivity.this, champLoL.getChamp(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickInfo(ChampLoL champLoL) {
                Toast.makeText(MainActivity.this, champLoL.getInfo(), Toast.LENGTH_SHORT).show();
            }
        });




    }
}