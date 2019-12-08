package com.example.firstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.firstproject.Model.LessionFlIdTense;
import com.example.firstproject.Model.LessonFlLessonIdWord;
import com.example.firstproject.adapter.LessonFlIdTenseAdapter;
import com.example.firstproject.adapter.LessonFlLessonIdWordAdapter;
import com.example.firstproject.database.DataBaseHelper;

import java.util.ArrayList;

public class LessonFlLessonIdWordActivity extends AppCompatActivity {
    RecyclerView rvLeessonfllessonId;
    ArrayList<LessonFlLessonIdWord> list;
    LessonFlLessonIdWordAdapter adapter;
    DataBaseHelper dataBaseHelper;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        intent=getIntent();
        Bundle bundle=intent.getExtras();
        rvLeessonfllessonId = findViewById(R.id.rvLessonflLessonid);
        rvLeessonfllessonId.setHasFixedSize(true);
        list= new ArrayList<>();
        dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.createDataBase();
        list=dataBaseHelper.getAllLessonFlLessonIdWord(bundle.getString("id"));
        configRv();
    }

    private void configRv() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLeessonfllessonId.setLayoutManager(layoutManager);
        adapter= new LessonFlLessonIdWordAdapter(this, list) {
            @Override
            public void grammar() {

            }

            @Override
            public void translate() {

            }

            @Override
            public void about() {

            }

            @Override
            public void exit() {

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

            @Override
            public void navigate() {

            }
        };
        rvLeessonfllessonId.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
