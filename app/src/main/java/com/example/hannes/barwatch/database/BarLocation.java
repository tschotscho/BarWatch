package com.example.hannes.barwatch.database;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Chrissi on 16.09.2016.
 */
public class BarLocation extends ArrayList {

    private ArrayList<LatLng> location;


    public BarLocation() {
        initLocation();
    }

    private void initLocation() {
        location = new ArrayList<>();

        LatLng alteFilm = new LatLng(49.020863, 12.097123);
        LatLng banane = new LatLng(49.020557, 12.091984);
        LatLng bar = new LatLng(49.021306, 12.092682);
        LatLng barock = new LatLng(49.019971, 12.096997);
        LatLng beats = new LatLng(49.015865, 12.096831);
        LatLng daSilva = new LatLng(49.016645, 12.096161);
        LatLng ernstl = new LatLng(49.014163, 12.101131);
        LatLng esco = new LatLng(49.017396, 12.093824);
        LatLng felix = new LatLng(49.016267, 12.098014);
        LatLng flan = new LatLng(49.021157, 12.093784);
        LatLng francky = new LatLng(49.020228, 12.098124);
        LatLng gatsby = new LatLng(49.015906, 12.096622);
        LatLng heimat = new LatLng(49.020012, 12.091907);
        LatLng hemingways = new LatLng(49.018027, 12.094937);
        LatLng hexen = new LatLng(49.009761, 12.102276);
        LatLng jagdhof = new LatLng(49.020907, 12.096582);
        LatLng jala = new LatLng(49.017417, 12.089055);
        LatLng kasper = new LatLng(49.019007, 12.094186);
        LatLng magaritas = new LatLng(49.010130, 12.102697);
        LatLng max = new LatLng(49.015070, 12.100007);
        LatLng mood = new LatLng(49.021140908053184, 12.096453308950004);
        LatLng noSeven = new LatLng(49.019260, 12.091813);
        LatLng orange = new LatLng(49.021158, 12.093591);
        LatLng picasso = new LatLng(49.020377, 12.097649);
        LatLng pirat = new LatLng(49.020701, 12.095359);
        LatLng pony = new LatLng(49.017901, 12.094763);
        LatLng rausch = new LatLng(49.016291, 12.096930);
        LatLng sax = new LatLng(49.017869, 12.093132);
        LatLng skala = new LatLng(49.018895, 12.092689);
        LatLng suite = new LatLng(49.015443, 12.096517);
        LatLng ubar = new LatLng(49.017817, 12.094384);
        LatLng upper = new LatLng(49.018861, 12.098035);
        LatLng zap = new LatLng(49.017524, 12.095219);

        location.add(alteFilm);
        location.add(banane);
        location.add(bar);
        location.add(barock);
        location.add(beats);
        location.add(daSilva);
        location.add(ernstl);
        location.add(esco);
        location.add(felix);
        location.add(flan);
        location.add(francky);
        location.add(gatsby);
        location.add(heimat);
        location.add(hemingways);
        location.add(hexen);
        location.add(jagdhof);
        location.add(jala);
        location.add(kasper);
        location.add(magaritas);
        location.add(max);
        location.add(mood);
        location.add(noSeven);
        location.add(orange);
        location.add(picasso);
        location.add(pirat);
        location.add(pony);
        location.add(rausch);
        location.add(sax);
        location.add(skala);
        location.add(suite);
        location.add(ubar);
        location.add(upper);
        location.add(zap);
    }

    public ArrayList<LatLng> getLocation() {
        return location;
    }
}
