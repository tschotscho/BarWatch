package com.example.hannes.barwatch.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hannes.barwatch.R;
import com.example.hannes.barwatch.database.BarAdress;
import com.example.hannes.barwatch.database.BarLocation;
import com.example.hannes.barwatch.database.BarName;
import com.example.hannes.barwatch.database.BarOpens;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by Christopher on 26.09.2016.
 */
public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private BarLocation barLocation;
    private BarName barName;
    private BarAdress barAdress;
    private BarOpens barOpens;
    private String name;
    private int position;

    private GoogleMap mMap;
    private SupportMapFragment sMapFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle extras = getIntent().getExtras();
        name = extras.getString("Barname");

        setupMap();
        getPosition(name);
        initBarName();
        initBarOpens();
        initBarAdress();
    }

    private void initBarName() {
        TextView titelBar = (TextView) findViewById(R.id.detail_bar_name);
        titelBar.setText(name);
    }

    private void initBarOpens() {
        barOpens = new BarOpens();
        ArrayList<String> opens = barOpens.getOpens();
        TextView infoOne = (TextView) findViewById(R.id.open);
        infoOne.setText(opens.get(position));
    }

    private void initBarAdress() {
        barAdress = new BarAdress();
        ArrayList<String> adress = barAdress.getAdress();
        TextView infoTwo = (TextView) findViewById(R.id.adress);
        infoTwo.setText(adress.get(position));
    }

    private int getPosition(String bar) {
        barName = new BarName();
        ArrayList<String> kneipe = barName.getName();
        position = kneipe.indexOf(bar);
        return position;
    }

    public void setupMap() {
        android.support.v4.app.FragmentManager sFm = getSupportFragmentManager();
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
    }

    private void setupCamera() {
        barLocation = new BarLocation();
        ArrayList<LatLng> loc = barLocation.getLocation();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(loc.get(position)));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));

        mMap.addMarker(new MarkerOptions().position(loc.get(position)));
        if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
        }
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
    }

}

