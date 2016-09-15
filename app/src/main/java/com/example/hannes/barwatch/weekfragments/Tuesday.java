package com.example.hannes.barwatch.weekfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hannes.barwatch.R;

import java.util.ArrayList;

import com.example.hannes.barwatch.adapter.BarAdapter;
import com.example.hannes.barwatch.database.BarDatabase;
import com.example.hannes.barwatch.item.BarItem;

/**
 * Created by Christopher on 11.08.2016.
 */
public class Tuesday extends Fragment {
    ListView list;

    private ArrayList<BarItem> bars = new ArrayList<BarItem>();
    private BarAdapter bar_adapter;
    private BarDatabase bar_db;

    // Tägliche Angebote
    private BarItem kasper_d;
    private BarItem hemmingways_d;
    private BarItem  ubar_d;
    private BarItem jagd_d;
    private BarItem barock_d;
    private BarItem franky_d;
    private BarItem orange_d;
    private BarItem no7_d;
    private BarItem margaritas_d;

    //Dienstags Angebote





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tuesday_layout, container, false);

        list = (ListView) v.findViewById(R.id.tue_list);


        initDB();
        initUI();
        updateList();
        initDaily();
        initTuesday();

        return v;
    }

    private void initTuesday() {
    }

    private void initDaily(){
        kasper_d = new BarItem(getString(R.string.kasper), getString(R.string.kasper_d));
        hemmingways_d = new BarItem(getString(R.string.hemmingways),getString(R.string.hem_d));
        ubar_d = new BarItem(getString(R.string.ubar), getString(R.string.ubar_d));
        jagd_d = new BarItem(getString(R.string.jagd), getString(R.string.jagd_d));
        barock_d = new BarItem(getString(R.string.barock), getString(R.string.barock_d));
        franky_d = new BarItem(getString(R.string.frankys), getString(R.string.franky_d));
        orange_d = new BarItem(getString(R.string.orange), getString(R.string.orange_d));
        no7_d = new BarItem(getString(R.string.no7), getString(R.string.no7_d));
        margaritas_d = new BarItem(getString(R.string.margaritas), getString(R.string.margaritas_d));



        bars.add(kasper_d);
        bars.add(hemmingways_d);
        bars.add(ubar_d);
        bars.add(jagd_d);
        bars.add(barock_d);
        bars.add(franky_d);
        bars.add(orange_d);
        bars.add(no7_d);
        bars.add(margaritas_d);

    }

    private void updateList() {
        bars.clear();
        bars.addAll(bar_db.getAllToDoItems());
        bar_adapter.notifyDataSetChanged();
    }

    private void initDB(){
        bar_db = new BarDatabase(this.getActivity());
        bar_db.open();
    }

    private void initUI(){
        initTaskButton();
        initListView();
        initFavAdapter();
    }

    private void initFavAdapter() {
        bar_adapter = new BarAdapter(this.getActivity(), bars);
        list.setAdapter(bar_adapter);
    }

    private void initTaskButton() {
    }

    private void initListView(){
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                removeBarAtPosition(position);
                return false;
            }
        });

    }

    private void removeBarAtPosition(int position) {
    }
}
