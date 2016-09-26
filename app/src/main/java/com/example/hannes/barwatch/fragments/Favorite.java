package com.example.hannes.barwatch.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hannes.barwatch.R;
import com.example.hannes.barwatch.adapter.FavAdapter;
import com.example.hannes.barwatch.database.BarDatabase;
import com.example.hannes.barwatch.item.BarItem;

import java.util.ArrayList;

/**
 * Created by Christopher on 18.08.2016.
 */
public class Favorite extends Fragment {

    private FavAdapter favAdapter;
    private ArrayList<BarItem> testlist = new ArrayList<BarItem>();
    private BarDatabase db;

    public Favorite() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.favorite_layout, container, false);

        initDB();
        initUI(v);
        initFavList();


        return v;
    }

    private void initDB() {
        db = new BarDatabase(this.getContext());
        db.open();
    }

    private void updateList() {
        testlist.clear();
        testlist.addAll(db.getAllToDoItems());
        favAdapter.notifyDataSetChanged();
    }

    private void initUI(View v) {
        initListView(v);
        initFavAdapter(v);
    }

    private void initFavList() {
        updateList();
    }

    private void initListView(View v) {
        ListView list = (ListView) v.findViewById(R.id.fav_list);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {

                if (testlist.get(position) == null) {
                } else {

                    int duration = Toast.LENGTH_SHORT;
                    CharSequence text = testlist.get(position).getName() + " deleted";
                    Toast toast = Toast.makeText(getContext(), text, duration);
                    toast.show();

                    db.removeToDoItem(testlist.get(position));
                    updateList();

                }
                return false;
            }
        });

    }

    private void initFavAdapter(View v) {
        favAdapter = new FavAdapter(this.getContext(), testlist);
        ListView list = (ListView) v.findViewById(R.id.fav_list);
        list.setAdapter(favAdapter);
    }

    @Override
    public void onDestroy() {
        db.close();
        super.onDestroy();
    }

}
