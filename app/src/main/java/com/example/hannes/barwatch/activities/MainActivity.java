package com.example.hannes.barwatch.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import com.example.hannes.barwatch.database.BarDatabase;
import com.example.hannes.barwatch.fragments.Favourite;
import com.example.hannes.barwatch.fragments.Location;
import com.example.hannes.barwatch.fragments.RandomBar;
import com.example.hannes.barwatch.item.NavItem;
import com.example.hannes.barwatch.R;
import com.example.hannes.barwatch.adapter.NavListAdapter;
import com.example.hannes.barwatch.fragments.Home;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private RelativeLayout drawerPane;
    private ListView lvNav;
    private List<NavItem> listNavItems;
    private List<Fragment> listFragments;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    BarDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = new BarDatabase(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerPane = (RelativeLayout) findViewById(R.id.drawer_pane);
        lvNav = (ListView) findViewById(R.id.nav_list);

        initListNavItems();
        initNavAdapter();
        initListFragments();
        initDefaultFragment();
        initNavListener();
        initDrawerListener();
    }

    private void initNavAdapter() {
        NavListAdapter navListAdapter = new NavListAdapter(getApplicationContext(),
                R.layout.item_nav_list, listNavItems);
        lvNav.setAdapter(navListAdapter);
    }

    private void initListNavItems() {
        listNavItems = new ArrayList<NavItem>();
        listNavItems.add(new NavItem("Die besten Angebote", "Happy Hour", R.drawable.beer_icon));
        listNavItems.add(new NavItem("Nutze die Karte", "Location", R.drawable.ic_location));
        listNavItems.add(new NavItem("Lass das Zufall entscheiden", "Random Button", R.drawable.ic_stern));
        listNavItems.add(new NavItem("Deine Best of", "Favoriten", R.drawable.ic_stern));
    }

    private void initListFragments() {
        listFragments = new ArrayList<Fragment>();
        listFragments.add(new Home());
        listFragments.add(new Location());
        listFragments.add(new RandomBar());
        listFragments.add(new Favourite());
    }

    private void initDefaultFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, listFragments.get(0)).commit();
        setTitle(listNavItems.get(0).getTitle());
        lvNav.setItemChecked(0, true);
        drawerLayout.closeDrawer(drawerPane);
    }

    private void initNavListener() {
        lvNav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_content, listFragments.get(position)).commit();

                setTitle(listNavItems.get(position).getTitle());
                lvNav.setItemChecked(position, true);
                drawerLayout.closeDrawer(drawerPane);
            }
        });
    }

    private void initDrawerListener() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.drawer_closed, R.string.drawer_closed) {
            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onDestroy(){
        db.close();
        super.onDestroy();
    }
}
