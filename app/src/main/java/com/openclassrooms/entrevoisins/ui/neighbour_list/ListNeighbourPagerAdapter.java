package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Switch;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    private static int MUN_ITEM = 2;

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) { return NeighbourFragment.newInstance(); }


    /**
     * get the number of pages
     * @return
     */
    @Override
    public int getCount() {
        return MUN_ITEM;
    }


}