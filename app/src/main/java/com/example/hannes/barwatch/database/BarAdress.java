package com.example.hannes.barwatch.database;

import java.util.ArrayList;

/**
 * Created by Christopher on 26.09.2016.
 */
public class BarAdress {


    private ArrayList<String> name;


    public BarAdress() {
        initAdress();
    }

    private void initAdress() {
        name = new ArrayList<>();

        name.add("Taubengäßchen 2\n93047 Regensburg");
        name.add("Am Römling 1\n93047 Regensburg");
        name.add("Keplerstraße 13\n93047 Regensburg");
        name.add("Krauterermarkt 2\n93047 Regensburg");
        name.add("St.-Peters-Weg 15\n93047 Regensburg");
        name.add("Obermünsterstraße 9\n93047 Regensburg");
        name.add("Ernst-Reuter-Platz 2\n93047 Regensburg");
        name.add("Blaue-Stern-Gasse 7a\n93047 Regensburg");
        name.add("Felix");
        name.add("Baumhackergasse 2\n93047 Regensburg");
        name.add("Unter den Schwibbögen 3\n93047 Regensburg");
        name.add("St.-Peters-Weg 15\n93047 Regensburg");
        name.add("Am Römling 9, 93047\nRegensburg");
        name.add("Obere Bachgasse 3-5\n93047 Regensburg");
        name.add("Hexenhäuschen");
        name.add("Goldene-Bären-Straße 10\n93047 Regensburg");
        name.add("Schottenstraße 4\n93047 Regensburg");
        name.add("Hinter der Grieb 5\n93047 Regensburg");
        name.add("Furtmayrstraße 3\n93053 Regensburg");
        name.add("Maximilianstraße 28\n93047 Regensburg");
        name.add("Am Wiedfang 2\n93047 Regensburg");
        name.add("Glockengasse 3\n93047 Regensburg");
        name.add("Keplerstraße 3\n93047 Regensburg");
        name.add("Unter den Schwibbögen 1\n93047 Regensburg");
        name.add("Fischgässel 4\n93047 Regensburg");
        name.add("Obere Bachgasse 8\n93047 Regensburg");
        name.add("Obermünsterstraße 14\n93047 Regensburg");
        name.add("Hinter der Pfannenschmiede 1\n93047 Regensburg");
        name.add("Skala");
        name.add("St.-Peters-Weg 15\n93047 Regensburg");
        name.add("Spiegelgasse 3\n93047 Regensburg");
        name.add("Domplatz 3\n93047 Regensburg");
        name.add("Furtmayrstraße 3\n93053 Regensburg");
    }

    public ArrayList<String> getAdress() {
        return name;
    }

}
