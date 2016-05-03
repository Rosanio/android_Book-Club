package com.example.guest.bookclub.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guest.bookclub.ui.TopicFragment;

import java.util.ArrayList;

/**
 * Created by Guest on 5/3/16.
 */
public class CategoryPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<String> mCategories;

    public CategoryPagerAdapter(FragmentManager fm, ArrayList<String> categories) {
        super(fm);
        mCategories = categories;
    }

    @Override
    public Fragment getItem(int position) {
        return TopicFragment.newInstance(mCategories.get(position));
    }

    @Override
    public int getCount() {
        return mCategories.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCategories.get(position);
    }
}
