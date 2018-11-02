package com.example.jagat.tourguide.app;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jagat.tourguide.R;
import com.example.jagat.tourguide.customAdapter.MainAdapter;
import com.example.jagat.tourguide.customAdapter.MonumentAdapter;
import com.example.jagat.tourguide.model.Category;
import com.example.jagat.tourguide.model.Category;
import com.example.jagat.tourguide.model.Monument;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private RecyclerView mRecycleview;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutmanager;
    private MainAdapter mMainAdapter;
    private List<Category> mListCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleview=findViewById(R.id.recycler_view);
        mListCategory=new ArrayList<>();
        mMainAdapter=new MainAdapter(getApplicationContext(),mListCategory);

        // we have used the GridLayout here
        mLayoutmanager=new LinearLayoutManager(getApplicationContext());
        mRecycleview.setLayoutManager(mLayoutmanager);
        // This line is changed
        //mRecycleview.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        mRecycleview.setItemAnimator(new DefaultItemAnimator());
        mRecycleview.setAdapter(mMainAdapter);

        prepareMainScreen();
        /*try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public void prepareMainScreen(){
        int[] covers = new int[]{
                R.drawable.monument,
                R.drawable.parks,
                R.drawable.art_museum,
                R.drawable.restaurant,
                R.drawable.design_museum,
                R.drawable.science_museum
        };
        Category a = new Category("Monuments",covers[0]);
        mListCategory.add(a);

        a = new Category("Parks",covers[1]);
        mListCategory.add(a);

        a = new Category("Restaurants",covers[2]);
        mListCategory.add(a);

        a = new Category("Art Museums", covers[3]);
        mListCategory.add(a);

        a = new Category("Design Museums",  covers[4]);
        mListCategory.add(a);

        a = new Category("Science Museums",covers[5]);
        mListCategory.add(a);
        mMainAdapter.notifyDataSetChanged();
    }

}
