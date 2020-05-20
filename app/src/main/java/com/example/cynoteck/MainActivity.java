package com.example.cynoteck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public DrawerLayout drawer;
    NavigationView navigationView;
    CircleImageView profile_image;
    RelativeLayout mainRL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        @SuppressLint("WrongConstant")
        SharedPreferences sh = getSharedPreferences("userdetails", MODE_APPEND);

        String s1 = sh.getString("user_id", "");
        Toast.makeText(this, ""+s1, Toast.LENGTH_SHORT).show();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
       // mainRL=navigationView.getHeaderView(0).findViewById(R.id.mainRL);

        navigationView= (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View view = navigationView.getHeaderView(0);


        profile_image=navigationView.getHeaderView(0).findViewById(R.id.profile_image);
        TextView username = view.findViewById(R.id.nameTV);
        username.setText(s1);

        displaySelectedScreen(R.id.nav_home);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        displaySelectedScreen(menuItem.getItemId());

        return false;
    }

    private void displaySelectedScreen(int itemId) {

        Fragment fragment = null;

        switch (itemId) {
            case R.id.nav_home:
                fragment = new Home(drawer);
                break;

            case R.id.mapview:

                Toast.makeText(this, "MapView", Toast.LENGTH_SHORT).show();


                break;

            case R.id.listview:

                Toast.makeText(this, "ListView", Toast.LENGTH_SHORT).show();


                break;
            case R.id.online:
                Toast.makeText(this, "Online", Toast.LENGTH_SHORT).show();

                break;
            case R.id.offline:

                Toast.makeText(this, "Offline", Toast.LENGTH_SHORT).show();


                break;

            case R.id.reports:


                Toast.makeText(this, "Reports", Toast.LENGTH_SHORT).show();

                break;

            case R.id.logout:

                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);

                SharedPreferences settings = getSharedPreferences("userdetails", Context.MODE_PRIVATE);
                settings.edit().clear().commit();


                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }





    }

