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
import com.example.hannes.barwatch.item.BarItem;

/**
 * Created by Christopher on 11.08.2016.
 */
public class Monday extends Fragment {

    private ListView list;

    private ArrayList<BarItem> bars = new ArrayList<BarItem>();
    private BarAdapter bar_adapter;

    // Montags Angebote
    private BarItem altefilm;
    private BarItem banane;
    private BarItem heimat;
    private BarItem pirat;
    private BarItem no7;
    private BarItem picasso;
    private BarItem bar13;
    private BarItem max;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.offer_layout, container, false);

        list = (ListView) v.findViewById(R.id.daily_list);

        TextView week = (TextView) v.findViewById(R.id.weekday);
        week.setText("Montag");

        initUI();
        initMonday();


        return v;
    }

    private void initMonday() {

        altefilm = new BarItem(getString(R.string.ab20), getString(R.string.alteFilm), getString(R.string.altefilm_mo), getString(R.string.day_mo));
        banane = new BarItem(getString(R.string.ab19), getString(R.string.banane), getString(R.string.banane_mo), getString(R.string.day_mo));
        heimat = new BarItem(getString(R.string.ab19), getString(R.string.heimat), getString(R.string.heimat_mo), getString(R.string.day_mo));
        pirat = new BarItem(getString(R.string.ab19), getString(R.string.piratenhöhle), getString(R.string.pirat_mo), getString(R.string.day_mo));
        no7 = new BarItem(getString(R.string.ab20), getString(R.string.no7), getString(R.string.no7_mo), getString(R.string.day_mo));
        picasso = new BarItem(getString(R.string.ab20), getString(R.string.picasso), getString(R.string.pirat_mo), getString(R.string.day_mo));
        bar13 = new BarItem(getString(R.string.ab20), getString(R.string.bar13), getString(R.string.bar13_mo), getString(R.string.day_mo));
        max = new BarItem(getString(R.string.ab20), getString(R.string.max), getString(R.string.max_mo), getString(R.string.day_mo));

        bars.add(banane);
        bars.add(heimat);
        bars.add(pirat);
        bars.add(altefilm);
        bars.add(no7);
        bars.add(picasso);
        bars.add(bar13);
        bars.add(max);

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
