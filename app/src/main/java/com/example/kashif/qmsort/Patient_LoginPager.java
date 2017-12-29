package com.example.kashif.qmsort;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.ArrayList;

/**
 * Created by AST on 10/23/2017.
 */

public class Patient_LoginPager extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragments;


    public Patient_LoginPager(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }



    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


}
