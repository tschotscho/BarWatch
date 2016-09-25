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
import com.example.hannes.barwatch.adapter.BarAdapter;
import com.example.hannes.barwatch.item.BarItem;

import java.util.ArrayList;

/**
 * Created by Christopher on 11.08.2016.
 */
public class Thursday extends Fragment {

    private ListView list;

    private ArrayList<BarItem> bars = new ArrayList<BarItem>();
    private BarAdapter bar_adapter;

    private BarItem hem;
    private BarItem mood;
    private BarItem ubar;
    private BarItem jagd;
    private BarItem banane;
    private BarItem heimat;
    private BarItem pirat;
    private BarItem dasilva;
    private BarItem rauschgold;
    private BarItem suite;
    private BarItem no7;
    private BarItem picasso;
    private BarItem bar13;
    private BarItem max;
    private BarItem escobar;
    private BarItem pony;
    private BarItem sax;
    private BarItem gatsby;
    private BarItem jalapenos;
    private BarItem flan;
    private BarItem upper;
    private BarItem zap;
    private BarItem margaritas;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.offer_layout, container, false);
        list = (ListView) v.findViewById(R.id.daily_list);
        TextView week = (TextView) v.findViewById(R.id.weekday);
        week.setText("Donnerstag");

        initUI();
        initTuesday();

        return v;
    }

    private void initTuesday() {

        hem = new BarItem(getString(R.string.ab21), getString(R.string.hemmingways), getString(R.string.hem_do), getString(R.string.day_th));
        mood = new BarItem(getString(R.string.ab20), getString(R.string.mood), getString(R.string.mood_do), getString(R.string.day_th));
        pony = new BarItem(getString(R.string.ab21), getString(R.string.pony), getString(R.string.pony_do), getString(R.string.day_th));
        banane = new BarItem(getString(R.string.ab19), getString(R.string.banane), getString(R.string.banane_do), getString(R.string.day_th));
        heimat = new BarItem(getString(R.string.ab19), getString(R.string.heimat), getString(R.string.heimat_do), getString(R.string.day_th));
        sax = new BarItem(getString(R.string.ab19), getString(R.string.sax), getString(R.string.sax_do), getString(R.string.day_th));
        pirat = new BarItem(getString(R.string.ab19), getString(R.string.piratenhöhle), getString(R.string.piraten_do), getString(R.string.day_th));
        dasilva = new BarItem(getString(R.string.ab21), getString(R.string.dasilva), getString(R.string.dasilva_do), getString(R.string.day_th));
        rauschgold = new BarItem(getString(R.string.ab22), getString(R.string.rauschgold), getString(R.string.rausch_do_fr_sa), getString(R.string.day_th));
        suite = new BarItem(getString(R.string.ab22), getString(R.string.suite), getString(R.string.suite_do), getString(R.string.day_th));
        gatsby = new BarItem(getString(R.string.ab22), getString(R.string.gatsby), getString(R.string.gatsby_do), getString(R.string.day_th));
        jalapenos = new BarItem(getString(R.string.ab22), getString(R.string.jalapenos), getString(R.string.jala_do), getString(R.string.day_th));
        no7 = new BarItem(getString(R.string.ab20), getString(R.string.no7), getString(R.string.no7_do), getString(R.string.day_th));
        picasso = new BarItem(getString(R.string.ab20), getString(R.string.picasso), getString(R.string.picasso_do), getString(R.string.day_th));
        flan = new BarItem(getString(R.string.ab20), getString(R.string.flannigans), getString(R.string.flan_do_fr_sa), getString(R.string.day_th));
        bar13 = new BarItem(getString(R.string.ab20), getString(R.string.bar13), getString(R.string.bar_do), getString(R.string.day_th));
        upper = new BarItem(getString(R.string.ab22), getString(R.string.upper), getString(R.string.upper_do), getString(R.string.day_th));
        zap = new BarItem(getString(R.string.ab22), getString(R.string.zap), getString(R.string.zap_do), getString(R.string.day_th));
        max = new BarItem(getString(R.string.ab20), getString(R.string.max), getString(R.string.max_do_fr_sa), getString(R.string.day_th));
        ubar = new BarItem(getString(R.string.ab21), getString(R.string.ubar), getString(R.string.ubar_do), getString(R.string.day_th));
        jagd = new BarItem(getString(R.string.ab20), getString(R.string.jagd), getString(R.string.jag_di_do), getString(R.string.day_th));
        margaritas = new BarItem(getString(R.string.ab17), getString(R.string.margaritas), getString(R.string.magaritas_do), getString(R.string.day_th));
        escobar = new BarItem(getString(R.string.ab21), getString(R.string.escobar), getString(R.string.escobar_di_mi_do), getString(R.string.day_th));

        bars.add(margaritas);
        bars.add(banane);
        bars.add(heimat);
        bars.add(sax);
        bars.add(pirat);
        bars.add(bar13);
        bars.add(flan);
        bars.add(jagd);
        bars.add(max);
        bars.add(mood);
        bars.add(no7);
        bars.add(picasso);
        bars.add(dasilva);
        bars.add(escobar);
        bars.add(hem);
        bars.add(pony);
        bars.add(ubar);
        bars.add(gatsby);
        bars.add(jalapenos);
        bars.add(rauschgold);
        bars.add(suite);
        bars.add(upper);
        bars.add(zap);

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