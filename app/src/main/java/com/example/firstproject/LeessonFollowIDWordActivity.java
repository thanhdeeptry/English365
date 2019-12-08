package com.example.firstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.firstproject.Model.LessonFlIdWord;
import com.example.firstproject.adapter.LessionFlIdWordAdapter;
import com.example.firstproject.database.DataBaseHelper;

import java.util.ArrayList;

public class LeessonFollowIDWordActivity extends AppCompatActivity {
RecyclerView rvLeessonflId;
ArrayList<LessonFlIdWord> list;
LessionFlIdWordAdapter adapter;
DataBaseHelper dataBaseHelper;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leesson_flow_id);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        intent=getIntent();
        Bundle bundle=intent.getExtras();
        rvLeessonflId = findViewById(R.id.rvLessonflowid);
        rvLeessonflId.setHasFixedSize(true);
        list= new ArrayList<>();
        dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.createDataBase();
        list=dataBaseHelper.getAllLessonFlIdWord(bundle.getString("idword"));
        configRv();
    }
    void configRv(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLeessonflId.setLayoutManager(layoutManager);
        adapter=new LessionFlIdWordAdapter(this,list);
        rvLeessonflId.setAdapter(adapter);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
