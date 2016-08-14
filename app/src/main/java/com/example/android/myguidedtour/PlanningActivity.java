package com.example.android.myguidedtour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PlanningActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_list);

        //create list of projects
        final ArrayList<Project> projects = new ArrayList<Project>();
        projects.add(new Project(getString(R.string.planning1_name), R.drawable.plan_garfield,
                getString(R.string.planning1_text)));
        projects.add(new Project(getString(R.string.planning2_name), R.drawable.plan_hamlet,
                getString(R.string.planning2_text)));

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
