package com.example.hannes.barwatch;

import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Fragment> listWeek;
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }
    /**
    @Override
    public boolean onCreateOptionsMenu(MenuItem menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    **/

    public void initUI(){
        initViewPager();
        initListWeek();
        initWeekPagerAdapter();
    }

    public void initViewPager(){
        viewpager = (ViewPager) findViewById(R.id.view_pager);
    }

    public void initListWeek(){
        listWeek = new ArrayList<Fragment>();
        listWeek.add(new Monday());
        listWeek.add(new Tuesday());
        listWeek.add(new Wednesday());
        listWeek.add(new Thursday());
        listWeek.add(new Friday());
        listWeek.add(new Saturday());
        listWeek.add(new Sunday());
    }

    public void initWeekPagerAdapter(){
        WeekPagerAdapter weekPagerAdapter = new WeekPagerAdapter(getSupportFragmentManager(), listWeek);
        viewpager.setAdapter(weekPagerAdapter);
    }
}
