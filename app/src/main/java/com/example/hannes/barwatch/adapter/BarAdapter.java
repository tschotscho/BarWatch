package com.example.hannes.barwatch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hannes.barwatch.R;
import com.example.hannes.barwatch.database.BarDatabase;
import com.example.hannes.barwatch.item.BarItem;

import java.util.ArrayList;

/**
 * Created by Robin on 01.09.16.
 */
public class BarAdapter extends ArrayAdapter<BarItem> {
    private ArrayList<BarItem> barList;
    private ArrayList<String> names_fav = new ArrayList<String>();
    private Context context;
    private BarDatabase db;

    public BarAdapter(Context context, ArrayList<BarItem> listItems) {
        super(context, R.layout.item_bar_list, listItems);

        this.context = context;
        this.barList = listItems;

        db = new BarDatabase(context);
        db.open();

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_bar_list, null);

        }

        final BarItem bar = barList.get(position);


        if (bar != null) {
            TextView barTime = (TextView) v.findViewById(R.id.bar_time);
            barTime.setText(bar.getTime());

            TextView barName = (TextView) v.findViewById(R.id.bar_name);
            barName.setText(bar.getName());

            TextView angebot = (TextView) v.findViewById(R.id.angebot_name);
            angebot.setText(bar.getAngebote());


            ImageView add = (ImageView) v.findViewById(R.id.fav_add_button);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    int duration = Toast.LENGTH_SHORT;
                    /*CharSequence text = bar.getName();
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();*/

                    String teststring = bar.getName() + bar.getDay();


                    if (names_fav.contains(teststring)) {
                        CharSequence t = bar.getName() + " already in Favorites";
                        Toast text1 = Toast.makeText(context, t, duration);
                        text1.show();

                    } else {
                        CharSequence t = bar.getName() + " added to Favorites";
                        Toast text1 = Toast.makeText(context, t, duration);
                        text1.show();
                        names_fav.add(teststring);
                        db.insertFavorite(bar);
                    }


                    //db.insertFavorite(bar);


                }
            });
        }


        return v;
    }

    /*public ArrayList<BarItem> getFavorites () {

        return db.getAllToDoItems();
    }*/

}
