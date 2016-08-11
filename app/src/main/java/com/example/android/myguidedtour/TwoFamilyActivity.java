package com.example.android.myguidedtour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TwoFamilyActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_list);

        //create list of projects
        final ArrayList<Project> projects = new ArrayList<Project>();
        projects.add(new Project("Traditional two family", R.drawable.twofam_1,
                "Speculative two family project in a narrow lot (25' x 100').  Paterson, NJ"));
        projects.add(new Project("Retail Building", R.drawable.twofam_2,
                "Douplex two-family project in Fassaic, NJ"));

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
