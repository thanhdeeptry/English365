package com.example.firstproject.grammar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject.model.LessonThroughTense;
import com.example.firstproject.R;
import com.example.firstproject.adapter.LessonThroughTenseAdapter;
import com.example.firstproject.database.DataBaseHelper;

import java.util.ArrayList;

public class LessonThroughTenseFragment extends Fragment {
    View vRoot;
    RecyclerView rvLesson;
    ArrayList<LessonThroughTense> list;
    LessonThroughTenseAdapter adapter;
    DataBaseHelper dataBaseHelper;
    public LessonThroughTenseFragment() {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vRoot =  inflater.inflate(R.layout.fragment_tense, container, false);
        init();
        return vRoot;
    }
    void init(){

        list=new ArrayList<>();
        dataBaseHelper = new DataBaseHelper(getContext());
        dataBaseHelper.createDataBase();
        list=dataBaseHelper.getAllLessionByTense();
        configRv();
    }
    void configRv(){
        rvLesson = vRoot.findViewById(R.id.rvLesson);
        rvLesson.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        adapter= new LessonThroughTenseAdapter(getContext(), list) {


        };
        rvLesson.setAdapter(adapter);
    }
}
