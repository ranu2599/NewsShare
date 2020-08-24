package com.example.kanishkaranu.newsshare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Sports extends AppCompatActivity {

    private String TAG = Sports.class.getSimpleName();

    private List<Articles> lstArticles1 = new ArrayList<>();
    private CustomAdapter1 customAdapter1;
    private ProgressDialog pDialog;
    private ListView lv;


    // URL to get contacts JSON
    private static String API_KEY = "apiKey=d0774924d2b54babb4513a379e12a926";
    private static String url = "https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=d0774924d2b54babb4513a379e12a926";
    ArrayList<HashMap<String, String>> ArticlesList;

    public void Articles(String author, String title, String url, String description, String urlToImage, String publishedAt, String content) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sports);

        ArticlesList = new ArrayList<>();


        new GetNews().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetNews extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Sports.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeNewsCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray articles = jsonObj.getJSONArray("articles");
                    Articles articleobj = null;
                    lstArticles1 = new ArrayList<Articles>();
                    // List<Articles> lstArticles=new ArrayList<Articles>();
                    // looping through All Contacts
                    for (int i = 0; i < articles.length(); i++) {

                        JSONObject c = articles.getJSONObject(i);


                        //JSONObject source = c.getJSONObject("source");
                        //  String id = source.getString("id");
                        // String name = source.getString("name");

                        String author = c.getString("author");
                        String title = c.getString("title");
                        String url = c.getString("url");
                        String description = c.getString("description");
                        String urlToImage = c.getString("urlToImage");
                        String publishedAt = c.getString("publishedAt");
                        String content = c.getString("content");
                        articleobj = new Articles(author, title, url, description, urlToImage, publishedAt, content);
                        // Phone node is JSON Object
                        lstArticles1.add(articleobj);

                        // tmp hash map for singl
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            CustomAdapter1 customAdapter1 = new CustomAdapter1(Sports.this, lstArticles1);
            lv = (ListView) findViewById(R.id.list);
            lv.setAdapter(customAdapter1);
        }

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = new Intent(this, ListCategories1.class);
        startActivity(intent);
        finish();
    }

}
