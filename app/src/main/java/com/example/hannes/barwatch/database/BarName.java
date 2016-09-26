package com.example.hannes.barwatch.database;


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
        name.add("Flannigan´s");
        name.add("Francky´s Sports Bar");
        name.add("Gatsby");
        name.add("Heimat");
        name.add("Hemingway´s");
        name.add("Hexenhäuschen");
        name.add("Jag deiner Eltern nicht vom Hof");
        name.add("Jalapenos");
        name.add("Ka5per");
        name.add("Margaritas");
        name.add("Max´s Bar");
        name.add("Mood");
        name.add("No. Seven");
        name.add("Orange Bar");
        name.add("Picasso");
        name.add("Piratenhöhle");
        name.add("Pony");
        name.add("Rauschgold");
        name.add("Sax");
        name.add("Skala");
        name.add("Suite 15");
        name.add("U-Bar");
        name.add("Upper");
        name.add("Zarap Zap Zap");

        name.indexOf("Margaritas");
    }

    public ArrayList<String> getName() {
        return name;
    }
}
