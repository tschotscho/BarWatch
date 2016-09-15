package com.example.hannes.barwatch.weekfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hannes.barwatch.R;

/**
 * Created by Christopher on 11.08.2016.
 */
public class Friday extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.daily_layout, container, false);

        TextView week = (TextView) v.findViewById(R.id.weekday);
        week.setText("Freitag");

        return v;
    }
}
