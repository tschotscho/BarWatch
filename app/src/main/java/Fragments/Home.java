package Fragments;

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

import Adapter.WeekPagerAdapter;
import weekfragments.Monday;
import weekfragments.Tuesday;
import weekfragments.Wednesday;
import weekfragments.Thursday;
import weekfragments.Friday;
import weekfragments.Saturday;
import weekfragments.Sunday;

/**
 * Created by Christopher on 18.08.2016.
 */
public class Home extends Fragment {

    List<Fragment> listWeek;
    ViewPager viewpager;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_home, container, false);

        //We put Viewpager here

        initViewPager();

        return v;
    }

    public void initViewPager(){
        viewpager = (ViewPager) v.findViewById(R.id.view_pager);

        listWeek = new ArrayList<Fragment>();
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
