package com.example.android.myguidedtour;

/**
 * Created by genarosalierno on 7/31/16.
 */
public class Project
{

    private String nName;
    /** Image resource ID for the word */
    private int NO_IMAGE_PROVIDED = -1;
    private int nImageResourceID = NO_IMAGE_PROVIDED;
    private double nLatitude;
    private double nLongitude;
    private String nText;
    private String nGeoString = ""; // contains the string to use with the map intent

    /**
     * Five parameter Constructor
     * @param name
     * @param imageResourceID
     * @param x
     * @param y
     */
    public Project (String name, int imageResourceID, double x, double y, String text)
    {
        nName = name;
        nImageResourceID = imageResourceID;
        nLatitude = x;
        nLongitude = y;
        nText = text;
        nGeoString = "geo:"+ Double.toString(nLatitude) + ","+Double.toString(nLongitude)+"?z=21";
    }

    /**
     * Three parameter constructor - no geolocation
     * @param name
     * @param imageResourceID
     * @param text
     */
    public Project (String name, int imageResourceID, String text)
    {
        nName = name;
        nImageResourceID = imageResourceID;
        nText = text;
    }

    /**
     *
     * @return nName
     */
    public String getName()
    {
        return nName;
    }

    /**
     *
     * @return nImageResourceID
     */
    public int getImageResourceID()
    {
        return nImageResourceID;
    }

    /**
     *
     * @return nText
     */
    public String getText()
    {
        return nText;
    }

    /**
     *
     * @return nGeoString
     */
    public String getGeoString()
    {
        return nGeoString;
    }

    /**
     *
     * @return boolean
     */
    public boolean hasLocation()
    {
         if (nGeoString.equals(""))return false;
        return true;
    }
}
