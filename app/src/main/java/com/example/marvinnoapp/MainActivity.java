package com.example.marvinnoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.Button;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button login, signup;
    WormDotsIndicator wormDotsIndicator;
    ViewPager2 viewPager;
    ViewPagerAdapter adapter;
    List<IntroModel> introList = new ArrayList<>();

    protected void init(){
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide(); // hide the title bar
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.setStatusBarColor(Color.TRANSPARENT);

//
//        getWindow().setNavigationBarColor(ContextCompat.getColor(MainActivity.this, R.color.White));
//        getWindow().getDecorView().setSystemUiVisibility( WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS);


        init();
        introList.add(new IntroModel("giu","ugi",R.drawable.ic_launcher_background));
        introList.add(new IntroModel("giu","ugi",R.drawable.ic_launcher_background));
        introList.add(new IntroModel("giu","ugi",R.drawable.ic_launcher_background));

        wormDotsIndicator = (WormDotsIndicator) findViewById(R.id.worm_dots_indicator);
        viewPager = (ViewPager2) findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(MainActivity.this,introList);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setAdapter(adapter);
        wormDotsIndicator.setViewPager2(viewPager);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                Log.e("Selected_Page", String.valueOf(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });



        adapter.notifyDataSetChanged();

//        GradientDrawable sd = (GradientDrawable) signup.getBackground();
//        sd.setColor(ContextCompat.getColor(this, R.color.offWhite));
//
//        GradientDrawable sd1 = (GradientDrawable) login.getBackground();
//        sd1.setColor(ContextCompat.getColor(this, R.color.mediumGreen));


    }
}