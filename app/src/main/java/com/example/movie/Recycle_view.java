package com.example.movie;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
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

public class Recycle_view extends AppCompatActivity {

    AppCompatEditText edtsearch;
    private RecyclerView recyclerview;
    private ArrayList<movie_constructor> arrayList = new ArrayList<>();
    Adapter_movie adapter_movie;
   // ArrayList<movie_constructor> filter_list = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        get_movie();

        adapter_movie=new Adapter_movie(arrayList,this);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);

        recyclerview.setLayoutManager(layoutManager);

        edtsearch=findViewById(R.id.edtsearch);

        edtsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());
            }
        });



      //  rec_adapter adapter1 = new rec_adapter(name, imagess);
      //  LinearLayoutManager mlinearLayoutManagerv= new LinearLayoutManager(this);
        // LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
      //  recyclerview.setLayoutManager(mlinearLayoutManagerv);
     //   recyclerview.setAdapter(adapter1);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menuforfavourite,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       menufavorites(item);
        return super.onOptionsItemSelected(item);
    }

    public void menufavorites(MenuItem item) {

        Intent intent =  new Intent(Recycle_view.this,favlist.class);
        startActivity(intent);
        Toast.makeText(this, "FAV CLICKED", Toast.LENGTH_SHORT).show();
    }

    private void filter (String text)
    {
        ArrayList<movie_constructor> filteredlist = new ArrayList<>();
        for (movie_constructor items : arrayList){
            if (items.getOriginal_title().toLowerCase().contains(text.toLowerCase())){
                filteredlist.add(items);
            }

        }

        adapter_movie.filterlist(filteredlist);
    }

    public void get_movie () {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        String url=
                //"https://api.themoviedb.org/3/movie/top_rated?api_key=4ea6c430e33ea35846458e99db882324&https://api.themoviedb.org/3/movie/top_rated?api_key%3D";
                "https://api.themoviedb.org/3/movie/popular?api_key=4ea6c430e33ea35846458e99db882324";
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
                        String mlanguage =movie_jsonobj.getString("original_language");
                        String mvote =movie_jsonobj.getString("vote_average");
                        String overview =movie_jsonobj.getString("overview");

                        movie_constructor movie_constructor = new movie_constructor(moviename,moviedate,poster,mlanguage,mvote
                        ,overview);
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
        });

        requestQueue.add(stringRequest);

    }


}