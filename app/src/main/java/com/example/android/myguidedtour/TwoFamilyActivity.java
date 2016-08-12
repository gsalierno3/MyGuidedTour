package com.example.android.myguidedtour;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        // Set a click listener to open a map
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                /**
                 * Callback method to be invoked when an item in this AdapterView has
                 * been clicked.
                 * <p>
                 * Implementers can call getItemAtPosition(position) if they need
                 * to access the data associated with the selected item.
                 *
                 * @param parent   The AdapterView where the click happened.
                 * @param view     The view within the AdapterView that was clicked (this
                 *                 will be a view provided by the adapter)
                 * @param position The position of the view in the adapter.
                 * @param id       The row id of the item that was clicked.
                 */
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    //check if the project instance contains coordinates for its location.  If there are, open a mapping app
                    // first let the {@link Project} object at the given position.
                    Project project = projects.get(position);

                    if (project.hasLocation())
                    {
                        locate(project.getGeoString());
                    }
                }
            }
        );

    }

    /**
     * Given a formatted string with a project location, open a map activity
     * @param geoString
     */
    private void locate(String geoString)
    {
        // Create a URI from a string that contents the latitute, longitude and zoom
        Uri gmmIntentUri = Uri.parse(geoString);

        // Create an Intent from gmmIntentUri.  Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);


        // Make the Intent explicit by setting the Google Maps package
        // mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(getPackageManager()) != null)
        {
            Toast.makeText(this, "Press the device's back button to get back", Toast.LENGTH_LONG).show();
            startActivity(mapIntent);
        }
    }
}

