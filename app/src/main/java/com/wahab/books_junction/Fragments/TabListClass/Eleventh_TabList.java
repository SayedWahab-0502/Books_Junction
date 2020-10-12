package com.wahab.books_junction.Fragments.TabListClass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wahab.books_junction.Fragments.BlankFragment111;
import com.wahab.books_junction.Fragments.BlankFragment222;
import com.wahab.books_junction.R;


public class Eleventh_TabList extends Fragment
{
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_eleventh__tab_list, container, false);

        tabLayout = (TabLayout)view.findViewById(R.id.tabs);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

         viewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));

        // mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        //mRecyclerView.setLayoutManager(mLayoutManager);

        tabLayout.post(new Runnable() {
            @Override
            public void run() {

                tabLayout.setupWithViewPager(viewPager);
            }
        });


        return view;
    }

    public class PagerAdapter extends FragmentStatePagerAdapter
    {
        final String tabs[]={"Science","Commerce"};

        public PagerAdapter(FragmentManager fragmentManager)

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
                              return new BlankFragment111();
                          case 1:
                              return new BlankFragment222();

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