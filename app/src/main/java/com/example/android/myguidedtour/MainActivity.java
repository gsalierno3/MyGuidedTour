package com.example.android.myguidedtour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view that shows the commercial category
        LinearLayout linearLayoutCommercial = (LinearLayout) findViewById(R.id.commercial);

        // Set a click listener for the commercial category
        linearLayoutCommercial.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Create an intent to open the {@link CommercialActivity}
                Intent commercialIntent = new Intent(MainActivity.this, CommercialActivity.class);

                // Start the CommercialActivity
                startActivity(commercialIntent);
            }
        });

        // Find the view that shows the single famly category
        LinearLayout linearLayoutSingleFamily = (LinearLayout) findViewById(R.id.single_family);

        // Set a click listener for a single family category
        linearLayoutSingleFamily.setOnClickListener (new View.OnClickListener()
        {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v)
            {
                // Create an intent to open the {@link SingleFamilyActivity}
                Intent singleFamilyIntent = new Intent(MainActivity.this, SingleFamilyActivity.class);

                // Start the SingleFamilyActivity
                startActivity(singleFamilyIntent);
            }
        });

        // Find the view that shows the two famly category
        LinearLayout linearLayoutTwoFamily = (LinearLayout) findViewById(R.id.two_family);

        // Set a click listener for a single family category
        linearLayoutTwoFamily.setOnClickListener (new View.OnClickListener()
        {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v)
            {
                // Create an intent to open the {@link TwoFamilyActivity}
                Intent twoFamilyIntent = new Intent(MainActivity.this, TwoFamilyActivity.class);

                // Start the SingleFamilyActivity
                startActivity(twoFamilyIntent);
            }
        });

        // Find the view that shows the multifamly category
        LinearLayout linearLayoutMultiFamily = (LinearLayout) findViewById(R.id.multifamily);

        // Set a click listener for a single family category
        linearLayoutMultiFamily.setOnClickListener (new View.OnClickListener()
        {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v)
            {
                // Create an intent to open the {@link MultifamilyActivity}
                Intent multiFamilyIntent = new Intent(MainActivity.this, MultifamilyActivity.class);

                // Start the MultifamilyActivity
                startActivity(multiFamilyIntent);
            }
        });

        // Find the view that shows the multifamly category
        LinearLayout linearLayoutPlanning = (LinearLayout) findViewById(R.id.planning);

        // Set a click listener for a single family category
        linearLayoutPlanning.setOnClickListener (new View.OnClickListener()
        {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v)
            {
                // Create an intent to open the {@link MultifamilyActivity}
                Intent planningIntent = new Intent(MainActivity.this, PlanningActivity.class);

                // Start the MultifamilyActivity
                startActivity(planningIntent);
            }
        });


    }
}
