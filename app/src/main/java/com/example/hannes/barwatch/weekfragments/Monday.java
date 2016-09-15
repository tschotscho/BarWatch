package com.example.hannes.barwatch.weekfragments;

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

        View v = inflater.inflate(R.layout.daily_layout, container, false);

        list = (ListView) v.findViewById(R.id.daily_list);

        TextView week = (TextView) v.findViewById(R.id.weekday);
        week.setText("Montag");

        initDB();
        initUI();
        updateList();
        initMonday();


        return v;
    }

    private void initMonday() {

        altefilm_mo = new BarItem(getString(R.string.ab20), getString(R.string.alteFilm), getString(R.string.altefilm_mo));
        banane_mo = new BarItem(getString(R.string.ab20), getString(R.string.banane), getString(R.string.banane_mo));
        heimat_mo = new BarItem(getString(R.string.ab20), getString(R.string.heimat), getString(R.string.heimat_mo));
        pirat_mo = new BarItem(getString(R.string.ab20), getString(R.string.piratenhöhle), getString(R.string.pirat_mo));
        no7_mo = new BarItem(getString(R.string.ab20), getString(R.string.no7), getString(R.string.no7_mo));
        picasso_mo = new BarItem(getString(R.string.ab20), getString(R.string.picasso), getString(R.string.pirat_mo));
        bar13_mo = new BarItem(getString(R.string.ab20), getString(R.string.bar13), getString(R.string.bar13_mo));
        max_mo = new BarItem(getString(R.string.ab20), getString(R.string.max), getString(R.string.max_mo));

        bars.add(altefilm_mo);
        bars.add(banane_mo);
        bars.add(heimat_mo);
        bars.add(pirat_mo);
        bars.add(no7_mo);
        bars.add(picasso_mo);
        bars.add(bar13_mo);
        bars.add(max_mo);

    }

    private void updateList() {
        bars.clear();
        bars.addAll(bar_db.getAllToDoItems());
        bar_adapter.notifyDataSetChanged();
    }

    private void initDB() {
        bar_db = new BarDatabase(this.getActivity());
        bar_db.open();
    }

    private void initUI() {
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
