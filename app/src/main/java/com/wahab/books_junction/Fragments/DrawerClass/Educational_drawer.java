package com.wahab.books_junction.Fragments.DrawerClass;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.wahab.books_junction.Fragments.TabListClass.Eleventh_TabList;
import com.wahab.books_junction.Fragments.TabListClass.Twelveth_Tablist;
import com.wahab.books_junction.R;
import com.wahab.books_junction.Fragments.TabListClass.Twelveth_Tablist;


public class Educational_drawer extends android.support.v4.app.Fragment
{
    String books[]={"Select Standard","10TH  STD","11TH  STD","12TH  STD"};
    Spinner spinner;
    String record="";
    Button click;


    SSC_drawer ssc_drawer;
    //SSC_10TH ssc_10TH;
    Eleventh_TabList eleventh_tabList;
    Twelveth_Tablist twelveth_tablist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_educational_drawer, container, false);

        spinner=(Spinner)view.findViewById(R.id.spinner);
        click=(Button)view.findViewById(R.id.button4);

        //ssc_10TH= new SSC_10TH();
        ssc_drawer =new SSC_drawer();
        eleventh_tabList=new Eleventh_TabList();
        twelveth_tablist=new Twelveth_Tablist();


        ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,books);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
{
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        switch (position)
        {
            case 0:
                break;

            case 1:
                record = parent.getItemAtPosition(position).toString();
                break;

            case 2:
                record = parent.getItemAtPosition(position).toString();
                break;

            case 3:
                record = parent.getItemAtPosition(position).toString();
                break;
                }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});

click.setOnClickListener(new View.OnClickListener()

{
    @Override
    public void onClick(View v)
    {
        if (record==books[1])
        {
            FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();

            final android.support.v4.app.FragmentTransaction replace = fragmentTransaction.replace(R.id.framelayout,ssc_drawer);

            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        else if (record==books[2])
        {

            FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();

            final android.support.v4.app.FragmentTransaction replace = fragmentTransaction.replace(R.id.framelayout,eleventh_tabList);

            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
        else if (record==books[3])
        {

            FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction2=fragmentManager.beginTransaction();

            final android.support.v4.app.FragmentTransaction replace = fragmentTransaction2.replace(R.id.framelayout,twelveth_tablist);

            fragmentTransaction2.addToBackStack(null);
            fragmentTransaction2.commit();

        }
    }
});

   return view;
    }

}