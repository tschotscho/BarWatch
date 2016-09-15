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
public class Monday extends Fragment {

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

    // Montags Angebote
    private BarItem altefilm_mo;
    private BarItem banane_mo;
    private BarItem heimat_mo;
    private BarItem pirat_mo;
    private BarItem no7_mo;
    private BarItem picasso_mo;
    private BarItem bar13_mo;
    private BarItem max_mo;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.monday_layout, container, false);

        list = (ListView) v.findViewById(R.id.mon_list);


        initDB();
        initUI();
        updateList();
        initDaily();
        initMonday();


        return v;
    }

    private void initMonday() {

        altefilm_mo = new BarItem(getString(R.string.alteFilm),getString(R.string.altefilm_mo));
        banane_mo = new BarItem(getString(R.string.banane),getString(R.string.banane_mo));
        heimat_mo = new BarItem(getString(R.string.heimat),getString(R.string.heimat_mo));
        pirat_mo = new BarItem(getString(R.string.piratenhöhle), getString(R.string.pirat_mo));
        no7_mo = new BarItem(getString(R.string.no7), getString(R.string.no7_mo));
        picasso_mo = new BarItem(getString(R.string.picasso), getString(R.string.pirat_mo));
        bar13_mo = new BarItem(getString(R.string.bar13), getString(R.string.bar13_mo));
        max_mo = new BarItem(getString(R.string.max), getString(R.string.max_mo));

        bars.add(altefilm_mo);
        bars.add(banane_mo);
        bars.add(heimat_mo);
        bars.add(pirat_mo);
        bars.add(no7_mo);
        bars.add(picasso_mo);
        bars.add(bar13_mo);
        bars.add(max_mo);

    }

    private void initDaily() {
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
