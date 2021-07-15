package com.example.movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class Adapter_movie extends RecyclerView.Adapter<Adapter_movie.viewholder> {

   private ArrayList<movie_constructor> arrayList;
   Context context;

    public Adapter_movie(ArrayList<movie_constructor> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.item_for_recycleview,parent,false);
        return new viewholder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull viewholder holder, int position) {

        movie_constructor movie_constructor=arrayList.get(position);
        holder.text.setText(movie_constructor.getOriginal_title());
        holder.date.setText(movie_constructor.getRelease_date());

       String image;

        image=movie_constructor.getPoster_path();

//
//        username.setText(login);
        Picasso.get().load("https://image.tmdb.org/t/p/w185/"+image).into(holder.imgage);
      // Picasso.get().load(movie_constructor.getPoster_path()).into(holder.imgage);



    }

    @Override
    public int getItemCount() {
        return this.arrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        private AppCompatImageView imgage;
        private TextView text,date;


        public viewholder(@NonNull @NotNull View itemView) {

            super(itemView);

            imgage = (AppCompatImageView) itemView.findViewById(R.id.img);
            text = (TextView) itemView.findViewById(R.id.mname);
            date=(TextView) itemView.findViewById(R.id.date);


        }
    }
}