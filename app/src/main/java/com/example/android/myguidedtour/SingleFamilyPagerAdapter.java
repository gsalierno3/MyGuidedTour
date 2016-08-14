package com.example.android.myguidedtour;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by genarosalierno on 8/9/16.
 */
public class SingleFamilyPagerAdapter extends FragmentPagerAdapter
{
    private final int NUMBER_OF_FRAGMENTS = 2;
    private Context context;
    private String[] tabTitles;


    /**
     *
     * @param fm
     */
    public SingleFamilyPagerAdapter(FragmentManager fm, Context c)
    {
        super(fm);
        context = c.getApplicationContext();;
        tabTitles = new String[]{context.getString(R.string.architecture), context.getString(R.string.interior_design)};
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position)
    {
        if (position==0) return new SingleFamilyFragment();

        return new SingleFamilyInteriorFragment();
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
