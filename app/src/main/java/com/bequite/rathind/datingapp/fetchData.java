package com.bequite.rathind.datingapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class fetchData extends AsyncTask<Void, Void, Void> {


    @Override
    protected Void doInBackground(Void... params) {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        // Will contain the raw JSON response as a string.
        String forecastJsonStr = null;

        try {

            URL url = new URL("http://dodsoneng.com/matchSample.json");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int lengthOfFile = urlConnection.getContentLength();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                return null;
            }
        }catch (Exception e ){
            Log.e("PlaceholderFragment", "Error ", e);
        }


        return null;
    }
}
