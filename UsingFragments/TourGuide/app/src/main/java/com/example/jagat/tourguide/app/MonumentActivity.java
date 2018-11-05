package com.example.jagat.tourguide.app;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import com.example.jagat.tourguide.R;
import com.example.jagat.tourguide.customAdapter.MonumentAdapter;
import com.example.jagat.tourguide.model.Monument;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MonumentActivity extends Fragment {

    // Leaved changed!
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String CLASS_NAME="Monuments";


    // Custom variables for adding the recycle view to the layout
    private RecyclerView mRecycleView;
    private MonumentAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Monument> mMonumentList;
    private View mView;

    private Context mContext;

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


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MonumentActivity() {
        // Required empty public constructor
    }


    public static MonumentActivity newInstance(String param1, String param2) {
        MonumentActivity fragment = new MonumentActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity())
                .setActionBarTitle(CLASS_NAME);

        mView=inflater.inflate(R.layout.common_fragment_layout,container,false);
        mRecycleView=mView.findViewById(R.id.recycler_view);
        mMonumentList=new ArrayList<Monument>();
        mAdapter=new MonumentAdapter(getContext(),mMonumentList);
        mLayoutManager=new GridLayoutManager(getContext(),2);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
        prepareData();
        return mView;
    }

    private void prepareData(){
        for(int i=0;i<names.length;i++) {
            Monument monumentObject = new Monument(names[i],rating[i],thumbnails[i],days);
            mMonumentList.add(monumentObject);
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
