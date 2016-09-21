package com.example.hannes.barwatch.item;

import android.widget.Button;

/**
 * Created by Robin on 28.08.16.
 */
public class BarItem {
    private String time;
    private String name;
    private String angebot;
    //private String adresse;
    //private String oeffnungszeiten;
    //private float lat;
    //private float lng;

    public BarItem(String time, String name, String angebot){

        this.time = time;
        this.name = name;
        this.angebot = angebot;
        //this.adresse = adresse;
        //this.oeffnungszeiten = oeffnungszeiten;
       // this.lat = lat;
       // this.lng = lng;

    }



    public String getTime(){return time;}

    public String getName() {
        return name;
    }

    public String getAngebote() {
        return angebot;
    }

}
