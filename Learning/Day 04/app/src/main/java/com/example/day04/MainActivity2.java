package com.example.day04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    TextView tvName, tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Mappings();

        Intent intent = getIntent(); //nhận intent bên Activity 01

//        String name = intent.getStringExtra("name"); // biến name sẽ nhận thông tin tên
//        int age = intent.getIntExtra("age", 0);

//        tvName.setText(name);
//        tvAge.setText(String.valueOf(age));

        Person person = intent.getParcelableExtra("object");
        tvName.setText(person.getName());
        tvAge.setText(String.valueOf(person.getAge()));

        List<Person> list = new ArrayList<>();
        list = intent.getParcelableArrayListExtra("list");
        for (Person x:list
             ) {
            Log.d("listPerson", x.toString());
        }



    }

    private void Mappings() {
        tvName = (TextView) findViewById(R.id.tvName);
        tvAge = (TextView) findViewById(R.id.tvAge);
    }
}