package com.example.jagat.tourguide.customAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jagat.tourguide.R;
import com.example.jagat.tourguide.model.Museums;
import com.example.jagat.tourguide.model.Restaurants;

import java.util.ArrayList;

public class MuseumAdapter extends RecyclerView.Adapter<MuseumAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Museums> mMuseumList;

    public MuseumAdapter(Context applicationContext, ArrayList<Museums> mMuseumList) {
        this.mContext=applicationContext;
        this.mMuseumList=mMuseumList;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView thumbnail,direction;
        TextView title,status;
        RatingBar rating;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            thumbnail=itemView.findViewById(R.id.thumbnail);
            direction=itemView.findViewById(R.id.direction);
            title=itemView.findViewById(R.id.title);
            status=itemView.findViewById(R.id.status);
            rating=itemView.findViewById(R.id.ratingBar2);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item=LayoutInflater.from(mContext).inflate(R.layout.item_layout,viewGroup,false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Museums item=mMuseumList.get(i);
        myViewHolder.title.setText(item.getName());
        myViewHolder.status.setText("Open");

        Glide.with(mContext).load(item.getThumbnail()).into(myViewHolder.thumbnail);
        myViewHolder.direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(mContext,item.getName().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMuseumList.size();
    }
}
