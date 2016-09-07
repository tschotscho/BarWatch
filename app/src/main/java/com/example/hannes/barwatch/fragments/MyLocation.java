package com.example.hannes.barwatch.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.location.LocationManager;

import com.example.hannes.barwatch.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Christopher on 18.08.2016.
 */
public class MyLocation extends Fragment implements OnMapReadyCallback {

    /** String [] SPINNERLIST = {"Mood","KA5PER","Hemingway's","U-Bar","Pony","Jag deine Eltern nicht vom Hof","Alte Filmbühne",
     "Banane", "Heimat", "Barock Bar", "Franky's Sportsbar","Sax", "Piratenhöhle" , "Orange Club" , "Da Silva", "Rauschgold",
     "Ernstl","Suite 15","Beats", "Gatsby","Jalapenos","No. 7","Picasso","Falnnigans", "Bar 13","Upper Club 21", "Escobar",
     "Zarap Zap Zap", "Magaritas","Max Bar", "Café Felix","Hexenhäuschen", "Skala"};**/

    SupportMapFragment sMapFragment;
    private GoogleMap mMap;
    private double latitude;
    private double longitude;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location, container, false);
        setUpMap();
        return v;
    }

    public void setUpMap() {
        sMapFragment = SupportMapFragment.newInstance();
        sMapFragment.getMapAsync(this);
        android.support.v4.app.FragmentManager sFm = getFragmentManager();
        sFm.beginTransaction().add(R.id.map, sMapFragment).commit();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Move camera to Regensburg City
        LatLng regensburg = new LatLng(49.01849959358728, 12.0958256717131);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(regensburg));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));

        uiSettings();
        currentPosition();
        setUpBar();
    }

    public void onDestroyView(){
        super.onDestroyView();
        Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }

    private void uiSettings() {
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        if ((ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            mMap.setMyLocationEnabled(true);
        }
    }

    public void currentPosition() {
        android.location.Location location = new android.location.Location(LocationManager.GPS_PROVIDER);
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        LatLng current = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(current).title("Your Position"));
    }

    private void setUpBar() {

        LatLng mood = new LatLng(49.021140908053184, 12.096453308950004);
        LatLng kasper = new LatLng(49.019007, 12.094186);
        LatLng hemingways = new LatLng(49.018027, 12.094937);
        LatLng ubar = new LatLng(49.017817, 12.094384);
        LatLng pony = new LatLng(49.017901, 12.094763);
        LatLng jagdhof = new LatLng(49.020907, 12.096582);
        LatLng alteFilm = new LatLng(49.020863, 12.097123);
        LatLng banane = new LatLng(49.020557, 12.091984);
        LatLng heimat = new LatLng(49.020012, 12.091907);
        LatLng barock = new LatLng(49.019971, 12.096997);
        LatLng francky = new LatLng(49.020228, 12.098124);
        LatLng sax = new LatLng(49.017869, 12.093132);
        LatLng pirat = new LatLng(49.020701, 12.095359);
        LatLng orange = new LatLng(49.021158, 12.093591);
        LatLng daSilva = new LatLng(49.016645, 12.096161);
        LatLng rausch = new LatLng(49.016291, 12.096930);
        LatLng ernstl = new LatLng(49.014163, 12.101131);
        LatLng suite = new LatLng(49.015443, 12.096517);
        LatLng beats = new LatLng(49.015865, 12.096831);
        LatLng gatsby = new LatLng(49.015906, 12.096622);
        LatLng jala = new LatLng(49.017417, 12.089055);
        LatLng noSeven = new LatLng(49.019260, 12.091813);
        LatLng picasso = new LatLng(49.020377, 12.097649);
        LatLng flan = new LatLng(49.021157, 12.093784);
        LatLng bar = new LatLng(49.021306, 12.092682);
        LatLng upper = new LatLng(49.018861, 12.098035);
        LatLng esco = new LatLng(49.017396, 12.093824);
        LatLng zap = new LatLng(49.017524, 12.095219);
        LatLng magaritas = new LatLng(49.010130, 12.102697);
        LatLng max = new LatLng(49.015070, 12.100007);
        LatLng felix = new LatLng(49.016267, 12.098014);
        LatLng hexen = new LatLng(49.009761, 12.102276);
        LatLng skala = new LatLng(49.018895, 12.092689);

        mMap.addMarker(new MarkerOptions().position(mood).title("Mood"));
        mMap.addMarker(new MarkerOptions().position(kasper).title("KA5PER Cocktailbar"));
        mMap.addMarker(new MarkerOptions().position(hemingways).title("Hemingway's"));
        mMap.addMarker(new MarkerOptions().position(ubar).title("U-Bar"));
        mMap.addMarker(new MarkerOptions().position(pony).title("Pony"));
        mMap.addMarker(new MarkerOptions().position(jagdhof).title("Jag deine Eltern nicht vom Hof"));
        mMap.addMarker(new MarkerOptions().position(alteFilm).title("Alte Filmbühne"));
        mMap.addMarker(new MarkerOptions().position(banane).title("Banane"));
        mMap.addMarker(new MarkerOptions().position(heimat).title("Regensburg Heimat"));
        mMap.addMarker(new MarkerOptions().position(barock).title("Barock Bar"));
        mMap.addMarker(new MarkerOptions().position(francky).title("Franky's Sportsbar"));
        mMap.addMarker(new MarkerOptions().position(sax).title("Musikbar Sax"));
        mMap.addMarker(new MarkerOptions().position(pirat).title("Piratenhöhle"));
        mMap.addMarker(new MarkerOptions().position(orange).title("Orange Bar"));
        mMap.addMarker(new MarkerOptions().position(daSilva).title("da Silva - Bar & Lounge"));
        mMap.addMarker(new MarkerOptions().position(rausch).title("Rauschgold"));
        mMap.addMarker(new MarkerOptions().position(ernstl).title("Ernstl"));
        mMap.addMarker(new MarkerOptions().position(suite).title("Suite 15"));
        mMap.addMarker(new MarkerOptions().position(beats).title("Beats"));
        mMap.addMarker(new MarkerOptions().position(gatsby).title("Gatsby"));
        mMap.addMarker(new MarkerOptions().position(jala).title("Jalapenos"));
        mMap.addMarker(new MarkerOptions().position(noSeven).title("No. 7"));
        mMap.addMarker(new MarkerOptions().position(picasso).title("Café Picasso"));
        mMap.addMarker(new MarkerOptions().position(flan).title("Flannigan's Cocktailbar"));
        mMap.addMarker(new MarkerOptions().position(bar).title("Bar 13"));
        mMap.addMarker(new MarkerOptions().position(upper).title("Upper Club 21"));
        mMap.addMarker(new MarkerOptions().position(esco).title("Escobar"));
        mMap.addMarker(new MarkerOptions().position(zap).title("Zarap Zap Zap"));
        mMap.addMarker(new MarkerOptions().position(magaritas).title("Magaritas"));
        mMap.addMarker(new MarkerOptions().position(max).title("Max's Bar"));
        mMap.addMarker(new MarkerOptions().position(felix).title("Café Felix"));
        mMap.addMarker(new MarkerOptions().position(hexen).title("Hexenhäusel"));
        mMap.addMarker(new MarkerOptions().position(skala).title("Skala"));

    }
}
