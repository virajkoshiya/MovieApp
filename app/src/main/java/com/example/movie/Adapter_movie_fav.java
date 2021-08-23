package com.example.movie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Adapter_movie_fav extends RecyclerView.Adapter<Adapter_movie_fav.viewholder> {

  private Context context;
    private Activity activity;
    private ArrayList mname,date, mposter,language,vote,overview;
    Adapter_movie_fav adapter_movie_fav;


    Adapter_movie_fav (Activity activity, Context context, ArrayList mname, ArrayList date, ArrayList mposter
    ,ArrayList language,ArrayList vote,ArrayList overview){
        this.activity = activity;
        this.context = context;
      //  this.id = id;
        this.mname = mname;
        this.date = date;
        this.mposter = mposter;
        this.language=language;
        this.vote=vote;
        this.overview=overview;
        //this.book_pages = book_pages;

    }

    @NonNull
    @NotNull
    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fav_item_for_rec, parent, false);
        return new viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull final viewholder holder,final int position) {


        holder.mtext.setText(String.valueOf(mname.get(position)));
        holder.mdate.setText(String.valueOf(date.get(position)));

      int p=position;

        String image;

        image=String.valueOf(mposter.get(position));

        Picasso.get().load("https://image.tmdb.org/t/p/w185/"+image).into(holder.imgage);




        holder.delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBmovies DB = new DBmovies(context);
                String nameTXT = holder.mtext.getText().toString();


                Boolean checkudeletedata = DB.deletedata(nameTXT);

                if(checkudeletedata==true)

                {

                    Intent intent = new Intent(v.getContext(),favlist.class);

                    v.getContext().startActivity(intent);

                    Toast.makeText(activity.getApplicationContext(), "Item Deleted", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(activity.getApplicationContext(), "Item Not Deleted", Toast.LENGTH_SHORT).show();

                }

              //  adapter_movie_fav.notifyDataSetChanged();
            }

        });

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),Movie_details_fav.class);

                intent.putExtra("fmname",String.valueOf(mname.get(holder.getAdapterPosition())));
                intent.putExtra("fmdate",String.valueOf(date.get(holder.getAdapterPosition())));
                intent.putExtra("fmposter",String.valueOf(mposter.get(holder.getAdapterPosition())));
                intent.putExtra("fmlanguage",String.valueOf(language.get(holder.getAdapterPosition())));
                intent.putExtra("fmvote",String.valueOf(vote.get(holder.getAdapterPosition())));
                intent.putExtra("fmoverview",String.valueOf(overview.get(holder.getAdapterPosition())));

                v.getContext().startActivity(intent);

            }

        });

    }




    @Override
    public int getItemCount() {
        return mname.size();

    }


    public class viewholder extends RecyclerView.ViewHolder{

        private AppCompatImageView imgage;
        private TextView id,mtext,mdate;
        private LinearLayout linearLayout;
        private AppCompatButton delet;

        public viewholder(@NonNull @NotNull View itemView) {

            super(itemView);

            imgage = (AppCompatImageView) itemView.findViewById(R.id.fimg);
            mtext = (TextView) itemView.findViewById(R.id.fmname);
            //id = (TextView) itemView.findViewById(R.id.id);
            mdate=(TextView) itemView.findViewById(R.id.fdate);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.flayclick);
            delet=(AppCompatButton) itemView.findViewById(R.id.delet);


        }

    }


}