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
import com.example.jagat.tourguide.model.Monument;

import java.util.ArrayList;
import java.util.List;

public class MonumentAdapter extends RecyclerView.Adapter<MonumentAdapter.MyViewHolder> {

    private Context mContext;
    private List<Monument> mMonumentList;

    public MonumentAdapter(Context mContext, ArrayList<Monument> monumentList)
    {
        this.mContext=mContext;
        this.mMonumentList=monumentList;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView thumbnail,direction;
        public TextView mTitle,mStatus;
        public RatingBar mRatingValue;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail=itemView.findViewById(R.id.thumbnail);
            direction=itemView.findViewById(R.id.direction);
            mTitle=itemView.findViewById(R.id.title);
            mStatus=itemView.findViewById(R.id.status);
            mRatingValue=itemView.findViewById(R.id.ratingBar2);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=LayoutInflater.from(mContext).inflate(R.layout.item_layout,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Monument monumentObject=mMonumentList.get(i);
        myViewHolder.mTitle.setText(monumentObject.getName());
        myViewHolder.mStatus.setText("Open");   // For tht time being  let it be Open
        myViewHolder.mRatingValue.setRating(monumentObject.getRating());

        Glide.with(mContext).load(monumentObject.getThumbnail()).into(myViewHolder.thumbnail);

        myViewHolder.direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,monumentObject.getName().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMonumentList.size();
    }
}
