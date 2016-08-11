package com.example.android.myguidedtour;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by genarosalierno on 7/27/16.
 */
public class CommercialFragmentPageAdapter extends FragmentPagerAdapter
{

    private final int NUMBER_OF_FRAGMENTS = 3;

    // Holds titles of tabs for commercial buildings
    private String[] tabTitles = new String[]{"Medical/Retail Buildings", "Art Gallery", "Commercial Interiors"};

    /**
     *Constructor
     * @param fm
     */
    public CommercialFragmentPageAdapter(FragmentManager fm)
    {
        super(fm);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position)
    {
        switch(position)
        {
            case 0:
                return new CommercialAmatoFragment();
            case 1:
                return new CommercialLinaFragment();
        }
        return new CommercialInteriorFragment();
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount()
    {
        return NUMBER_OF_FRAGMENTS;
    }

    /**
     * This method may be called by the ViewPager to obtain a title string
     * to describe the specified page. This method may return null
     * indicating no title for this page. The default implementation returns
     * null.
     *
     * @param position The position of the title requested
     * @return A title for the requested page
     */
    @Override
    public CharSequence getPageTitle(int position)
    {
        return tabTitles[position];
    }
}
