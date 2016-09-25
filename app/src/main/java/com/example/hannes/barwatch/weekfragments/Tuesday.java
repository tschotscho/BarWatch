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
public class Tuesday extends Fragment {

    private ListView list;

    private ArrayList<BarItem> bars = new ArrayList<BarItem>();
    private BarAdapter bar_adapter;

    private BarItem hem;
    private BarItem mood;
    private BarItem ubar;
    private BarItem jagd;
    private BarItem altefilm;
    private BarItem banane;
    private BarItem heimat;
    private BarItem pirat;
    private BarItem dasilva;
    private BarItem rauschgold;
    private BarItem ernstl;
    private BarItem suite;
    private BarItem beats;
    private BarItem no7;
    private BarItem picasso;
    private BarItem bar13;
    private BarItem max;
    private BarItem barock;
    private BarItem escobar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.offer_layout, container, false);

        list = (ListView) v.findViewById(R.id.daily_list);

        TextView week = (TextView) v.findViewById(R.id.weekday);
        week.setText("Dienstag");

        initUI();
        initTuesday();

        return v;
    }

    private void initTuesday() {

        hem = new BarItem(getString(R.string.ab19), getString(R.string.hemmingways), getString(R.string.hem_di), getString(R.string.day_tu));
        mood = new BarItem(getString(R.string.ab20), getString(R.string.mood), getString(R.string.mood_di), getString(R.string.day_tu));
        heimat = new BarItem(getString(R.string.ab19), getString(R.string.heimat), getString(R.string.heimat_di), getString(R.string.day_tu));
        pirat = new BarItem(getString(R.string.ab19), getString(R.string.piratenhöhle), getString(R.string.pirat_di), getString(R.string.day_tu));
        no7 = new BarItem(getString(R.string.ab20), getString(R.string.no7), getString(R.string.no7_di), getString(R.string.day_tu));
        picasso = new BarItem(getString(R.string.ab20), getString(R.string.picasso), getString(R.string.picasso_di), getString(R.string.day_tu));
        bar13 = new BarItem(getString(R.string.ab20), getString(R.string.bar13), getString(R.string.bar13_di), getString(R.string.day_tu));
        max = new BarItem(getString(R.string.ab20), getString(R.string.max), getString(R.string.max_di), getString(R.string.day_tu));
        ubar = new BarItem(getString(R.string.ab21), getString(R.string.ubar), getString(R.string.ubar_di), getString(R.string.day_tu));
        jagd = new BarItem(getString(R.string.ab20), getString(R.string.jagd), getString(R.string.jag_di_do), getString(R.string.day_tu));
        altefilm = new BarItem(getString(R.string.ab20), getString(R.string.alteFilm), getString(R.string.alteFilm_di), getString(R.string.day_tu));
        banane = new BarItem(getString(R.string.ab19), getString(R.string.banane), getString(R.string.banane_di), getString(R.string.day_tu));
        dasilva = new BarItem(getString(R.string.ab21), getString(R.string.dasilva), getString(R.string.dasilva_di), getString(R.string.day_tu));
        rauschgold = new BarItem(getString(R.string.ab22), getString(R.string.rauschgold), getString(R.string.rauschgold_di), getString(R.string.day_tu));
        ernstl = new BarItem(getString(R.string.ab00), getString(R.string.ernstl), getString(R.string.ernstl_di), getString(R.string.day_tu));
        suite = new BarItem(getString(R.string.ab22), getString(R.string.suite), getString(R.string.suite_di), getString(R.string.day_tu));
        beats = new BarItem(getString(R.string.ab22), getString(R.string.beats), getString(R.string.beats_di), getString(R.string.day_tu));
        barock = new BarItem(getString(R.string.ab19), getString(R.string.barock), getString(R.string.barock_di_mi), getString(R.string.day_tu));
        escobar = new BarItem(getString(R.string.ab21), getString(R.string.escobar), getString(R.string.escobar_di_mi_do), getString(R.string.day_tu));

        bars.add(banane);
        bars.add(barock);
        bars.add(heimat);
        bars.add(hem);
        bars.add(pirat);
        bars.add(altefilm);
        bars.add(bar13);
        bars.add(jagd);
        bars.add(mood);
        bars.add(no7);
        bars.add(picasso);
        bars.add(max);
        bars.add(escobar);
        bars.add(dasilva);
        bars.add(ubar);
        bars.add(beats);
        bars.add(rauschgold);
        bars.add(suite);
        bars.add(ernstl);
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
