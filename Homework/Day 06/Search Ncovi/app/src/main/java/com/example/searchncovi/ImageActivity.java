package com.example.searchncovi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity {
    String urlImage = "https://girl.trungbt.xyz/api?page=";
    List<LinkImage> listLink = new ArrayList<>();
    ImageView imageView, imgPlus, imgMinus;
    TextView tvTip01, tvTip02, tvTip03;
    int index;
    Button btnSelect;
    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Mappings();
        imgMinus.setVisibility(View.INVISIBLE);
        imgPlus.setVisibility(View.INVISIBLE);

//        RequestQueue requestQueue = Volley.newRequestQueue(getBaseContext());
//        StringRequest getAllLinkImage = new StringRequest(Request.Method.GET, urlImage + page, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    JSONArray jsonArray = jsonObject.getJSONArray("data");
//                    jsonArray.length();
//                    Log.d("TAG jsonArray", String.valueOf(jsonArray.length()));
//
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject json = jsonArray.getJSONObject(i);
//                        String link = json.getString("image_url");
////                        Log.d("Tag link", link);
//                        LinkImage linkImage = new LinkImage(link);
////                        Log.d("LinkImage", linkImage.toString());
//                        listLink.add(linkImage);
//                        listLink.size();
////                        for (LinkImage item : listLink){
////                            Log.d("checkLink", item.toString());
////                        }
////                        Log.d("SizeListLink", listLink.size() + "");
//
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(getAllLinkImage);

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgMinus.setVisibility(View.VISIBLE);
                imgPlus.setVisibility(View.VISIBLE);
                tvTip01.setVisibility(View.INVISIBLE);
                tvTip02.setVisibility(View.INVISIBLE);
                tvTip03.setVisibility(View.INVISIBLE);
                RequestQueue requestQueue = Volley.newRequestQueue(getBaseContext());
                StringRequest getAllLinkImage = new StringRequest(Request.Method.GET, urlImage + page, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            jsonArray.length();
                            Log.d("TAG jsonArray", String.valueOf(jsonArray.length()));

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json = jsonArray.getJSONObject(i);
                                String link = json.getString("image_url");
//                        Log.d("Tag link", link);
                                LinkImage linkImage = new LinkImage(link);
//                        Log.d("LinkImage", linkImage.toString());
                                listLink.add(linkImage);
                                listLink.size();
//                        for (LinkImage item : listLink){
//                            Log.d("checkLink", item.toString());
//                        }
//                        Log.d("SizeListLink", listLink.size() + "");

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
                requestQueue.add(getAllLinkImage);
//                new loadImageInternet().execute(listLink.get(0).getImage_url());
                if (page <= 5) {
                    page += 1;
                }
                Toast.makeText(ImageActivity.this, "Loading pictures...", Toast.LENGTH_LONG).show();
            }
        });

        imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == listLink.size() - 1) {
                    index = 0;
                } else {
                    index += 1;
                }
                new loadImageInternet().execute(listLink.get(index).getImage_url());
            }
        });

        imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == 0) {
                    index = listLink.size() - 1;
                } else {
                    index -= 1;
                }
                new loadImageInternet().execute(listLink.get(index).getImage_url());
            }
        });


    }

    private class loadImageInternet extends AsyncTask<String, Void, Bitmap> {
        Bitmap bitmapImage = null;

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                bitmapImage = BitmapFactory.decodeStream(inputStream);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmapImage;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }

    private void Mappings() {
        imageView = findViewById(R.id.image);
        imgMinus = findViewById(R.id.image_minus);
        imgPlus = findViewById(R.id.image_plus);
        btnSelect = findViewById(R.id.btn_select);
        tvTip01 = findViewById(R.id.tv_tips_01);
        tvTip02 = findViewById(R.id.tv_tips_02);
        tvTip03 = findViewById(R.id.tv_tips_03);
    }
}