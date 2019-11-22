package com.example.firstproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.firstproject.R;
import com.example.firstproject.adapter.ViewpagerAdapter;
import com.example.firstproject.grammar.LessonThroughTenseFragment;
import com.example.firstproject.grammar.LessonThroughWordFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class GrammarFragment  extends Fragment {
    View vRoot;
    ArrayList<Fragment> listFragment;
    ViewPager viewPager;
    TabLayout tabLayout;
    public GrammarFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vRoot =  inflater.inflate(R.layout.fragment_grammar, container, false);
        init();
        prepareViewPager();
        return vRoot;
    }

    private void init() {
        listFragment = new ArrayList<>();
        viewPager = vRoot.findViewById(R.id.vpg);
        tabLayout = vRoot.findViewById(R.id.tb_layout);
        LessonThroughTenseFragment lessonThroughTenseFragment = new LessonThroughTenseFragment();
        LessonThroughWordFragment lessonThroughWordFragment = new LessonThroughWordFragment();
        listFragment.add(lessonThroughTenseFragment);
        listFragment.add(lessonThroughWordFragment);
    }
    void prepareViewPager(){
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getChildFragmentManager(),listFragment, "Câu", "Từ");
        viewPager.setAdapter(viewpagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
