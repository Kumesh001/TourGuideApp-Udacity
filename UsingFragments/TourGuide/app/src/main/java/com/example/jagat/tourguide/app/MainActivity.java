package com.example.jagat.tourguide.app;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
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

public class MainActivity extends AppCompatActivity
                           implements MainAdapter.RecyclerItemClickListener.OnItemClickListener,
                                      MonumentActivity.OnFragmentInteractionListener,
                                       ParkActivity.OnFragmentInteractionListener,
                                       RestaurantActivity.OnFragmentInteractionListener,
                                       MusuemActivity.OnFragmentInteractionListener
   {

    // RecycleView Related Objects
    private RecyclerView mRecycleview;
    private RecyclerView.LayoutManager mLayoutmanager;
    private MainAdapter mMainAdapter;

    private List<Category> mListCategory;

    //Fragment Related Objects
    private FragmentManager fm;

    // NavigationBar
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private ActionBar actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        fm=getSupportFragmentManager();

        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_button_of_three_horizontal_lines);

        mDrawerLayout=findViewById(R.id.drawer_layout);
        mNavigationView=findViewById(R.id.navigation_view);


        // click listenere for the items in the navigation view;
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        menuItem.setChecked(true);

                        switch (menuItem.getTitle().toString())
                        {
                            case "Home":
                                      for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                                           fm.popBackStack();
                                         }
                                break;
                            case "Historical Monument":FragmentTransaction ft=fm.beginTransaction();
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
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                }
        );

        mRecycleview=findViewById(R.id.recycler_view);
        mListCategory=new ArrayList<>();
        mMainAdapter=new MainAdapter(getApplicationContext(),mListCategory,fm);

        // we have used the GridLayout here
        mLayoutmanager=new LinearLayoutManager(getApplicationContext());
        mRecycleview.setLayoutManager(mLayoutmanager);
        // This line is changed
        //mRecycleview.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        mRecycleview.setItemAnimator(new DefaultItemAnimator());
        mRecycleview.setAdapter(mMainAdapter);

        prepareMainScreen();
    }

       @Override
       public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId())
            {
                case android.R.id.home:
                    mDrawerLayout.openDrawer(GravityCompat.START);
                    return true;
            }
           return super.onOptionsItemSelected(item);
       }

       public void prepareMainScreen(){
        int[] covers = new int[]{
                R.drawable.monument,
                R.drawable.national_zoological_park_1,
                R.drawable.bukhra,
                R.drawable.art_museum
        };
        Category a = new Category("Monuments",covers[0]);
        mListCategory.add(a);

        a = new Category("Parks",covers[1]);
        mListCategory.add(a);

        a = new Category("Restaurants",covers[2]);
        mListCategory.add(a);

        a = new Category("Museums", covers[3]);
        mListCategory.add(a);

        mMainAdapter.notifyDataSetChanged();
    }

    public void setActionBarTitle(String title){
        actionbar.setTitle(title);
    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
       @Override
       public void onBackPressed() {
           Fragment fragment=fm.findFragmentById(R.id.frameContent);
           if(fragment!=null)
           {
               FragmentTransaction ft=fm.beginTransaction();
               ft.remove(fragment);
               ft.commit();
           }
           else {
               super.onBackPressed();
           }
       }

   }
