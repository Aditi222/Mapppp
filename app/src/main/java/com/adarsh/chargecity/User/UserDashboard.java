package com.adarsh.chargecity.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.adarsh.chargecity.Common.LoginSignup.RetailerStartUpScreen;
import com.adarsh.chargecity.MapsActivity;
import com.adarsh.chargecity.R;
import com.adarsh.chargecity.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.adarsh.chargecity.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.adarsh.chargecity.HelperClasses.HomeAdapter.FeaturedAdpater;
import com.adarsh.chargecity.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.adarsh.chargecity.HelperClasses.HomeAdapter.MostViewedAdpater;
import com.adarsh.chargecity.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class  UserDashboard extends AppCompatActivity {

    RecyclerView featuredRecycler,mostViewedRecycler,categoriesRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1,gradient2,gradient3,gradient4;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView img ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler=findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler =findViewById(R.id.categories_recycler);

        //Menu Hooks
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);

        //Function will be executed automatically when this activity will be created
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
        img=findViewById(R.id.battery);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(UserDashboard.this, MapsActivity.class);
                        startActivity(it);
            }
        });

    }



    private void featuredRecycler(){


        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations =new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.car3,"Map","hgjtfuk uyfuogiy giuhi"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.car1,"Repairing Station","hgjtfuk uyfuogiy giuhi"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.car2,"Showrooms","hgjtfuk uyfuogiy giuhi"));

        adapter = new FeaturedAdpater(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }



    private void categoriesRecycler() {

    //All Gradients
    gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
    gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
    gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
    gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
    ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.school_image, "JETTER"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2, R.drawable.hospital_image, "DEXPRESS"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3, R.drawable.restaurant_image, "JETTER CLASSIC"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient4, R.drawable.shopping_image, "TURNER"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.transport_image, "Batt:RE"));
        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);
    }

    public void callRetailerScreens(View view){

        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));


    }



    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.car1, "McDonald's"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.car3, "Edenrobe"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.car2, "J."));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.car4, "Walmart"));
        adapter = new MostViewedAdpater(mostViewedLocations); mostViewedRecycler.setAdapter(adapter);
    }


}




