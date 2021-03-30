package com.example.day09ver01;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static RecyclerView recyclerView;
    private static List<ItemBook> list;
    private static ItemBookAdapter adapter;
    private static final String URL = "https://bookshopb.herokuapp.com/api/books";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        recyclerView = findViewById(R.id.recycler_view);
        list = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        StringRequest getAllBook = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String arrayBook = response;
                try {
                    JSONArray jsonArray = new JSONArray(arrayBook);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String title = jsonObject.getString("title");
                        String imgLink = jsonObject.getString("imageLink");
                        String author = jsonObject.getString("author");
                        long price = jsonObject.getLong("price");
                        long rateStar = jsonObject.getLong("rateStar");
                        String description = jsonObject.getString("description");
                        long numOfReview = jsonObject.getLong("numOfReview");
                        float rate = (float) rateStar / numOfReview;
                        String categoty = jsonObject.getString("categoty");
                        long numOfPage = jsonObject.getLong("numOfPage");

                        list.add(new ItemBook(title, imgLink, author, price, rate, description, numOfReview, categoty, numOfPage));
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
                        adapter = new ItemBookAdapter(list, MainActivity.this);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(adapter);

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "No Internet.", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(getAllBook);


    }
}