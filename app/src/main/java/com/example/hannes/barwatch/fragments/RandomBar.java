package com.example.hannes.barwatch.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hannes.barwatch.R;
import com.example.hannes.barwatch.database.BarLocation;
import com.example.hannes.barwatch.database.BarName;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Christopher on 18.08.2016.
 */
public class RandomBar extends Fragment implements OnMapReadyCallback {

    SupportMapFragment sMapFragment;

    private BarLocation barLocation;
    private BarName barName;
    private GoogleMap mMap;
    private Button randomButton;
    private TextView randomBar;
    private Random random;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_random, container, false);

        randomBar = (TextView) v.findViewById(R.id.random_bar);
        randomButton = (Button) v.findViewById(R.id.random_button);

        setupMap();
        return v;
    }

    public void setupMap() {
        android.support.v4.app.FragmentManager sFm = getFragmentManager();
        sMapFragment = SupportMapFragment.newInstance();
        sMapFragment.getMapAsync(this);
        if (sMapFragment == null) {
            sFm.beginTransaction().replace(R.id.map, sMapFragment).commit();
        } else {
            sFm.beginTransaction().add(R.id.map, sMapFragment).commit();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        setupCamera();
        setupUiSettings();
        setupRandomButton();
    }

    private void setupCamera() {
        LatLng regensburg = new LatLng(49.01849959358728, 12.0958256717131);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(regensburg));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));
    }

    private void setupUiSettings() {
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        if ((ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            mMap.setMyLocationEnabled(true);
        }
    }

    private void setupRandomButton() {
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random = new Random();
                int randomBarPos = random.nextInt(32);
                String i = name().get(randomBarPos);
                randomBar.setText(i);

                mMap.addMarker(new MarkerOptions().position(location().get(randomBarPos)).title(name().get(randomBarPos)));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(location().get(randomBarPos)));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(17));
            }
        });
    }

    private ArrayList<String> name() {
        barName = new BarName();
        ArrayList<String> name = barName.getName();
        return name;
    }

    private ArrayList<LatLng> location() {
        barLocation = new BarLocation();
        ArrayList<LatLng> location = barLocation.getLocation();
        return location;
    }
}
