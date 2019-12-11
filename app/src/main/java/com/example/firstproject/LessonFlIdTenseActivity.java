package com.example.firstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.firstproject.model.LessonFlIdTense;
import com.example.firstproject.adapter.LessonFlIdTenseAdapter;
import com.example.firstproject.database.DataBaseHelper;

import java.util.ArrayList;

public class LessonFlIdTenseActivity extends AppCompatActivity {
    RecyclerView rvLeessonflIdtense;
    ArrayList<LessonFlIdTense> list;
    LessonFlIdTenseAdapter adapter;
    DataBaseHelper dataBaseHelper;
    Intent intent;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_fl_id_tense);
        toolbar=findViewById(R.id.toolbar);
        intent=getIntent();
        Bundle bundle=intent.getExtras();
        toolbar.setTitle(bundle.getString("name"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
