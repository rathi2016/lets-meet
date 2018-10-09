package com.bequite.rathind.datingapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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

    private static final String URL_DATA= "http://dodsoneng.com/matchSample.json";
    private RecyclerView mrecyclerView;
    private CardViewAdapter madapter;

    private List<UserDetails> muserDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mrecyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        mrecyclerView.setLayoutManager(manager);

        muserDetails= new ArrayList<>();
        loadUrlData();

    }

    private void loadUrlData() {
       final ProgressDialog progressDialog =  new ProgressDialog(this);
       progressDialog.setMessage("Loading data......");
       progressDialog.show();


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray array = jsonObject.getJSONArray("data");
                            for(int i =0; i < array.length();i++){
                                JSONObject jo = array.getJSONObject(i);

                                JSONObject arPhoto = jo.getJSONObject("photo");
                                JSONObject joph = arPhoto.getJSONObject("full_paths");
//                               JSONObject photo = joph.getJSONObject("medium");
//
                                UserDetails user = new UserDetails(jo.getString("username"),jo.getString("city_name"),joph.getString("large"));
                                muserDetails.add(user);
                            }

                            madapter = new CardViewAdapter(muserDetails, getApplicationContext());

                            mrecyclerView.setAdapter(madapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Error" +error.toString(), Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);


    }
}
