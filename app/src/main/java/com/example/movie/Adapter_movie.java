package com.example.movie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

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

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Movie_details.class);

                intent.putExtra("mname",String.valueOf(movie_constructor.getOriginal_title()));
                intent.putExtra("mdate",String.valueOf(movie_constructor.getRelease_date()));
                intent.putExtra("mposter",String.valueOf(movie_constructor.getPoster_path()));
                intent.putExtra("mlanguage",String.valueOf(movie_constructor.getOriginal_language()));
                intent.putExtra("mvote",String.valueOf(movie_constructor.getVote_average()));
                intent.putExtra("moverview",String.valueOf(movie_constructor.getOverview()));


               // intent.putExtra("image",String.valueOf(image));
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.arrayList.size();
    }

    public void filterlist(ArrayList<movie_constructor> filteredlist)
    {
        arrayList=filteredlist;
        notifyDataSetChanged();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        private AppCompatImageView imgage;
        private TextView text,date;
        private LinearLayout linearLayout;


        public viewholder(@NonNull @NotNull View itemView) {

            super(itemView);

            imgage = (AppCompatImageView) itemView.findViewById(R.id.img);
            text = (TextView) itemView.findViewById(R.id.mname);
            date=(TextView) itemView.findViewById(R.id.date);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.layclick);


        }
    }
}