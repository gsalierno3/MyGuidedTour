package com.example.android.myguidedtour;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommercialInteriorFragment extends Fragment
{

    // Constructor
    public CommercialInteriorFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.project_list, container, false);

        //create list of projects
        final ArrayList<Project> projects = new ArrayList<Project>();
        projects.add(new Project(getString(R.string.commercial_interior1_name), R.drawable.corporate_interior_1,
                getString(R.string.commercial_interior1_text)));
        projects.add(new Project(getString(R.string.commercial_interior2_name), R.drawable.corporate_interior_2,
                getString(R.string.commercial_interior2_text)));

        // Create a {@link ProjectAdapter whose data source is a list of {@link Project}s.  The
        // adapter knows how to create list items for each item in the list.
        ProjectAdapter adapter = new ProjectAdapter(getActivity(), projects);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
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

        return rootView;
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

        if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null)
        {
            Toast.makeText(getContext(), getString(R.string.press_back_button), Toast.LENGTH_LONG).show();
            startActivity(mapIntent);
        }
    }
}