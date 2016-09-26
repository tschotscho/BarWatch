package com.example.hannes.barwatch.weekfragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hannes.barwatch.R;

import java.util.ArrayList;

import com.example.hannes.barwatch.adapter.BarAdapter;
import com.example.hannes.barwatch.item.BarItem;

/**
 * Created by Christopher on 11.08.2016.
 */
public class Daily extends Fragment {

    private ListView list;
    // Button add;

    private ArrayList<BarItem> bars = new ArrayList<BarItem>();
    private BarAdapter bar_adapter;
    //private BarDatabase bar_db;


    // Tägliche Angebote
    private BarItem kasper;
    private BarItem hemmingways;
    private BarItem ubar;
    private BarItem jagd;
    private BarItem barock;
    private BarItem franky;
    private BarItem orange;
    private BarItem no7;
    private BarItem margaritas;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.offer_layout, container, false);

        list = (ListView) v.findViewById(R.id.daily_list);
        //add = (Button) v.findViewById(R.id.fav_add_button);

        TextView week = (TextView) v.findViewById(R.id.weekday);

        week.setText("Täglich");

        // initDB();
        initUI();
        //updateList();
        initDaily();
        // initButton();


        return v;
    }

    /*private void initButton() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }*/

    private void initDaily() {
        margaritas = new BarItem(getString(R.string.ab17), getString(R.string.margaritas), getString(R.string.margaritas_d), getString(R.string.day_da));
        hemmingways = new BarItem(getString(R.string.ab19), getString(R.string.hemmingways), getString(R.string.hem_d), getString(R.string.day_da));
        kasper = new BarItem(getString(R.string.ab20), getString(R.string.kasper), getString(R.string.kasper_d), getString(R.string.day_da));
        jagd = new BarItem(getString(R.string.ab20), getString(R.string.jagd), getString(R.string.jagd_d), getString(R.string.day_da));
        ubar = new BarItem(getString(R.string.ab21), getString(R.string.ubar), getString(R.string.ubar_d), getString(R.string.day_da));
        barock = new BarItem(getString(R.string.ab20), getString(R.string.barock), getString(R.string.barock_d), getString(R.string.day_da));
        franky = new BarItem(getString(R.string.ab20), getString(R.string.frankys), getString(R.string.franky_d), getString(R.string.day_da));
        orange = new BarItem(getString(R.string.ab20), getString(R.string.orange), getString(R.string.orange_d), getString(R.string.day_da));
        no7 = new BarItem(getString(R.string.ab20), getString(R.string.no7), getString(R.string.no7_d), getString(R.string.day_da));

        bars.add(margaritas);
        bars.add(hemmingways);
        bars.add(kasper);
        bars.add(jagd);
        bars.add(barock);
        bars.add(franky);
        bars.add(orange);
        bars.add(no7);
        bars.add(ubar);
    }

    private void updateList() {
    }

/*
    private void initDB() {
        bar_db = new BarDatabase(this.getActivity());
        bar_db.open();
    }
    */

    private void initUI() {
        initListView();
        initFavAdapter();
    }

    private void initFavAdapter() {
        bar_adapter = new BarAdapter(this.getActivity(), bars);
        list.setAdapter(bar_adapter);
    }


    private void initListView() {
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
