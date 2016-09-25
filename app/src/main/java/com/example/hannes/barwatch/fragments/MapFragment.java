package com.example.hannes.barwatch.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.hannes.barwatch.R;
import com.example.hannes.barwatch.database.BarLocation;
import com.example.hannes.barwatch.database.BarName;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by Christopher on 18.08.2016.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    SupportMapFragment sMapFragment;
    private ArrayAdapter<String> bar_spinner;
    private BarLocation barLocation;
    private BarName barName;
    private GoogleMap mMap;
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.map_layout, container, false);

        spinner = (Spinner) v.findViewById(R.id.spinner);
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
        setupBar();
        initSpinner();
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

    private void setupBar() {
        for (int i = 0; i < location().size(); i++) {
            mMap.addMarker(new MarkerOptions().position(location().get(i)).title(name().get(i)));
        }
    }

    public void initSpinner() {
        bar_spinner = new ArrayAdapter<>(this.getActivity(),
                android.R.layout.simple_dropdown_item_1line, name());
        spinner.setAdapter(bar_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setupBar();
                int selectedBar = position;
                mMap.addMarker(new MarkerOptions().position(location().get(selectedBar)).title(name()
                        .get(selectedBar)).icon(BitmapDescriptorFactory.
                        defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(location().get(selectedBar)));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(16));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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
        ArrayList<LatLng> loc = barLocation.getLocation();
        return loc;
    }
}
