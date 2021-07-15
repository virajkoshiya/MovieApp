package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recycle_view extends AppCompatActivity {

    private RecyclerView recyclerview;
    private ArrayList<movie_constructor> arrayList = new ArrayList<>();
    Adapter_movie adapter_movie;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        get_movie();

        adapter_movie=new Adapter_movie(arrayList,this);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutManager);

      //  rec_adapter adapter1 = new rec_adapter(name, imagess);
      //  LinearLayoutManager mlinearLayoutManagerv= new LinearLayoutManager(this);
        // LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
      //  recyclerview.setLayoutManager(mlinearLayoutManagerv);
     //   recyclerview.setAdapter(adapter1);


    }

    public void get_movie () {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        String url="https://api.themoviedb.org/3/movie/popular?api_key=4ea6c430e33ea35846458e99db882324";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String page = jsonObject.getString("page");
                    if (page.equals("1"))
                    {
                    String results = jsonObject.getString("results");
                    JSONArray jsonArray=new JSONArray(results);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject movie_jsonobj= jsonArray.getJSONObject(i);
                        String moviename = movie_jsonobj.getString("original_title");
                        String moviedate=movie_jsonobj.getString("release_date");
                        String poster =movie_jsonobj.getString("poster_path");

                        movie_constructor movie_constructor = new movie_constructor(moviename,moviedate,poster);
                        arrayList.add(movie_constructor);

                        recyclerview.setAdapter(adapter_movie);

                    }
                        adapter_movie.notifyDataSetChanged();
                    }
                    else {
                        Toast.makeText(Recycle_view.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{

                HashMap<String,String> hashMap=new HashMap<>();
               // hashMap.put("api_key","4ea6c430e33ea35846458e99db882324");

                return hashMap;
            }
        };
        requestQueue.add(stringRequest);

    }
}