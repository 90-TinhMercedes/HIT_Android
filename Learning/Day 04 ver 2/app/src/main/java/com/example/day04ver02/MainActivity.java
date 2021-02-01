package com.example.day04ver02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    RecyclerView rcStudents;
    List<Student> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        listView = (ListView) findViewById(R.id.lvDemo);
//
//        List<String> list= new ArrayList<>();
//        list.add("Diep");
//        list.add("Doan");
//        list.add("Trung");
//        list.add("Linh");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, list.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });


        rcStudents = (RecyclerView) findViewById(R.id.rcStudents);
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi Tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi Tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi Tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi tinh"));
        list.add(new Student(R.drawable.ic_launcher_background, "445555", "Chi tinh"));

        StudentAdapter adapter = new StudentAdapter(list, MainActivity.this);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2, RecyclerView.VERTICAL, false);

        rcStudents.setLayoutManager(layoutManager);
        rcStudents.setAdapter(adapter);
        adapter.setWhenOnClickItem(new WhenOnClickItem() {
            @Override
            public void onClickImage(Student student) {
                Toast.makeText(MainActivity.this, student.getAvatar(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickName(Student student) {
                Toast.makeText(MainActivity.this, student.getName(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}