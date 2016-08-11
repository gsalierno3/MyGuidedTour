package com.example.android.myguidedtour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MultifamilyActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_list);

        //create list of projects
        final ArrayList<Project> projects = new ArrayList<Project>();
        projects.add(new Project("Residential building", R.drawable.multi_federal, 41.008970, -74300426,
                "21 unit residential complex of two-story dwelling units.  Pompton Lakes, NJ"));
        projects.add(new Project("90 unit building", R.drawable.multi_rahway,40.609281, -74.268479,
                "Four story residential over covered parking. Rahway, NJ"));
        projects.add(new Project("Multifamily study", R.drawable.multi_rutherford,
                "Multifamily building study on a triangular lot.  Rutherford, NJ"));
        projects.add(new Project("Townhouses", R.drawable.multi_wallington1,40.858851, -74.116404,
                "Two-unit townhouse building on a complex with 35 dwelling units. Wallington, NJ"));

        ProjectAdapter adapter = new ProjectAdapter(this, projects);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ProjectAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

    }
}
