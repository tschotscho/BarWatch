package com.example.hannes.barwatch.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hannes.barwatch.R;
import com.example.hannes.barwatch.adapter.BarAdapter;
import com.example.hannes.barwatch.database.BarDatabase;
import com.example.hannes.barwatch.item.BarItem;

import java.util.ArrayList;

/**
 * Created by Christopher on 18.08.2016.
 */
public class Favourite extends Fragment {

    private ListView list;
    private BarAdapter bar_adapter;
    private ArrayList<BarItem> test;
    private BarDatabase db;

    public Favourite () {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_favourites, container, false);
        list = (ListView) v.findViewById(R.id.fav_list);
        initUI();


        return v;
    }

    private void initUI() {

        db = new BarDatabase(this.getActivity());
        db.open();
        initFavAdapter();
    }



    private void initFavAdapter() {
        /*BarItem bb = new BarItem("8:00","BB","ABC");
        test = new ArrayList<BarItem>();
        test.add(bb);*/
        bar_adapter = new BarAdapter(this.getActivity(),db.getAllToDoItems());
        list.setAdapter(bar_adapter);
    }






}
