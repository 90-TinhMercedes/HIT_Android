package com.example.day06ver02;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
    private static Button btnGet, btnPost, btnPut, btnDelete;
    private static TextView tvResult;
    private static final String URL = "https://demo-b5.herokuapp.com/api/accounts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mappings();
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tvResult.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvResult.setText("404 Not Found!!");
                    }
                });
                requestQueue.add(stringRequest);
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("username", "90_TinhMercedes");
                    jsonObject.put("password", "E cột thêm con pet nữa ở đây, lát học lớp Android xong em qua đón, mọi người" +
                            "đừng đuổi nó đi nhé :v <3");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String requestBody = jsonObject.toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tvResult.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvResult.setText("404 Not Found!!");
                    }
                })
                {
                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset = utf-8";
                    }

                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        if (requestBody == null) return null;
                        else {
                            try {
                                return requestBody.getBytes("utf-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }
                };
                requestQueue.add(stringRequest);
            }
        });
        btnPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("password", "E cột thêm con pet nữa ở đây, lát học lớp Android xong em qua đón, mọi người " +
                            "đừng đuổi nó đi nhé :v <3");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String requestBody = jsonObject.toString();
                StringRequest stringRequest = new StringRequest(Request.Method.PATCH, URL + "/51", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tvResult.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvResult.setText("404 Not Found!!");
                    }
                })
                {
                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset = utf-8";
                    }

                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        if (requestBody == null) return null;
                        else {
                            try {
                                return requestBody.getBytes("utf-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }
                };
                requestQueue.add(stringRequest);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.DELETE, URL + "/49", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tvResult.setText("Delete successful!!");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvResult.setText("ID not found!!");
                    }
                });
                requestQueue.add(stringRequest);
            }
        });



    }

    private void mappings() {
        btnGet = findViewById(R.id.btn_get);
        btnPost = findViewById(R.id.btn_post);
        btnPut = findViewById(R.id.btn_put);
        btnDelete = findViewById(R.id.btn_delete);
        tvResult = findViewById(R.id.tv_result);
    }
}