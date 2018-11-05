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
import com.example.jagat.tourguide.customAdapter.MuseumAdapter;
import com.example.jagat.tourguide.customAdapter.ParkAdapter;
import com.example.jagat.tourguide.customAdapter.RestaurantAdapter;
import com.example.jagat.tourguide.model.Museums;
import com.example.jagat.tourguide.model.Parks;
import com.example.jagat.tourguide.model.Restaurants;

import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantActivity extends Fragment {

    private static final String CLASS_NAME="Restaurants";

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Restaurants> mRestaurantList;
    private RestaurantAdapter mAdapter;

    private OnFragmentInteractionListener mListener;
    private View mView;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity())
                .setActionBarTitle(CLASS_NAME);

        mView=inflater.inflate(R.layout.common_fragment_layout,container,false);
        mRecyclerView=mView.findViewById(R.id.recycler_view);
        mRestaurantList=new ArrayList<Restaurants>();
        mAdapter=new RestaurantAdapter(getContext(),mRestaurantList);
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
            Restaurants object= new Restaurants(names[i],des[i],address[i],type[i],thumbnails[i],rating[i],days);
            mRestaurantList.add(object);
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
            mListener = (RestaurantActivity.OnFragmentInteractionListener) context;
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
