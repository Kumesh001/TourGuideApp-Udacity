package com.example.jagat.tourguide.customAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.jagat.tourguide.R;
import com.example.jagat.tourguide.app.MonumentActivity;
import com.example.jagat.tourguide.app.MusuemActivity;
import com.example.jagat.tourguide.app.ParkActivity;
import com.example.jagat.tourguide.app.RestaurantActivity;
import com.example.jagat.tourguide.model.Category;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private Context mContext;
    private List<Category> mCategoryList;

    public MainAdapter(Context mContext,List<Category> mCategoryList){
        this.mContext=mContext;
        this.mCategoryList=mCategoryList;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        public TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail=itemView.findViewById(R.id.thumbnail);
            title=itemView.findViewById(R.id.title);
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=LayoutInflater.from(mContext).inflate(R.layout.cards_layout,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        final Category item=mCategoryList.get(i);
        myViewHolder.title.setText(item.getTitle());
        myViewHolder.title.setShadowLayer(50,0,0,Color.WHITE);

        Glide.with(mContext).load(item.getThumbnail()).into(myViewHolder.thumbnail);

        myViewHolder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext,item.getTitle().toString(),Toast.LENGTH_SHORT).show();

                switch (item.getTitle())
                {
                    case "Monuments":Intent temp=new Intent(mContext,MonumentActivity.class);
                        temp.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        temp.putExtra("Title",item.getTitle());
                        temp.putExtra("Thumbnail",item.getThumbnail());
                        mContext.startActivity(temp);
                        break;
                    case "Parks":Intent park=new Intent(mContext,ParkActivity.class);
                        park.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        park.putExtra("Title",item.getTitle());
                        park.putExtra("Thumbnail",item.getThumbnail());
                        mContext.startActivity(park);
                        break;
                    case "Restaurants":Intent restaurant=new Intent(mContext,RestaurantActivity.class);
                        restaurant.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        restaurant.putExtra("Title",item.getTitle());
                        restaurant.putExtra("Thumbnail",item.getThumbnail());
                        mContext.startActivity(restaurant);
                        break;
                    case "Museums":Intent museums=new Intent(mContext,MusuemActivity.class);
                        museums.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        museums.putExtra("Title",item.getTitle());
                        museums.putExtra("Thumbnail",item.getThumbnail());
                        mContext.startActivity(museums);
                        break;
                    default:
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private OnItemClickListener mListener;

        public interface OnItemClickListener {
            void onItemClick(View view, int position);
        }

        GestureDetector mGestureDetector;

        public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
            mListener = listener;
            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
