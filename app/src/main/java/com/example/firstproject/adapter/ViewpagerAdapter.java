package com.example.firstproject.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewpagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> listFragment;
    String title1, title2;
    public ViewpagerAdapter(FragmentManager fm, ArrayList<Fragment> listFragment, String title1, String title2) {
        super(fm);
        this.listFragment = listFragment;
        this.title1 = title1;
        this.title2 = title2;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return title1;
            case 1:
                return title2;
        }
        return super.getPageTitle(position);
    }
}
