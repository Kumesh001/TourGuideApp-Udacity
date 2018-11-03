package com.example.jagat.tourguide.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jagat.tourguide.R;
import com.example.jagat.tourguide.customAdapter.ParkAdapter;
import com.example.jagat.tourguide.customAdapter.RestaurantAdapter;
import com.example.jagat.tourguide.model.Parks;
import com.example.jagat.tourguide.model.Restaurants;

import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLaayoutManager;
    private ArrayList<Restaurants> mRestaurantList;
    private RestaurantAdapter mAdapter;

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
            "Kake Da Hotel",
            "Saravana Bhawan",
            "Bukhara",
            "Indian Accent",
            "Dum Pukht",
            "Dakshin",
            "Karim’s",
            "Moti Mahal"
    };
    private static final int[] rating=new int[]{
            4,3,4,5,5,4,3,4
    };
    private static final String[] address=new String[]{
            "67, Municipal Market, Connaught Circle, Connaught Place, New Delhi",
            "P-13, Connaught Circus, Connaught Place, New Delhi",
            "ITC Maurya, Chanakyapuri, New Delhi",
            "The Lodhi, Lodhi Road, New Delhi",
            " ITC Maurya, Chanakyapuri, New Delhi",
            " Sheraton New Delhi Hotel, District Centre, Saket, New Delhi",
            " 16, Gali Kababian, Jama Masjid, New Delhi",
            " 3703, Netaji Subhash Marg, Daryaganj, New Delhi"

    };
    private static final int[] thumbnails=new int[]{
            R.drawable.kake,
            R.drawable.saravan,
            R.drawable.bukhra,
            R.drawable.indian_accent,
            R.drawable.dum_pukht,
            R.drawable.dakshin,
            R.drawable.karims_at_old_delhi,
            R.drawable.moti_mahal
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
        mRestaurantList=new ArrayList<>();
        mAdapter=new RestaurantAdapter(getApplicationContext(),mRestaurantList);
        mLaayoutManager=new GridLayoutManager(getApplicationContext(),2);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLaayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        prepareData();
    }

    private void prepareData(){
        for(int i=0;i<names.length;i++)
        {
            Restaurants object= new Restaurants(names[i],des[i],address[i],type[i],thumbnails[i],rating[i],days);
            mRestaurantList.add(object);
        }
        mAdapter.notifyDataSetChanged();
    }
}
