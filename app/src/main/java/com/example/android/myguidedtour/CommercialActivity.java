package com.example.android.myguidedtour;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class CommercialActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commercial);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.commercial_viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        CommercialFragmentPageAdapter adapter = new CommercialFragmentPageAdapter(getSupportFragmentManager(), getApplication());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.commercial_sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
