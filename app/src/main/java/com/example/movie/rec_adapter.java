//package com.example.movie;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//
//import org.jetbrains.annotations.NotNull;
//
//public class rec_adapter  extends RecyclerView.Adapter<rec_adapter.viewholder> {
//
//    String[] data;
//    int[] images;
//
////    public Rec_adapter(String[] data) {
////        this.data = data;
////    }
//
//
//    public rec_adapter(String[] data, int[] images) {
//        this.data = data;
//        this.images = images;
//    }
//
//    @NonNull
//    @NotNull
//    @Override
//    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
//
//        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
//        View view= inflater.inflate(R.layout.item_for_recycleview,parent,false);
//        return new viewholder(view) ;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull @NotNull viewholder holder, int position) {
//        String user_name=data[position];
//        int img=images[position];
//        holder.text.setText(user_name);
//
//
//        Glide.with(holder.img.getContext()).load(img).into(holder.img);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.length;
//    }
//
//    public class viewholder extends RecyclerView.ViewHolder{
//
//        private ImageView img;
//        private TextView text;
//
//
//        public viewholder(@NonNull @NotNull View itemView) {
//
//            super(itemView);
//
//            img = (ImageView) itemView.findViewById(R.id.img);
//            text = (TextView) itemView.findViewById(R.id.mname);
//
//
//        }
//    }
//}