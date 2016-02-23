package com.example.fairlynguyen.demoproject.adapter;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.fairlynguyen.demoproject.fragment.GameFragment;
import com.example.fairlynguyen.demoproject.fragment.MovieFragment;
import com.example.fairlynguyen.demoproject.fragment.StudyFragment;

/**
 * Created by fairlyNGUYEN on 2/23/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new GameFragment();
                break;
            case 1:
                frag=new MovieFragment();
                break;
            case 2:
                frag=new StudyFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title=" ";
        switch (position){
            case 0:
                title="Game";
                break;
            case 1:
                title="Movie";
                break;
            case 2:
                title="Study";
                break;
        }

        return title;
    }
}
