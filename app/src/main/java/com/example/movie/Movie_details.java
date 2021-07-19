package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class Movie_details extends AppCompatActivity {

    DBmovies dBmovies;
    String smname,smdate,sposter,slanguage,svote,soverview;

    private TextView mname,titel;
    private TextView mlanguage;
    private TextView mpopularity;
    private TextView mreleasedate;
    private TextView mvote;
    private TextView moverview;
    private ImageView poster;

    private AppCompatImageView back;

    private FloatingActionButton fabFavorites;
    private Boolean mIsFavorite;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        mname = (TextView) findViewById(R.id.mname);
        mlanguage = (TextView) findViewById(R.id.mlanguage);
       // mpopularity = (TextView) findViewById(R.id.mpopularity);
        mreleasedate = (TextView) findViewById(R.id.mreleasedate);
        mvote = (TextView) findViewById(R.id.mvote);
        moverview = (TextView) findViewById(R.id.moverview);
        poster=(ImageView) findViewById(R.id.posterimage);
        titel=(TextView) findViewById(R.id.titel);

        back = (AppCompatImageView) findViewById(R.id.back);

        fabFavorites = (FloatingActionButton) findViewById(R.id.fab_favorites);

        smname=getIntent().getStringExtra("mname");
        smdate=getIntent().getStringExtra("mdate");
        sposter=getIntent().getStringExtra("mposter");
        slanguage=getIntent().getStringExtra("mlanguage");
        svote=getIntent().getStringExtra("mvote");
        soverview=getIntent().getStringExtra("moverview");

        dBmovies = new DBmovies(this);

        mname.setText("Movie name : "+ smname);
        titel.setText(smname);
        mreleasedate.setText("Release Date : "+smdate);
        mlanguage.setText("Language : "+slanguage);
        mvote.setText("Rating : "+svote);
        moverview.setText("Overview : "+soverview);
        Picasso.get().load("https://image.tmdb.org/t/p/w185/"+sposter).into(poster);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buttonintent=new Intent(Movie_details.this, Recycle_view.class);
                startActivity(buttonintent);
            }
        });

        if(savedInstanceState != null) {
            // Get movie from previous state
           // mMovie = savedInstanceState.getParcelable(MOVIE_BUNDLE_KEY);
           // mIsFavorite = savedInstanceState.getBoolean(MOVIE_STATE_KEY);
        }
        else {
            // Get movie from intent
          //  mMovie = getIntent().getParcelableExtra(MOVIE_BUNDLE_KEY);
            mIsFavorite = false;
        }

        setColorFavoriteButton();

    }



    public void addOrRemoveFavorites(View view) {

  //      AppExecutors task = AppExecutors.getInstance();

        if (mIsFavorite) {
            mIsFavorite = false;
            setColorFavoriteButton();

//            task.diskIO().execute(new Runnable() {
//                @Override
//                public void run() {
//                    mDb.movieDao().delete(mMovie);
//                }
//            });
            Toast.makeText(Movie_details.this,
                    "Successfully removed from favorites", Toast.LENGTH_SHORT).show();
        }
        else {
            mIsFavorite = true;
            setColorFavoriteButton();



            smname=getIntent().getStringExtra("dmname");
            smdate=getIntent().getStringExtra("dmdate");
            sposter=getIntent().getStringExtra("dmposter");

            dBmovies.insert_data(smname,smdate,sposter);

//            task.diskIO().execute(new Runnable() {
//                @Override
//                public void run() {
//                    mDb.movieDao().insert(mMovie);
//                }
//            });
            Toast.makeText(Movie_details.this,
                    "Successfully added to favorites", Toast.LENGTH_SHORT).show();

        }

    }

    private void setColorFavoriteButton() {
        if (mIsFavorite) {
            fabFavorites.setColorFilter(ResourcesCompat.getColor(getResources(), R.color.red_light, null));
        }
        else {
            fabFavorites.setColorFilter(Color.WHITE);
            fabFavorites.setImageResource(R.drawable.ic_baseline_favorite_24);

        }
    }
}