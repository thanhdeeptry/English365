package com.example.firstproject.grammar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject.model.LessonThroughWord;
import com.example.firstproject.R;
import com.example.firstproject.adapter.LessonThroughWordAdapter;
import com.example.firstproject.database.DataBaseHelper;

import java.util.ArrayList;

public class LessonThroughWordFragment  extends Fragment {
    View view;
    ArrayList<LessonThroughWord> list;
    RecyclerView rvLesson;
    LessonThroughWordAdapter adapter;
    private DataBaseHelper dataBaseHelper;
    public LessonThroughWordFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_tense, container, false);
        init();
        return view;
    }
    void init(){
        list= new ArrayList<>();
        dataBaseHelper = new DataBaseHelper(getContext());
        dataBaseHelper.createDataBase();
        list=dataBaseHelper.getAllLessionByWord();
        configRv();
    }
    void configRv(){

        rvLesson = view.findViewById(R.id.rvLesson);
        rvLesson.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        adapter = new LessonThroughWordAdapter(getContext(), list) {


        };
        rvLesson.setAdapter(adapter);
    }
}
