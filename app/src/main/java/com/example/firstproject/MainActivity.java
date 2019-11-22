package com.example.firstproject;

import android.content.DialogInterface;
import android.os.Bundle;


import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer= findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager =getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        GrammarFragment grammarFragment=new GrammarFragment();
        transaction.replace(R.id.content,grammarFragment);
        transaction.commit();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_grammar:

                FragmentTransaction transaction = fragmentManager.beginTransaction();//
                GrammarFragment grammarFragment = new GrammarFragment();
                transaction.replace(R.id.content, grammarFragment);
                transaction.commit();
                item.setChecked(true);
                drawer.closeDrawers();
                break;
            case R.id.nav_translate:
                FragmentTransaction transaction1 = fragmentManager.beginTransaction();//
                TranslateFragment translateFragment = new TranslateFragment();
                transaction1.replace(R.id.content, translateFragment);
                transaction1.commit();
                item.setChecked(true);
                drawer.closeDrawers();
                break;

            case R.id.nav_about:
                FragmentTransaction transaction2 = fragmentManager.beginTransaction();//
                AboutFragment aboutFragment = new AboutFragment();
                transaction2.replace(R.id.content, aboutFragment);
                transaction2.commit();
                item.setChecked(true);
                drawer.closeDrawers();
                break;

            case R.id.nav_exit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Bạn thật sự muốn thoát app ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        System.exit(0);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();

                break;
        }
        return false;
    }
}
