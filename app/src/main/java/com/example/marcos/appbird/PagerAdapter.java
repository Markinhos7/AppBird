package com.example.marcos.appbird;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Marcos on 31-05-2016.
 */
public class PagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new OneFragment();
        }
        else if (position == 1)
        {
            fragment = new TwoFragment();
        }
        else if (position == 2)
        {
            fragment = new ThreeFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "HOME";
        }
        else if (position == 1)
        {
            title = "FAVORITOS";
        }
        else if (position == 2)
        {
            title = "PERFIL";
        }
        return title;
    }
}