package com.example.bookstorebasic;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bookstorebasic.interfaceinteract.IOnClickMenuItem;
import com.example.bookstorebasic.listbookandadapter.MenuBook;
import com.example.bookstorebasic.listbookandadapter.MenuBookAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static RecyclerView recyclerView;
    private static MenuBookAdapter adapter;
    private static List<MenuBook> list;
    private static final String URL = "https://bookshopb.herokuapp.com/api/books";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        recyclerView = findViewById(R.id.rcv_menu);
        list = new ArrayList<>();
        adapter = new MenuBookAdapter(list, MainActivity.this);

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String arrayMenuBook = response;
                try {
                    JSONArray jsonArray = new JSONArray(arrayMenuBook);
                    for(int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String imgLink = jsonObject.getString("imageLink");
                        String title = jsonObject.getString("title");
                        String author = jsonObject.getString("author");
                        long price = jsonObject.getLong("price");
                        long rateStar = jsonObject.getLong("rateStar");
                        String description = jsonObject.getString("description");
                        long numOfReview = jsonObject.getLong("numOfReview");
                        float rate = (float) rateStar / numOfReview;
                        String categoty = jsonObject.getString("categoty");
                        long numOfPage = jsonObject.getLong("numOfPage");

                        list.add(new MenuBook(imgLink, title, author, price, rate, description, numOfReview, categoty, numOfPage));
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
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

            }
        });
        requestQueue.add(stringRequest);

        adapter.setmIOnClickMenuItem(new IOnClickMenuItem() {
            @Override
            public void iClickItem(MenuBook item) {
                Intent intentInformationBook = new Intent(MainActivity.this, InformationBook.class);
                intentInformationBook.putExtra("titleBook", item.getMenuTitleBook());
                intentInformationBook.putExtra("imgBookLink", item.getImgLink());
                intentInformationBook.putExtra("authorBook", item.getAuthor());
                intentInformationBook.putExtra("priceBook", item.getPrice());
                intentInformationBook.putExtra("rateBook", item.getRateStar());
                intentInformationBook.putExtra("descriptionBook", item.getDescription());
                intentInformationBook.putExtra("numOfReviewBook", item.getNumOfReview());
                intentInformationBook.putExtra("categoryBook", item.getCategoty());
                intentInformationBook.putExtra("numOfPageBook", item.getNumOfPage());
                startActivity(intentInformationBook);
            }
        });


//        adapter = new MenuBookAdapter(list, MainActivity.this);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);




    }


}