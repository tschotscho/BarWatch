package com.example.hannes.barwatch.database;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Chrissi on 16.09.2016.
 */
public class BarName {

    private ArrayList<String> name;


    public BarName() {
        initName();
    }

    private void initName() {
        name = new ArrayList<>();

        name.add("Alte Filmbühne");
        name.add("Banane");
        name.add("Bar 13");
        name.add("Barock");
        name.add("Beats");
        name.add("Da Silva");
        name.add("Ernstl");
        name.add("Escobar");
        name.add("Felix");
        name.add("Flanigangs");
        name.add("Franckys Sports Bar");
        name.add("Gatsby");
        name.add("Heimat");
        name.add("Hemingways");
        name.add("Hexenhäuschen");
        name.add("Jag deiner Eltern vom Hof");
        name.add("Jalapenos");
        name.add("Ka5per");
        name.add("Margaritas");
        name.add("Maxbar");
        name.add("Mood");
        name.add("No. Seven");
        name.add("Orange Bar");
        name.add("Picasso");
        name.add("Piratenhöhle");
        name.add("Pony");
        name.add("Rauschgold");
        name.add("Sax");
        name.add("Skala");
        name.add("Suite");
        name.add("ubar");
        name.add("Upper");
        name.add("Zarap Zap Zap");
    }

    public ArrayList<String> getName() {
        return name;
    }
}
