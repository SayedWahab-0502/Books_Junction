package com.wahab.books_junction;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.Locale;


public class SSC_drawer extends Fragment  implements SearchView.OnQueryTextListener
{

    //Declare Variables
    private ListView listView;

    private CustomListAdapter adapter;

    private SearchView editsearch;

    public static ArrayList<Books> arraylist = new ArrayList<Books>();

    String bookssc[] = {"Geography," + "\n" + "English Medium(MH Board)", "Hindi" + "\n" + "Lokvani(MH Board)", "History and Political" + "\n" + "Science,English Medium(MH Board)", "Marathi" + "\n" + "Medium(MH Board)", "Science - 1" + "\n" + ",English Medium(MH Board)"};
    int bookpicssc[] = {R.drawable.geography_ssc, R.drawable.hindi_ssc, R.drawable.history_ssc, R.drawable.marathi_ssc, R.drawable.science_ssc};
    String bookauthorssc[] = {"Sneha Rathod Meghana Jadhav", "Jyoti Navik Chandrabhushan Shukla", "Sneha Rathod Meghana Jadhav", "Ketki Deshpande", "Mukesh Paradiya Collin Fernandes"};
    String bookpricessc[] = {"₹ 175.00", "₹ 180.00", "₹ 160.00", "₹ 396.00 ", "₹ 125.00"};
    String languagebookssc[] = {"English", "Hindi", "English", "Marathi", "English"};
    String codelistssc[] = {"#SSC0001", "#SSC0002", "#SSC0003", "#SSC0004", "#SSC0005"};
    String publisherssc[] = {"Target Publications" + "\n" + "Pvt.Ltd.;(2018)", "Target Publications Pvt." + "\n" + "Ltd.; 2018 edition (2018)", "Target Publications Pvt." + "\n" + "Ltd.; 2018 edition (2018)", "Target Publications Pvt." + "\n" + "Ltd.;(2018)", "Target Publications Pvt." + "\n" + "Ltd.; 2018 edition (2018)"};
    String paperbackssc[] = {"399 pages", "200 pages", "455 pages", "260 pages", "528 pages"};
    String dimensionssc[] = {"20.2 x 13 x 0.7 cm", "20.1 x 13 x 0.6 cm", "20.1 x 13 x 0.8 cm", "28 x 20.5 x 2.1 cm", "20 x 13 x 0.9 cm"};


    //Context mContext;
    //View view;


    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)

    {

        View view = inflater.inflate(R.layout.fragment_ssc_drawer, container, false);

        // Locate the ListView in listview_main.xml
        listView = (ListView) view.findViewById(R.id.listview_ssc);

        // Locate the EditText in listview_main.xml


        //  listView.setAdapter(adapter);
        arraylist = new ArrayList<>();

        for (int i = 0; i < bookssc.length; i++)
        {
            Books movieNames = new Books(bookssc[i],bookpicssc[i]);
            // Binds all strings into an array
            arraylist.add(movieNames);
        }


        adapter=new CustomListAdapter(view.getContext());
        listView.setAdapter(adapter);


        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) view.findViewById(R.id.search_view_ssc);

        //editsearch.setOnClickListener((View.OnClickListener) this);

        editsearch.setOnQueryTextListener(this);

        editsearch.setIconifiedByDefault(false);
        // editsearch.setSubmitButtonEnabled(true);
        editsearch.setQueryHint("Search Here...");






        return view;
    }


    @Override
    public boolean onQueryTextSubmit(String query)
    {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText)
    {
        String text = newText;
        adapter.filter(text);
        return true;
    }



    public class CustomListAdapter extends BaseAdapter {

        private Context mContext;
        LayoutInflater inflater;
        private ArrayList<Books> arraylist;


        public CustomListAdapter(Context context) {

            mContext = context;
            inflater = LayoutInflater.from(mContext);
            this.arraylist = new ArrayList<Books>();
            this.arraylist.addAll(SSC_drawer.arraylist);

        }

        public class ViewHolder {
            TextView name;
            ImageView image;
        }


        @Override
        public int getCount() {
            return SSC_drawer.arraylist.size();
        }

        @Override
        public Object getItem(int position) {
            return SSC_drawer.arraylist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            final ViewHolder holder;
            convertView = null;

            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.activity_adapter_activity, null);

                // Locate the TextViews in listview_item.xml
                holder.name = (TextView) convertView.findViewById(R.id.bookname);
                holder.image = (ImageView) convertView.findViewById(R.id.bookimage);

                convertView.setTag(holder);
            }
            else
                {
                holder = (ViewHolder) convertView.getTag();
            }


            //set the results into textviews
            holder.name.setText(SSC_drawer.arraylist.get(position).getName());
            //set the result in imageview
            holder.image.setImageResource(SSC_drawer.arraylist.get(position).getImg());


            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent j = new Intent(mContext,SSC_AddToBag_list.class);

                    j.putExtra("imagessc", bookpicssc[position]);
                    j.putExtra("namessc", bookssc[position]);
                    j.putExtra("authorssc", bookauthorssc[position]);
                    j.putExtra("pricessc", bookpricessc[position]);
                    j.putExtra("languagessc", languagebookssc[position]);
                    j.putExtra("publisherssc", publisherssc[position]);
                    j.putExtra("paperbackssc", paperbackssc[position]);
                    j.putExtra("codessc", codelistssc[position]);
                    j.putExtra("dimensionssc", dimensionssc[position]);

                    startActivity(j);

                }
            });


            return convertView;
        }


        // Filter Class
        public void filter(String charText)
        {
            charText = charText.toLowerCase(Locale.getDefault());

            SSC_drawer.arraylist.clear();

            if (charText.length() == 0)
            {
                SSC_drawer.arraylist.addAll(arraylist);
            }
            else
                {
                for (Books twel : arraylist)
                {
                    if (twel.getName().toLowerCase(Locale.getDefault()).contains(charText))
                    {
                        SSC_drawer.arraylist.add(twel);
                    }
                }
            }
            notifyDataSetChanged();
        }

    } //end of Custom Adapter
}