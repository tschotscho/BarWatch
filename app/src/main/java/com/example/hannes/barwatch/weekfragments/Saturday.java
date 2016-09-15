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
import com.example.hannes.barwatch.database.BarDatabase;
import com.example.hannes.barwatch.item.BarItem;

import java.util.ArrayList;

/**
 * Created by Christopher on 11.08.2016.
 */
public class Saturday extends Fragment {

    ListView list;

    private ArrayList<BarItem> bars = new ArrayList<BarItem>();
    private BarAdapter bar_adapter;
    private BarDatabase bar_db;

    private BarItem ubar;
    private BarItem banane;
    private BarItem heimat;
    private BarItem pirat;
    private BarItem rauschgold;
    private BarItem picasso;
    private BarItem bar13;
    private BarItem max;
    private BarItem escobar;
    private BarItem gatsby;
    private BarItem flan;
    private BarItem zap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.daily_layout, container, false);
        list = (ListView) v.findViewById(R.id.daily_list);
        TextView week = (TextView) v.findViewById(R.id.weekday);
        week.setText("Samstag");

        initDB();
        initUI();
        updateList();
        initSaturday();

        return v;
    }

    private void initSaturday() {

        escobar = new BarItem(getString(R.string.ab21), getString(R.string.escobar), getString(R.string.escobar_fr_sa));
        banane = new BarItem(getString(R.string.ab19), getString(R.string.banane), getString(R.string.banane_fr_sa));
        heimat = new BarItem(getString(R.string.ab19), getString(R.string.heimat), getString(R.string.heimat_fr_sa));
        pirat = new BarItem(getString(R.string.ab19), getString(R.string.piratenhöhle), getString(R.string.piraten_fr_sa));
        rauschgold = new BarItem(getString(R.string.ab22), getString(R.string.rauschgold), getString(R.string.rausch_do_fr_sa));
        gatsby = new BarItem(getString(R.string.ab11), getString(R.string.gatsby), getString(R.string.gatsby_fr_sa));
        picasso = new BarItem(getString(R.string.ab20), getString(R.string.picasso), getString(R.string.picasso_sa));
        flan = new BarItem(getString(R.string.ab20), getString(R.string.flannigans), getString(R.string.flan_do_fr_sa));
        bar13 = new BarItem(getString(R.string.ab20), getString(R.string.bar13), getString(R.string.bar_sa));
        zap = new BarItem(getString(R.string.ab22), getString(R.string.zap), getString(R.string.zap_sa));
        max = new BarItem(getString(R.string.ab20), getString(R.string.max), getString(R.string.max_do_fr_sa));
        ubar = new BarItem(getString(R.string.ab21), getString(R.string.ubar), getString(R.string.ubar_fr_sa));

        bars.add(gatsby);
        bars.add(banane);
        bars.add(heimat);
        bars.add(pirat);
        bars.add(bar13);
        bars.add(flan);
        bars.add(max);
        bars.add(picasso);
        bars.add(escobar);
        bars.add(ubar);
        bars.add(rauschgold);
        bars.add(zap);
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


