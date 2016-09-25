package com.example.hannes.barwatch.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hannes.barwatch.R;

import java.util.ArrayList;
import java.util.List;

import com.example.hannes.barwatch.adapter.WeekPagerAdapter;
import com.example.hannes.barwatch.weekfragments.Daily;
import com.example.hannes.barwatch.weekfragments.Monday;
import com.example.hannes.barwatch.weekfragments.Tuesday;
import com.example.hannes.barwatch.weekfragments.Wednesday;
import com.example.hannes.barwatch.weekfragments.Thursday;
import com.example.hannes.barwatch.weekfragments.Friday;
import com.example.hannes.barwatch.weekfragments.Saturday;
import com.example.hannes.barwatch.weekfragments.Sunday;

/**
 * Created by Christopher on 18.08.2016.
 */
public class Home extends Fragment {

    List<Fragment> listWeek;
    ViewPager viewpager;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.home_layout, container, false);

        initViewPager();

        return v;
    }

    public void initViewPager() {
        viewpager = (ViewPager) v.findViewById(R.id.view_pager);

        listWeek = new ArrayList<Fragment>();
        listWeek.add(new Daily());
        listWeek.add(new Monday());
        listWeek.add(new Tuesday());
        listWeek.add(new Wednesday());
        listWeek.add(new Thursday());
        listWeek.add(new Friday());
        listWeek.add(new Saturday());
        listWeek.add(new Sunday());

        WeekPagerAdapter weekPagerAdapter = new WeekPagerAdapter(getChildFragmentManager(), listWeek);
        viewpager.setAdapter(weekPagerAdapter);
    }

}
