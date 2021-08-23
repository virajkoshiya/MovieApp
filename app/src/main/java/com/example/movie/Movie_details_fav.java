package com.example.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class Movie_details_fav extends AppCompatActivity {


    DBmovies dBmovies;

String fsmname,fsmdate,fsposter,fslanguage,fsvote,fsoverview;
    private TextView mname,titel;
    private TextView mlanguage;
    private TextView mpopularity;
    private TextView mreleasedate;
    private TextView mvote;
    private TextView moverview;
    private ImageView poster;
    private RecyclerView recyclerviewfav;
    private AppCompatImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details_fav);



        mname = (TextView) findViewById(R.id.mname);
        mlanguage = (TextView) findViewById(R.id.mlanguage);

        mreleasedate = (TextView) findViewById(R.id.mreleasedate);
        mvote = (TextView) findViewById(R.id.mvote);
        moverview = (TextView) findViewById(R.id.moverview);
        poster=(ImageView) findViewById(R.id.posterimage);
        titel=(TextView) findViewById(R.id.titel);

        back = (AppCompatImageView) findViewById(R.id.back);





        fsmname=getIntent().getStringExtra("fmname");
        fsmdate=getIntent().getStringExtra("fmdate");
        fsposter=getIntent().getStringExtra("fmposter");
        fslanguage=getIntent().getStringExtra("fmlanguage");
        fsvote=getIntent().getStringExtra("fmvote");
        fsoverview=getIntent().getStringExtra("fmoverview");


        dBmovies = new DBmovies(this);

        mname.setText("Movie name : "+ fsmname);
        titel.setText(fsmname);
        mreleasedate.setText("Release Date : "+fsmdate);
        mlanguage.setText("Language : "+fslanguage);
        mvote.setText("Rating : "+fsvote);
        moverview.setText("Overview : "+fsoverview);
        Picasso.get().load("https://image.tmdb.org/t/p/w185/"+fsposter).into(poster);





        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buttonintent=new Intent(Movie_details_fav.this, Recycle_view.class);
                startActivity(buttonintent);
            }
        });



        
    }




   }