package com.example.jagat.tourguide.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jagat.tourguide.R;
import com.example.jagat.tourguide.customAdapter.MuseumAdapter;
import com.example.jagat.tourguide.model.Museums;

import java.util.ArrayList;
import java.util.HashMap;

public class MusuemActivity extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Museums> mMuseumList;
    private MuseumAdapter mAdapter;

    private View mView;
    private static final String CLASS_NAME="Museums";

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity())
                .setActionBarTitle(CLASS_NAME);

        mView=inflater.inflate(R.layout.common_fragment_layout,container,false);
        mRecyclerView=mView.findViewById(R.id.recycler_view);
        mMuseumList=new ArrayList<Museums>();
        mAdapter=new MuseumAdapter(getContext(),mMuseumList);
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
            Museums object= new Museums(names[i],des[i],address[i],thumbnails[i],rating[i],type[i],days);
            mMuseumList.add(object);
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
            mListener = (MusuemActivity.OnFragmentInteractionListener) context;
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
