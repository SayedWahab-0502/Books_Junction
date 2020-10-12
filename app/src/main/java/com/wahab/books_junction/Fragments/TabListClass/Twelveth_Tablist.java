package com.wahab.books_junction.Fragments.TabListClass;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wahab.books_junction.Fragments.BlankFragment111_12th;
import com.wahab.books_junction.Fragments.BlankFragment222_12th;
import com.wahab.books_junction.R;


public class Twelveth_Tablist extends Fragment {


    View view;
    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {

        view=inflater.inflate(R.layout.fragment_twelveth__tablist, container, false);

        tabLayout = (TabLayout)view.findViewById(R.id.tabs222);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager222);

        viewPager.setAdapter(new PagerAdapter222(getChildFragmentManager()));


    tabLayout.post(new Runnable() {
        @Override
        public void run() {

            tabLayout.setupWithViewPager(viewPager);
        }
    });

        return view;
    }



    public class PagerAdapter222 extends FragmentPagerAdapter
    {
        final String tabs[]={"Science","Commerce"};

        public PagerAdapter222(FragmentManager fragmentManager)
        {
            super(fragmentManager);
        }


        @Override
        public CharSequence getPageTitle(int position)
        {

            return tabs[position];
        }

        @Override
        public android.support.v4.app.Fragment getItem(int i)

        {
            switch(i)
            {

                case 0:
                    return new BlankFragment111_12th();
                case 1:
                    return new BlankFragment222_12th();

                default:
                    return null;
            }
        }

        @Override
        public int getCount()

        {
            return 2;
        }
    }

}
