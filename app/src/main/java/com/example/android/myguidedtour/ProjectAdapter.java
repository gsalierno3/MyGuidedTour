package com.example.android.myguidedtour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by genarosalierno on 7/31/16.
 */
public class ProjectAdapter extends ArrayAdapter<Project>
{
    public ProjectAdapter (Context context, ArrayList<Project> projects)
    {
        super(context, 0, projects);
    }

    /**
     * {@inheritDoc}
     *
     * @param position
     * @param convertView
     * @param parent
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Project currentProject = getItem(position);

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // display the provided image based on the resource ID
        imageView.setImageResource(currentProject.getImageResourceID());

        //Find the TextView in the list_item.xml for the picture title
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentProject.getName());

        //Find the TextView in the list_item.xml for the picture text
        TextView textTextView = (TextView) listItemView.findViewById(R.id.content_text_view);
        textTextView.setText(currentProject.getText());

        // Find the ImageView with a link to a map app
        ImageView mapImageView = (ImageView) listItemView.findViewById(R.id.map_image);
        // display the image if coordinates are provided.
        if(currentProject.hasLocation())
        {
            // If the project has a location, then display the map icon
            imageView.setVisibility(View.VISIBLE);
        } else
        {
            // if there is no location, then do not display the map icon
            mapImageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
