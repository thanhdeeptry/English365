package com.example.firstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.firstproject.Model.LessonFollowID;
import com.example.firstproject.adapter.LessonFollowIDAdapter;
import com.example.firstproject.adapter.LessonThroughTenseAdapter;

import java.util.ArrayList;

public class LeessonFollowIDActivity extends AppCompatActivity {
RecyclerView rvLeessonflId;
ArrayList<LessonFollowID> list;
LessonFollowIDAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leesson_flow_id);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        rvLeessonflId = findViewById(R.id.rvLessonflowid);
        rvLeessonflId.setHasFixedSize(true);
        list= new ArrayList<>();
        list.add(new LessonFollowID("Hiện tại đơn","Present simple"));
        list.add(new LessonFollowID("Hiện tại tiếp diễn","Present Continuous"));
        list.add(new LessonFollowID("Hiện tại hoàn thành","Present Perfect"));
        list.add(new LessonFollowID("Hiện tại hoàn thành tiếp diễn","Present Perfect Continuous"));
        list.add(new LessonFollowID("Hiện tại đơn","Present simple"));
        list.add(new LessonFollowID("Hiện tại tiếp diễn","Present Continuous"));
        list.add(new LessonFollowID("Hiện tại hoàn thành","Present Perfect"));
        list.add(new LessonFollowID("Hiện tại hoàn thành tiếp diễn","Present Perfect Continuous"));
        list.add(new LessonFollowID("Hiện tại đơn","Present simple"));
        list.add(new LessonFollowID("Hiện tại tiếp diễn","Present Continuous"));
        list.add(new LessonFollowID("Hiện tại hoàn thành","Present Perfect"));
        list.add(new LessonFollowID("Hiện tại hoàn thành tiếp diễn","Present Perfect Continuous"));
        configRv();
    }
    void configRv(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLeessonflId.setLayoutManager(layoutManager);
        adapter= new LessonFollowIDAdapter(this, list) {
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
        };
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
