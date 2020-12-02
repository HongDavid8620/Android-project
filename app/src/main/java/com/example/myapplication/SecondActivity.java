package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.Screen.Contactfragment;
import com.example.myapplication.Screen.Customerfragment;
import com.example.myapplication.Screen.Homefragment;
import com.example.myapplication.Screen.Invoicefragment;
import com.google.android.material.navigation.NavigationView;

public class SecondActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //variable
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Hook//
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //Tool Bar//
        setSupportActionBar(toolbar);
        //navigation drawer menu//
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigatin_drawer_open,R.string.navigatin_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState==null) {
            navigationView.setCheckedItem(R.id.nav_home);
            //Defualt Fragment//
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Homefragment()).commit();
        }

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer((GravityCompat.START));
        }
        else
        {
            super.onBackPressed();
        }
    }


    //Nav Select
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Homefragment()).commit();
                Toast.makeText(this, "Home page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_customer:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Customerfragment()).commit();
                break;
            case R.id.nav_invoice:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Invoicefragment()).commit();
                break;
            case R.id.nav_contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Contactfragment()).commit();
                break;
            case R.id.nav_phone:
                Toast.makeText(this, "Back to phone page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_exit:
                Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void newactivtiy(View v)
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}