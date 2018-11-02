package com.example.jagat.tourguide.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.jagat.tourguide.R;
import com.example.jagat.tourguide.customAdapter.MonumentAdapter;
import com.example.jagat.tourguide.model.Monument;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MonumentActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private Context mContext;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Monument> mMonumentList;
    private String mTitle;
    private int mThumbnail;

    private static final HashMap<String,int[]> days=new HashMap<String, int[]>(){{
        put("Monday",new int[]{9,10});
        put("Tuesday",new int[]{9,10});
        put("Wednesday",new int[]{9,10});
        put("Thursday",new int[]{9,10});
        put("Friday",new int[]{9,10});
        put("Saturday",new int[]{9,10});
        put("Sunday",new int[]{9,10}); }
    };

    private static final String[] names=new String[]{
            "India Gate",
            "Jama Masjit",
            "Jantar Mantar",
            "Lotus Temple",
            "Old Fort",
            "Red Fort",
            "Qutub Minar",
            "Aksardham Temple"
    };
    private static final int[] rating=new int[]{
            2,3,4,5,5,4,5,4
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
      R.drawable.india_gate_1,
      R.drawable.jama_masjit,
      R.drawable.jantar_mantar,
      R.drawable.lotus_temple,
      R.drawable.old_fort,
      R.drawable.red_f,
      R.drawable.qutub_minar_1,
      R.drawable.aksardham_2,
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monument);

        mRecycleView=findViewById(R.id.monument_activity);
        mMonumentList=new ArrayList<>();
        mContext=getApplicationContext();

        mAdapter=new MonumentAdapter(mContext,mMonumentList);
        mLayoutManager=new GridLayoutManager(mContext,2);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
        mRecycleView.setAdapter(mAdapter);

        //mRecycleView.addItemDecoration(new );
        Toast.makeText(mContext,"Wait preparing data",Toast.LENGTH_SHORT).show();
        getIncomingIntent();
        prepareData();

    }

    private void getIncomingIntent(){
        //Intent myIntent=getIntent();
        //if(getIntent())

    }

    private void prepareData(){
        for(int i=0;i<names.length;i++) {
            Monument monumentObject = new Monument(names[i],rating[i],thumbnails[i],days);
            mMonumentList.add(monumentObject);
        }
        mAdapter.notifyDataSetChanged();
    }
}
