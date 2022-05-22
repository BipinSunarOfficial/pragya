package com.example.meroarkoapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<String> fragmentTitleList = new ArrayList<>();
    private final List<Fragment> fragmentList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager){ super(manager); }

    @NonNull
    @Override
    public Fragment getItem(int position) { return fragmentList.get(position);}


    public  void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }



    @Nullable
    @Override
    public CharSequence getPageTitle(int position){return fragmentTitleList.get(position);}

    @Override
    public int getCount(){ return fragmentList.size();}

}
