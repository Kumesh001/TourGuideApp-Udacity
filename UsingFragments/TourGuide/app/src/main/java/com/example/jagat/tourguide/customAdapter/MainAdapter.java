package com.example.jagat.tourguide.customAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
    private FragmentManager fm;

    public MainAdapter(Context mContext, List<Category> mCategoryList, FragmentManager mFm){
        this.mContext=mContext;
        this.mCategoryList=mCategoryList;
        this.fm=mFm;

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
                    case "Monuments":FragmentTransaction ft=fm.beginTransaction();
                                     MonumentActivity fragment=new MonumentActivity();
                                     ft.add(R.id.frameContent,fragment);
                                     ft.addToBackStack("Monument Activity Added");
                                     ft.commit();
                                      break;
                    case "Parks": FragmentTransaction park=fm.beginTransaction();
                        ParkActivity parkFragment=new ParkActivity();
                        park.add(R.id.frameContent,parkFragment);
                        park.addToBackStack("Park Activity Added");
                        park.commit();
                        break;
                    case "Restaurants":FragmentTransaction restaurant=fm.beginTransaction();
                        RestaurantActivity resFragment=new RestaurantActivity();
                        restaurant.add(R.id.frameContent,resFragment);
                        restaurant.addToBackStack("Monument Activity Added");
                        restaurant.commit();
                        break;
                    case "Museums":FragmentTransaction museums=fm.beginTransaction();
                        MusuemActivity museumFragment=new MusuemActivity();
                        museums.add(R.id.frameContent,museumFragment);
                        museums.addToBackStack("Monument Activity Added");
                        museums.commit();
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
