package com.example.jagat.tourguide.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jagat.tourguide.R;
import com.example.jagat.tourguide.customAdapter.MuseumAdapter;
import com.example.jagat.tourguide.customAdapter.RestaurantAdapter;
import com.example.jagat.tourguide.model.Museums;
import com.example.jagat.tourguide.model.Restaurants;

import java.util.ArrayList;
import java.util.HashMap;

public class MusuemActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLaayoutManager;
    private ArrayList<Museums> mMuseumList;
    private MuseumAdapter mAdapter;

    private static final HashMap<Integer,int[]> days=new HashMap<Integer, int[]>(){{
        put(0,new int[]{9,10});
        put(1,new int[]{9,10});
        put(2,new int[]{9,10});
        put(3,new int[]{9,10});
        put(4,new int[]{9,10});
        put(5,new int[]{9,10});
        put(6,new int[]{9,10}); }
    };

    private static final String[] names=new String[]{
            "Art Museum",
            "Art Museum",
            "Design Museum",
            "Science Museum",
            "National Science Centre",
            "Wax Museum",
            "Doll Museum",
            "Shankar's International Dolls Museum"
    };
    private static final int[] rating=new int[]{
            4,3,4,5,5,4,3,4
    };
    private static final String[] address=new String[]{
           "New Delhi",
           "New Delhi",
           "New Delhi",
           "New Delhi",
           "New Delhi",
           "New Delhi",
           "New Delhi",
           "New Delhi"

    };
    private static final int[] thumbnails=new int[]{
            R.drawable.art_museum,
            R.drawable.art_museum_1,
            R.drawable.design_museum,
            R.drawable.science_museum,
            R.drawable.national_science_museum,
            R.drawable.wax_museum,
            R.drawable.doll_museum,
            R.drawable.doll_museum_1
    };
    private static final int[] type=new int[]{
            1,1,1,1,1,1,1,1
    };
    private static final String[] des=new String[]{
            "Description",
            "Description",
            "Description",
            "Description",
            "Description",
            "Description",
            "Description",
            "Description"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        mRecyclerView=findViewById(R.id.recycler_view);
        mMuseumList=new ArrayList<>();
        mAdapter=new MuseumAdapter(getApplicationContext(),mMuseumList);
        mLaayoutManager=new GridLayoutManager(getApplicationContext(),2);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLaayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        prepareData();
    }

    private void prepareData(){
        for(int i=0;i<names.length;i++)
        {
            Museums object= new Museums(names[i],des[i],address[i],thumbnails[i],rating[i],type[i],days);
            mMuseumList.add(object);
        }
        mAdapter.notifyDataSetChanged();
    }
}
