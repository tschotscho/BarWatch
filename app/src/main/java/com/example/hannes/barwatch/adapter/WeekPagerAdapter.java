package com.example.hannes.barwatch.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Christopher on 11.08.2016.
 */
public class WeekPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> listWeek;

    public WeekPagerAdapter(FragmentManager fm, List<Fragment> listWeek){
        super(fm);
        this.listWeek = listWeek;
    }

    @Override
    public Fragment getItem(int position){

        return listWeek.get(position);
    }

    @Override
    public int getCount(){

        return listWeek.size();
    }

}
