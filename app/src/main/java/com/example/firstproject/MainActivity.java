package com.example.firstproject;

import android.content.DialogInterface;
import android.os.Bundle;


import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.firstproject.presenter.ViewPresenter;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, onClickView {
    FragmentManager fragmentManager;
    DrawerLayout drawer;
    ViewPresenter viewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPresenter = new ViewPresenter((onClickView) this);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        GrammarFragment grammarFragment = new GrammarFragment();
        transaction.replace(R.id.content, grammarFragment);
        transaction.commit();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_grammar:

                viewPresenter.grammar();
                item.setChecked(true);
                break;
            case R.id.nav_translate:
                viewPresenter.translate();
                item.setChecked(true);
                break;

            case R.id.nav_about:
                viewPresenter.about();
                item.setChecked(true);
                break;

            case R.id.nav_exit:
                viewPresenter.exit();
                break;
        }
        return false;
    }




    @Override
    public void navigate() {

    }

    @Override
    public void grammar() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();//
        GrammarFragment grammarFragment = new GrammarFragment();
        transaction.replace(R.id.content, grammarFragment);
        transaction.commit();
        drawer.closeDrawers();
    }


    @Override
    public void translate() {
        FragmentTransaction transaction1 = fragmentManager.beginTransaction();//
        TranslateFragment translateFragment = new TranslateFragment();
        transaction1.replace(R.id.content, translateFragment);
        transaction1.commit();
        drawer.closeDrawers();
    }

    @Override
    public void about() {
        FragmentTransaction transaction2 = fragmentManager.beginTransaction();//
        AboutFragment aboutFragment = new AboutFragment();
        transaction2.replace(R.id.content, aboutFragment);
        transaction2.commit();
        drawer.closeDrawers();
    }

    @Override
    public void exit() {
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
    }

    @Override
    public void engtovn() {

    }

    @Override
    public void vntoenng() {

    }

    @Override
    public void navigateflid(int pos) {

    }

}
