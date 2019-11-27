package com.example.firstproject.presenter;

import android.content.Context;
import android.view.MenuItem;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.firstproject.GrammarFragment;
import com.example.firstproject.R;
import com.example.firstproject.onClickView;

public class ViewPresenter {
    private onClickView onClickView;
    FragmentManager fragmentManager;
    DrawerLayout drawer;
    public ViewPresenter(com.example.firstproject.onClickView onClickView) {
        this.onClickView = onClickView;
    }

    public ViewPresenter(Context context) {
    }

    public void grammar(){

        onClickView.grammar();

    }
    public void translate(){
        onClickView.translate();
    }
    public void about(){
        onClickView.about();
    }
    public void exit(){
        onClickView.exit();
    }

    public void navigate() {
        onClickView.navigate();
    }
}
