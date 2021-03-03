package com.example.day06ver01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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
    String json = "{\n" +
            "\"id\": 4,\n" +
            "\"username\": \"abc4\",\n" +
            "\"password\": \"xyz\"\n" +
            "}";
    String array = "[\n" +
            "{\n" +
            "\"id\": 4,\n" +
            "\"username\": \"abc4\",\n" +
            "\"password\": \"xyz\"\n" +
            "},\n" +
            "{\n" +
            "\"id\": 5,\n" +
            "\"username\": \"abc5\",\n" +
            "\"password\": \"xyz\"\n" +
            "},\n" +
            "{\n" +
            "\"id\": 2,\n" +
            "\"username\": \"abc2\",\n" +
            "\"password\": \"xyz1\"\n" +
            "},\n" +
            "{\n" +
            "\"id\": 7,\n" +
            "\"username\": \"aaaaaaaaa\",\n" +
            "\"password\": \"hihi\"\n" +
            "},\n" +
            "{\n" +
            "\"id\": 8,\n" +
            "\"username\": \"1\",\n" +
            "\"password\": \"123\"\n" +
            "}\n" +
            "]";
    String weather = "{\n" +
            "  \"coord\": {\n" +
            "    \"lon\": -0.13,\n" +
            "    \"lat\": 51.51\n" +
            "  },\n" +
            "  \"weather\": [\n" +
            "    {\n" +
            "      \"id\": 300,\n" +
            "      \"main\": \"Drizzle\",\n" +
            "      \"description\": \"light intensity drizzle\",\n" +
            "      \"icon\": \"09d\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"base\": \"stations\",\n" +
            "  \"main\": {\n" +
            "    \"temp\": 280.32,\n" +
            "    \"pressure\": 1012,\n" +
            "    \"humidity\": 81,\n" +
            "    \"temp_min\": 279.15,\n" +
            "    \"temp_max\": 281.15\n" +
            "  }\n" +
            "}";

    String url = "https://demo-b5.herokuapp.com/api/accounts";
    Button btnGet, btnPost, btnPut, btnDelete;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            int id = jsonObject.getInt("id");
//            String username = jsonObject.getString("username");
//            String password = jsonObject.getString("password");
//            Account account = new Account(id, username, password);
////            Log.d("TAG", String.valueOf(id) + " " + username + " " + password);
//            Log.d("TAG", account.toString());
//
//            JSONArray jsonArray = new JSONArray(array);
//            List<Account> accounts = new ArrayList<>();
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//                int id1 = jsonObject1.getInt("id");
//                String username1 = jsonObject1.getString("username");
//                String password1 = jsonObject1.getString("password");
//                accounts.add(new Account(id1, username1, password1));
////                Log.d("TAG", String.valueOf(id1) + " " + username1 + " " + password1);
//                Log.d("TAG", accounts.toString());
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

//        try {
//            JSONObject jsonObject = new JSONObject(weather);
//            JSONObject object = jsonObject.getJSONObject("coord");
//            Log.d("Tag", object.getString("lon") + ", " + object.getString("lat"));
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        Mappings();
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Error 404 Not Found");
                    }
                });
                requestQueue.add(stringRequest);
            }
        });

        //***********************************************/

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("username", "TinhMercedes02");
//                    jsonObject.put("password", "E để con pet ở đây hóng chuyện");
                    jsonObject.put("password", "Xong việc lát e qua đón, mọi người đừng đuổi nó đi nhé!!");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String requestBody = jsonObject.toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Error 404 Not Found (Push)");
                    }
                }) {
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

        //*************************************************/

        btnPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonObject = new JSONObject();
                try {
//                    jsonObject.put("password", "E để con pet ở đây hóng chuyện");
                    jsonObject.put("password", "E đón nó về rồi!");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String requestBody = jsonObject.toString();
                StringRequest stringRequest = new StringRequest(Request.Method.PATCH, url + "/8", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Error 404 Not Found (Push)");
                    }
                }) {
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

        //*************************************************/

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url + "/27", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText("Delete successful!");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Error 404 Not Found ID (Delete)");
                    }
                });
                requestQueue.add(stringRequest);
            }
        });

    }

    private void Mappings() {
        btnGet = findViewById(R.id.btn_get);
        btnPost = findViewById(R.id.btn_post);
        btnPut = findViewById(R.id.btn_put);
        btnDelete = findViewById(R.id.btn_delete);
        textView = findViewById(R.id.text_view);
    }
}