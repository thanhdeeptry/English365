package com.example.firstproject.grammar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject.Model.LessonThroughWord;
import com.example.firstproject.R;
import com.example.firstproject.adapter.LessonThroughWordAdapter;

import java.util.ArrayList;

public class LessonThroughWordFragment  extends Fragment {
    View view;
    ArrayList<LessonThroughWord> list;
    RecyclerView rvLesson;
    LessonThroughWordAdapter adapter;
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
            list.add(new LessonThroughWord("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
            list.add(new LessonThroughWord("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
            list.add(new LessonThroughWord("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
            list.add(new LessonThroughWord("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
            list.add(new LessonThroughWord("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
            list.add(new LessonThroughWord("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
            list.add(new LessonThroughWord("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
            list.add(new LessonThroughWord("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));
            list.add(new LessonThroughWord("Các thì trong tiếng Anh","Hiện tại đơn, hiện tại tiếp diễn, quá khứ đơn ..."));

        configRv();
    }
    void configRv(){

        rvLesson = view.findViewById(R.id.rvLesson);
        rvLesson.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        adapter = new LessonThroughWordAdapter(getContext(), list) {
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
        rvLesson.setAdapter(adapter);
    }
}
