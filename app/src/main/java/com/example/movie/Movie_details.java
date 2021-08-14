package com.example.movie;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Movie_details extends AppCompatActivity {


    private static final String MOVIE_BUNDLE_KEY = "movie";
    private static final String MOVIE_STATE_KEY = "key";
    DBmovies dBmovies;
    String smname,smdate,sposter,slanguage,svote,soverview;
String fsmname,fsmdate;
    private TextView mname,titel;
    private TextView mlanguage;
    private TextView mpopularity;
    private TextView mreleasedate;
    private TextView mvote;
    private TextView moverview;
    private ImageView poster;
    private RecyclerView recyclerviewfav;
    private AppCompatImageView back;
    Adapter_movie_fav adapter_movie_fav;

     FloatingActionButton fabFavorites;
    private Boolean mIsFavorite;
Context context;

    ImageView empty_imageview;
    TextView no_data;
    ArrayList<String> id,name, date, pposter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);



        mname = (TextView) findViewById(R.id.mname);
        mlanguage = (TextView) findViewById(R.id.mlanguage);
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


        fsmname=getIntent().getStringExtra("fmname");
        fsmdate=getIntent().getStringExtra("fmdate");
       // fsposter=getIntent().getStringExtra("mposter");

        dBmovies = new DBmovies(this);

        mname.setText("Movie name : "+ smname);
        titel.setText(smname);
        mreleasedate.setText("Release Date : "+smdate);
        mlanguage.setText("Language : "+slanguage);
        mvote.setText("Rating : "+svote);
        moverview.setText("Overview : "+soverview);
        Picasso.get().load("https://image.tmdb.org/t/p/w185/"+sposter).into(poster);

//made by me

        fabFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dsname=smname;
                String dmdate=smdate;
                String dsposter=sposter;
                String dslanguage=slanguage;
                String dsvote=svote;
                String dsoverview=soverview;

               Boolean result = dBmovies.insert_data(smname,smdate,sposter,slanguage,svote,soverview);

        if (result==true){
            Toast.makeText(Movie_details.this, "Add to favouritelist", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(Movie_details.this, "Not added ", Toast.LENGTH_SHORT).show();
        }

            }
        });


//        if(savedInstanceState != null) {
//            // Get movie from previous state
//          //  mMovie = savedInstanceState.getParcelable(MOVIE_BUNDLE_KEY);
//            mIsFavorite = savedInstanceState.getBoolean(MOVIE_STATE_KEY);
//        }
//        else {
//            // Get movie from intent
//           // mMovie = getIntent().getParcelableExtra(MOVIE_BUNDLE_KEY);
//            mIsFavorite = false;
//        }


      //  initViewModel();



       // populateMovieUI();
     //   setColorFavoriteButton();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buttonintent=new Intent(Movie_details.this, Recycle_view.class);
                startActivity(buttonintent);
            }
        });

//        if(savedInstanceState != null) {
//            // Get movie from previous state
//            mMovie = savedInstanceState.getParcelable(MOVIE_BUNDLE_KEY);
//            mIsFavorite = savedInstanceState.getBoolean(MOVIE_STATE_KEY);
//        }
//        else {
//            // Get movie from intent
//            mMovie = getIntent().getParcelableExtra(MOVIE_BUNDLE_KEY);
//            mIsFavorite = false;
//        }

        //gith method

//        fabFavorites.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String dsname=smname;
//                String dmdate=smdate;
//                String dsposter=sposter;
//                String dslanguage=slanguage;
//                String dsvote=svote;
//                String dsoverview=soverview;
//
//              //  Boolean result = dBmovies.insert_data(smname,smdate,sposter,slanguage,svote,soverview);
//
//
//            {
//
//                //    AppExecutors task = AppExecutors.getInstance();
//
//                    if (mIsFavorite) {
//                        mIsFavorite = false;
//                        setColorFavoriteButton();
////remove from database
//                        DBmovies DB = new DBmovies(context);
//                        String nameTXT = smname;
//                         DB.deletedata(nameTXT);
//
//
//                        Toast.makeText(Movie_details.this,
//                                "Successfully removed from favorites", Toast.LENGTH_SHORT).show();
//                    }
//                    else {
//                        mIsFavorite = true;
//                        setColorFavoriteButton();
//                        Boolean result = dBmovies.insert_data(smname,smdate,sposter,slanguage,svote,soverview);
//
//                        Toast.makeText(Movie_details.this,
//                                "Successfully added to favorites", Toast.LENGTH_SHORT).show();
//
//                    }
//
//                }
//
//            }
//        });
//
//
//
    }




//    private void initViewModel() {
//
//        if (mMovie == null) return;
//
//        MovieDetailViewModelFactory factory =
//                new MovieDetailViewModelFactory(MovieDatabase.getInstance(Movie_details.this), mMovie.getMovieId());
//      //  mViewModel = ViewModelProvider.of(this, factory).get(MovieDetailViewModel.class);
//        mViewModel.getMovie().observe(this, new Observer<Movie>() {
//            @Override
//            public void onChanged(@Nullable Movie movie) {
//                if(movie != null) {
//                    mIsFavorite = true;
//                    setColorFavoriteButton();
//                }
//            }
//        });
//    }
//
//
//    public void addOrRemoveFavorites() {
//
//        AppExecutors task = AppExecutors.getInstance();
//
//        if (mIsFavorite) {
//            mIsFavorite = false;
//            setColorFavoriteButton();
//
//            task.diskIO().execute(new Runnable() {
//                @Override
//                public void run() {
//                    mDb.movieDao().delete(mMovie);
//                }
//            });
//            Toast.makeText(Movie_details.this,
//                    "Successfully removed from favorites", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            mIsFavorite = true;
//            setColorFavoriteButton();
//
//            task.diskIO().execute(new Runnable() {
//                @Override
//                public void run() {
//                    mDb.movieDao().insert(mMovie);
//                }
//            });
//            Toast.makeText(Movie_details.this,
//                    "Successfully added to favorites", Toast.LENGTH_SHORT).show();
//
//        }
//
//    }
//
//    public void addOrRemoveFavorites(View view) {
//
//        AppExecutors task = AppExecutors.getInstance();
//
//        if (mIsFavorite) {
//            mIsFavorite = false;
//            setColorFavoriteButton();
//
//            task.diskIO().execute(new Runnable() {
//                @Override
//                public void run() {
//                    mDb.movieDao().delete(mMovie);
//                }
//            });
//            Toast.makeText(Movie_details.this,
//                    "Successfully removed from favorites", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            mIsFavorite = true;
//            setColorFavoriteButton();
//
//
//
//            smname=getIntent().getStringExtra("dmname");
//            smdate=getIntent().getStringExtra("dmdate");
//            sposter=getIntent().getStringExtra("dmposter");
//
//            dBmovies.insert_data(smname,smdate,sposter);
//
//            task.diskIO().execute(new Runnable() {
//                @Override
//                public void run() {
//                    mDb.movieDao().insert(mMovie);
//                }
//            });
//            Toast.makeText(Movie_details.this,
//                    "Successfully added to favorites", Toast.LENGTH_SHORT).show();
//
//        }
//
//    }
//
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