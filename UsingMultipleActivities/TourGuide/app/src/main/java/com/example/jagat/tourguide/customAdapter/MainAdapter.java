package com.example.jagat.tourguide.customAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.jagat.tourguide.R;
import com.example.jagat.tourguide.app.MonumentAcivity;
import com.example.jagat.tourguide.model.Category;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private Context mContext;
    private List<Category> mCategoryList;
    //private OnItemClickListener mOnItemClickListener;

    public MainAdapter(Context mContext,List<Category> mCategoryList){
        this.mContext=mContext;
        this.mCategoryList=mCategoryList;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements RecyclerView.OnItemTouchListener {
        public ImageView thumbnail;
        public TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail=itemView.findViewById(R.id.thumbnail);
            title=itemView.findViewById(R.id.title);
        }


        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return false;
        }

        @Override
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean b) {

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=LayoutInflater.from(mContext).inflate(R.layout.cards_layout,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        final Category item=mCategoryList.get(i);
        myViewHolder.title.setText(item.getTitle());
        myViewHolder.title.setShadowLayer(50,0,0,Color.WHITE);

        Glide.with(mContext).load(item.getThumbnail()).into(myViewHolder.thumbnail);

        myViewHolder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                Intent i=new Intent(mContext,MonumentAcivity.class);


            }
        });

    }


    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

}
