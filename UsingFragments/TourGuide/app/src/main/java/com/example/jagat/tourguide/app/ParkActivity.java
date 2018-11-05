package com.example.jagat.tourguide.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jagat.tourguide.R;
import com.example.jagat.tourguide.customAdapter.MonumentAdapter;
import com.example.jagat.tourguide.customAdapter.ParkAdapter;
import com.example.jagat.tourguide.model.Monument;
import com.example.jagat.tourguide.model.Parks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkActivity extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Parks> mParkList;
    private ParkAdapter mAdapter;

    private View mView;

    private static final String CLASS_NAME="Parks";

    private OnFragmentInteractionListener mListener;

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
            "Children's Park",
            "National Zoological Park",
            "Water Parks",
            "Amusement Park"
    };
    private static final int[] rating=new int[]{
            2,3,4,5
    };
    private static final String[] address=new String[]{
            "New Delhi",
            "New Delhi",
            "New Delhi",
            "New Delhi"
    };
    private static final int[] thumbnails=new int[]{
            R.drawable.childern_park,
            R.drawable.national_zoological_park,
            R.drawable.water_park,
            R.drawable.amusement_park
    };
    private static final int[] type=new int[]{
            1,1,1,1
    };
    private static final String[] des=new String[]{
            "Description",
            "Description",
            "Description",
            "Description"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity())
                .setActionBarTitle(CLASS_NAME);

        mView=inflater.inflate(R.layout.common_fragment_layout,container,false);
        mRecyclerView=mView.findViewById(R.id.recycler_view);
        mParkList=new ArrayList<Parks>();
        mAdapter=new ParkAdapter(getContext(),mParkList);
        mLayoutManager=new GridLayoutManager(getContext(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        prepareData();
        return mView;
    }

    private void prepareData(){
        for(int i=0;i<names.length;i++)
        {
            Parks object= new Parks(names[i],des[i],address[i],type[i],thumbnails[i],rating[i],days);
            mParkList.add(object);
        }
        mAdapter.notifyDataSetChanged();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MonumentActivity.OnFragmentInteractionListener) {
            mListener = (ParkActivity.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
