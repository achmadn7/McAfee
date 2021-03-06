package com.example.omdutz.mcafee;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Draw extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.draw, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (id == R.id.reward) {
            getSupportActionBar().setTitle("Point Reward");
            fragmentTransaction.replace(R.id.ini_Fragment,new PointReward()).addToBackStack(null);
        } else if (id == R.id.scan) {
            getSupportActionBar().setTitle("Scan Code");
            fragmentTransaction.replace(R.id.ini_Fragment, new ScanCode()).addToBackStack(null);
        } else if (id == R.id.produk) {
            getSupportActionBar().setTitle("Produk");
            fragmentTransaction.replace(R.id.ini_Fragment, new  Produk()).addToBackStack(null);
        } else if (id == R.id.lokasi) {
            getSupportActionBar().setTitle("Lokasi");
            fragmentTransaction.replace(R.id.ini_Fragment, new  Lokasi()).addToBackStack(null);
        } else if (id == R.id.notif) {
            getSupportActionBar().setTitle("Notifikasi");
            fragmentTransaction.replace(R.id.ini_Fragment, new  Notif()).addToBackStack(null);
        }else if (id == R.id.FAQ) {
            getSupportActionBar().setTitle("FAQ");
            fragmentTransaction.replace(R.id.ini_Fragment, new  FAQ()).addToBackStack(null);
        }
        else if (id == R.id.service){
            getSupportActionBar().setTitle("Customer Service");
            fragmentTransaction.replace(R.id.ini_Fragment, new CustomerService()).addToBackStack(null);
        }
        else if (id == R.id.histori){
            getSupportActionBar().setTitle("Riwayat");
            fragmentTransaction.replace(R.id.ini_Fragment, new Riwayat()).addToBackStack(null);
        }
        fragmentTransaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
