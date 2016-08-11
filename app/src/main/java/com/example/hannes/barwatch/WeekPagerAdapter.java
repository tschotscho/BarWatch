package com.example.hannes.barwatch;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Christopher on 11.08.2016.
 */
public class WeekPagerAdapter extends FragmentPagerAdapter {

    public WeekPagerAdapter(FragmentManager fm, List<Fragment> listFragments){
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0){
        return null;
    }

    @Override
    public int getCount(){
        return 0;
    }

}
