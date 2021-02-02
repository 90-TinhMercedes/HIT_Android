package com.example.day04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtAge;
    Button btnSubmit, btnAction;
    String name;
    int age;
    List<Person> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mappings();

        list.add(new Person("Tình", 20));
        list.add(new Person("Tâm", 20));
        list.add(new Person("Nam", 20));
        list.add(new Person("Tùng", 20));


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edtName.getText().toString();
                age = Integer.parseInt(edtAge.getText().toString());
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                intent.putExtra("name", name);
//                intent.putExtra("age", age);

                Person person = new Person(name, age);
                intent.putExtra("object", (Parcelable) person); // put một đối tượng
                intent.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) list); // put một list đối tượng


                startActivity(intent);

            }
        });

    }

    private void Mappings() {
        edtName = (EditText) findViewById(R.id.edtName);
        edtAge = (EditText) findViewById(R.id.edtAge);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnAction = (Button) findViewById(R.id.btnAction);
    }
}