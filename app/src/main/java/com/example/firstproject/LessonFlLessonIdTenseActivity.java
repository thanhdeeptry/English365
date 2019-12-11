package com.example.firstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.firstproject.model.LessonFlLessonIdTense;
import com.example.firstproject.adapter.LessonFlLessonIdTenseAdapter;
import com.example.firstproject.database.DataBaseHelper;

import java.util.ArrayList;

public class LessonFlLessonIdTenseActivity extends AppCompatActivity {
    RecyclerView rvLeessonfllessonId;
    ArrayList<LessonFlLessonIdTense> list;
    LessonFlLessonIdTenseAdapter adapter;
    DataBaseHelper dataBaseHelper;
    Intent intent;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_fl_lesson_id_tense);
        toolbar=findViewById(R.id.toolbar);
        intent=getIntent();
        Bundle bundle=intent.getExtras();
        toolbar.setTitle(bundle.getString("name"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rvLeessonfllessonId = findViewById(R.id.rvLessonflLessonid);
        rvLeessonfllessonId.setHasFixedSize(true);
        list= new ArrayList<>();
        dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.createDataBase();
        list=dataBaseHelper.getAllLessonFlLessonIdtense(bundle.getString("id"));
        configRv();
    }

    private void configRv() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLeessonfllessonId.setLayoutManager(layoutManager);
        adapter= new LessonFlLessonIdTenseAdapter(this, list) ;

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
