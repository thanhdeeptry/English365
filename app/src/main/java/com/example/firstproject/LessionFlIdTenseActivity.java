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
import com.example.firstproject.Model.LessonFlIdWord;
import com.example.firstproject.adapter.LessionFlIdWordAdapter;
import com.example.firstproject.adapter.LessonFlIdTenseAdapter;
import com.example.firstproject.database.DataBaseHelper;

import java.util.ArrayList;

public class LessionFlIdTenseActivity extends AppCompatActivity {
    RecyclerView rvLeessonflIdtense;
    ArrayList<LessionFlIdTense> list;
    LessonFlIdTenseAdapter adapter;
    DataBaseHelper dataBaseHelper;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lession_fl_id_tense);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        intent=getIntent();
        Bundle bundle=intent.getExtras();
        rvLeessonflIdtense = findViewById(R.id.rvLessionflidtense);
        rvLeessonflIdtense.setHasFixedSize(true);
        list= new ArrayList<>();
        dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.createDataBase();
        list=dataBaseHelper.getAllLessonFlIdtense(bundle.getString("idtense"));
        configRv();
    }
    void configRv(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLeessonflIdtense.setLayoutManager(layoutManager);
        adapter= new LessonFlIdTenseAdapter(this, list) {


        };
        rvLeessonflIdtense.setAdapter(adapter);
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
