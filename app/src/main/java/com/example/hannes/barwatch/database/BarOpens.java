package com.example.hannes.barwatch.database;

import java.util.ArrayList;

/**
 * Created by Christopher on 26.09.2016.
 */
public class BarOpens {

    private ArrayList<String> name;


    public BarOpens() {
        initOpens();
    }

    private void initOpens() {
        name = new ArrayList<>();

        name.add("Täglich:\n" +
                "20:00 - 02:00 Uhr");
        name.add("Dienstag bis Samstag:\n" +
                "19:00 - 02:00 Uhr");
        name.add("Montag:\n" +
                "20:00 - 03:00 Uhr\n" +
                "Dienstag bis Donnerstag:\n" +
                "20:00 - 02:00 Uhr\n" +
                "Freitag und Samstag:\n" +
                "20:00 - 04:00 Uhr");
        name.add("Dienstag bis Samstag:\n" +
                "19:00 - 02:00 Uhr");
        name.add("Dienstag und Donnerstag:\n" +
                "23:00 - 03:00 Uhr\n" +
                "Freitag und Samstag:\n" +
                "23:00 - 04:00 Uhr");
        name.add("Dienstag bis Samstag:\n" +
                "21:00 - 02:00 Uhr");
        name.add("Dienstag bis Samstag:\n" +
                "00:00 - 05:00 Uhr");
        name.add("Dienstag bis Samstag:\n" +
                "21:00 - 02:00 Uhr");
        name.add("Felix");
        name.add("Montag bis Donnnerstag:\n" +
                "20:00 - 02:00 Uhr\n" +
                "Freitag bis Samstag:\n" +
                "19:00 - 02:00 Uhr");
        name.add("Dienstag bis Samstag:\n" +
                "19:00 - 02:00 Uhr");
        name.add("Donnerstag:\n" +
                "23:00 -03:00 Uhr\n" +
                "Freitag und Samstag:\n" +
                "23:00 -04:00 Uhr");
        name.add("Montag:\n" +
                "19:00 - 02:00 Uhr\n" +
                "Dienstag bis Samstag:\n" +
                "20:00 - 02:00 Uhr");
        name.add("Sonntag bis Donnerstag:\n" +
                "09:00 - 01:00 Uhr\n" +
                "Freitga und Samstag:\n" +
                "09:00 - 02:00 Uhr");
        name.add("Hexenhäuschen");
        name.add("Dienstag bis Samstag:\n" +
                "20:00 - 02:00 Uhr");
        name.add("Sonntag bis Mittwoch:\n" +
                "17:00 - 01:00 Uhr\n" +
                "Donnerstag bis Samstag:\n" +
                "17:00 - 02:00 Uhr");
        name.add("Montag bis Freitag:\n" +
                "20:00 - 02:00 Uhr\n" +
                "Samstag:\n" +
                "12:00 - 02:00 Uhr\n" +
                "Sonntag:\n" +
                "17:00 - 00:00 Uhr");
        name.add("Sonntag bis Donnerstag:\n" +
                "11:00 - 01:00 Uhr\n" +
                "Freitag bis Samstag:\n" +
                "11:00 - 02:00 Uhr");
        name.add("Montag bis Samstag:\n" +
                "20:00 - 04:00 Uhr");
        name.add("Montag:\n" +
                "20:00 - 01:00 Uhr" +
                "Dienstag bis Samstag:\n" +
                "20:00 - 02:00 Uhr");
        name.add("Mittwoch, Freitag und Samstag:\n" +
                "21:00 - 02:00 Uhr");
        name.add("Montag bis Donnerstag:\n" +
                "20:00 - 01:00 Uhr\n" +
                "Freitag und Samstag:\n" +
                "20:00 - 02:00 Uhr");
        name.add("Täglich:\n" +
                "10:00 - 02:00 Uhr");
        name.add("Montag bis Samstag:\n" +
                "19:00 - 02:00 Uhr");
        name.add("Dienstag bis Samstag:\n" +
                "21:00 - 02:00 Uhr");
        name.add("Donnerstag bis Samstag:\n" +
                "22:00 - 03:00 Uhr");
        name.add("Täglich:\n" +
                "19:00 - 02:00 Uhr");
        name.add("Skala");
        name.add("Dienstag und Donnerstag:\n" +
                "23:00 - 03:00 Uhr\n" +
                "Freitag und Samstag:\n" +
                "23:00 - 04:00 Uhr");
        name.add("Dienstag bis Samstag:\n" +
                "21:00 - 02:00 Uhr");
        name.add("Donnerstag bis Samstag:\n" +
                "21:00 - 02:00 Uhr");
        name.add("Mittwoch und Donnerstag:\n" +
                "22:00 - 03:00 Uhr\n" +
                "Freitag und Samstag:\n" +
                "22:00 - 04:00 Uhr");
    }

    public ArrayList<String> getOpens() {
        return name;
    }

}
