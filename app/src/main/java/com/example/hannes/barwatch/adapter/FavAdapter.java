package com.example.hannes.barwatch.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hannes.barwatch.R;
import com.example.hannes.barwatch.activities.DetailActivity;
import com.example.hannes.barwatch.database.BarDatabase;
import com.example.hannes.barwatch.fragments.Favorite;
import com.example.hannes.barwatch.item.BarItem;

import java.util.ArrayList;

/**
 * Created by Robin on 23.09.16.
 */
public class FavAdapter extends ArrayAdapter<BarItem> {
    private ArrayList<BarItem> favList;
    private Context context;
    private BarDatabase db;

    public FavAdapter(Context context, ArrayList<BarItem> listItems) {
        super(context, R.layout.item_fav_list, listItems);

        this.context = context;
        this.favList = listItems;


        db = new BarDatabase(context);
        db.open();

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_fav_list, null);

        }

        final BarItem bar = favList.get(position);


        if (bar != null) {
            TextView barTime = (TextView) v.findViewById(R.id.fav_time);
            barTime.setText(bar.getTime());

            TextView barName = (TextView) v.findViewById(R.id.fav_name);
            barName.setText(bar.getName());

            TextView angebot = (TextView) v.findViewById(R.id.fav_angebot);
            angebot.setText(bar.getAngebote());

            TextView tag = (TextView) v.findViewById(R.id.fav_day);
            tag.setText(bar.getDay());

            ImageView detail = (ImageView) v.findViewById(R.id.detail_view);

            detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int duration = Toast.LENGTH_SHORT;
                    CharSequence text = bar.getName() + " Detailansicht";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    Intent intent = new Intent(getContext(), DetailActivity.class);
                    intent.putExtra("Barname", bar.getName());
                    context.startActivity(intent);
                }
            });

        }


        return v;
    }
}

