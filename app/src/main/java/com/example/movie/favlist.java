package com.example.movie;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class favlist extends AppCompatActivity {
    private RecyclerView recyclerviewfav;
    Adapter_movie_fav adapter_movie_fav;
    DBmovies dBmovies;
    ImageView empty_imageview;
    TextView no_data;
    AppCompatButton delet;
    ArrayList<String> id,name, date, poster,language,vote,overview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favlist);

        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);
        recyclerviewfav = (RecyclerView) findViewById(R.id.favrecyclerview);
        delet=(AppCompatButton)findViewById(R.id.delet);

        dBmovies = new DBmovies(favlist.this);
        id=new ArrayList<>();
        name=new ArrayList<>();
        date=new ArrayList<>();
        poster=new ArrayList<>();
        language=new ArrayList<>();
        vote=new ArrayList<>();
        overview=new ArrayList<>();



        storeDataInArrays();

        adapter_movie_fav = new Adapter_movie_fav(favlist.this,this, name, date, poster,language
        ,vote,overview);

      // adapter_movie_fav.notifyDataSetChanged();

        recyclerviewfav.setAdapter(adapter_movie_fav);
        recyclerviewfav.setLayoutManager(new LinearLayoutManager(favlist.this));



    }




    void storeDataInArrays(){
        Cursor cursor = dBmovies.readAllData();
        if(cursor.getCount() == 0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                //id.add(cursor.getString(0));
                name.add(cursor.getString(0));
                date.add(cursor.getString(1));
                poster.add(cursor.getString(2));
                language.add(cursor.getString(3));
                vote.add(cursor.getString(4));
                overview.add(cursor.getString(5));
                //book_pages.add(cursor.getString(3));
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }


}