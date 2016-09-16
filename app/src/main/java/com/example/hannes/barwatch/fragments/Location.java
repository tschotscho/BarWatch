package com.example.hannes.barwatch.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

/**
 * Created by Christopher on 18.08.2016.
 */
public class Location extends Fragment implements OnMapReadyCallback {

    SupportMapFragment sMapFragment;

    private BarLocation barsLocation;
    private BarName barName;
    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location, container, false);
        setUpMap();
        return v;
    }

    public void setUpMap() {
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
        // Move camera to Regensburg Neufahrplatz
        LatLng regensburg = new LatLng(49.01849959358728, 12.0958256717131);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(regensburg));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));

        uiSettings();
        setUpBar();
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

    private void setUpBar() {

        barsLocation = new BarLocation();
        ArrayList<LatLng> location = barsLocation.getLocation();

        barName = new BarName();
        ArrayList<String> name = barName.getName();

        for (int i = 0; i < location.size(); i++) {
            mMap.addMarker(new MarkerOptions().position(location.get(i)).title(name.get(i)));
        }
    }
}
