package com.example.firstproject.grammar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject.Model.LessonThroughTense;
import com.example.firstproject.Model.LessonThroughWord;
import com.example.firstproject.R;
import com.example.firstproject.adapter.LessonThroughTenseAdapter;

import java.util.ArrayList;

public class LessonThroughTenseFragment extends Fragment {
    View vRoot;
    RecyclerView rvLesson;
    ArrayList<LessonThroughTense> list;
    LessonThroughTenseAdapter adapter;
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
        list.add(new LessonThroughTense("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
        list.add(new LessonThroughTense("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
        list.add(new LessonThroughTense("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
        list.add(new LessonThroughTense("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
        list.add(new LessonThroughTense("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
        list.add(new LessonThroughTense("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
        list.add(new LessonThroughTense("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
        list.add(new LessonThroughTense("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
        list.add(new LessonThroughTense("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
        list.add(new LessonThroughTense("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
        list.add(new LessonThroughTense("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
        configRv();
    }
    void configRv(){
        rvLesson = vRoot.findViewById(R.id.rvLesson);
        rvLesson.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        adapter= new LessonThroughTenseAdapter(getContext(), list) {
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
        };
        rvLesson.setAdapter(adapter);
    }
}
