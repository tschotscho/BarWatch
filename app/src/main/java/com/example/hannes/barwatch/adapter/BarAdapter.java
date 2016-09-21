package com.example.hannes.barwatch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hannes.barwatch.R;
import com.example.hannes.barwatch.database.BarDatabase;
import com.example.hannes.barwatch.item.BarItem;

import java.util.ArrayList;

/**
 * Created by Robin on 01.09.16.
 */
public class  BarAdapter extends ArrayAdapter<BarItem> {
    private ArrayList<BarItem> barList;
    private ArrayList<String> names_fav;
    private Context context;
    private BarDatabase db;

    public BarAdapter(Context context, ArrayList<BarItem> listItems){
        super(context, R.layout.listitem_barlist, listItems);

        this.context = context;
        this.barList = listItems;

        db = new BarDatabase(context);
        db.open();

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){

        View v = convertView;

        if (v == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.listitem_barlist,null);

        }

        final BarItem bar = barList.get(position);

        if (bar != null){
            TextView barTime = (TextView) v.findViewById(R.id.bar_time);
            barTime.setText(bar.getTime());

            TextView barName = (TextView) v.findViewById(R.id.bar_name);
            barName.setText(bar.getName());

            TextView angebot = (TextView) v.findViewById(R.id.angebot_name);
            angebot.setText(bar.getAngebote());


            Button add = (Button) v.findViewById(R.id.fav_add_button);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CharSequence text = bar.getName();

                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();


                    if (names_fav.contains(bar.getName())){

                    }else{
                        names_fav.add(bar.getName());
                        db.insertFavorite(bar);
                    }
                    



                }
            });
        }



        return v;
    }

    public ArrayList<BarItem> getFavorites () {

        return db.getAllToDoItems();
    }

}
