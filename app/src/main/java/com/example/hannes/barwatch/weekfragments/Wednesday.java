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
public class Wednesday extends Fragment {

    private ListView list;

    private ArrayList<BarItem> bars = new ArrayList<BarItem>();
    private BarAdapter bar_adapter;

    private BarItem hem;
    private BarItem ubar;
    private BarItem pirat;
    private BarItem no7;
    private BarItem picasso;
    private BarItem bar13;
    private BarItem max;
    private BarItem barock;
    private BarItem escobar;
    private BarItem pony;
    private BarItem zap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.offer_layout, container, false);
        list = (ListView) v.findViewById(R.id.daily_list);
        TextView week = (TextView) v.findViewById(R.id.weekday);
        week.setText("Mittwoch");

        initUI();
        initWednesday();

        return v;
    }


    private void initWednesday() {

        ubar = new BarItem(getString(R.string.ab21), getString(R.string.ubar), getString(R.string.ubar_mi), getString(R.string.day_we));
        pony = new BarItem(getString(R.string.ab21), getString(R.string.pony), getString(R.string.pony_mi), getString(R.string.day_we));
        hem = new BarItem(getString(R.string.ab19), getString(R.string.hemmingways), getString(R.string.hem_di), getString(R.string.day_we));
        barock = new BarItem(getString(R.string.ab19), getString(R.string.barock), getString(R.string.barock_di_mi), getString(R.string.day_we));
        escobar = new BarItem(getString(R.string.ab21), getString(R.string.escobar), getString(R.string.escobar_di_mi_do), getString(R.string.day_we));
        pirat = new BarItem(getString(R.string.ab19), getString(R.string.piratenhöhle), getString(R.string.piraten_mi), getString(R.string.day_we));
        no7 = new BarItem(getString(R.string.ab20), getString(R.string.no7), getString(R.string.no7_mi), getString(R.string.day_we));
        picasso = new BarItem(getString(R.string.ab20), getString(R.string.picasso), getString(R.string.picasso_mi), getString(R.string.day_we));
        bar13 = new BarItem(getString(R.string.ab20), getString(R.string.bar13), getString(R.string.bar_mi), getString(R.string.day_we));
        zap = new BarItem(getString(R.string.ab22), getString(R.string.zap), getString(R.string.zap_mi), getString(R.string.day_we));
        max = new BarItem(getString(R.string.ab20), getString(R.string.max), getString(R.string.max_mi), getString(R.string.day_we));

        bars.add(barock);
        bars.add(hem);
        bars.add(pirat);
        bars.add(bar13);
        bars.add(no7);
        bars.add(max);
        bars.add(picasso);
        bars.add(escobar);
        bars.add(pony);
        bars.add(ubar);
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
