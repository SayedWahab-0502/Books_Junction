package com.wahab.books_junction.Fragments.DrawerClass;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.wahab.books_junction.HelperClasses.Books;
import com.wahab.books_junction.R;
import com.wahab.books_junction.Activities.Science_Grid;

import java.util.ArrayList;
import java.util.Locale;

public class Science_fiction_drawer extends Fragment implements SearchView.OnQueryTextListener

   {

    private GridView gridView;
    // Declare Variables
    private CustomGridScienceAdapter adapter;

    private SearchView editsearchsci;

    public static ArrayList<Books> science_arraylist= new ArrayList<Books>();


    String namefiction[] = {"Relativity: The Special and General Theory.", " 100 Facts -  Exploring Space.", "Physics of the Impossible.", "The Time Machine.", "The Big Book of Science Fiction.", "Artemis."};

    int imgfiction[] = {R.drawable.albert_fiction, R.drawable.exploring_space, R.drawable.physics_fiction, R.drawable.time_machine, R.drawable.big_book_fiction, R.drawable.artemis_fiction};

    String authorfiction[] = {"Albert Einstein", "Miles Kelly", "Michio Kaku", "H. G. Wells", "Jeff Vandermeer", "Andy Weir"};

    String pricefiction[] = {"₹ 179.00", "₹ 602.00", "₹ 399.00", "₹ 99.00", "₹ 885.00", "₹ 299.00"};

    String fictionpublisher[] = {"Jaico Publishing Huse" + "\n" + "(17 October 2018)", "Miles Kelly Publishing" + "\n" + "Ltd (1 May 2011)", "Penguin UK; Latest" + "\n" + "Edition edition" + "\n" + "(28 May 2009)", "Fingerprint! Publishing;" + "\n" + "Latest edition (1 July 2015)", "Random House; Latest" + "\n" + "edition (29 September 2016)", "Random House (29 November 2017)."};


    String paperbackfiction[] = {"98 pages", "48 pages", "352 pages", "144 pages", "1216 pages", "352 pages"};

    String productcode[] = {"#SF0001", "#SF0002", "#SF0003", "#SF0004", "#SF0005", "#SF0006"};

    String fictiondimension[] = {"21.5 x 14 x 1.3 cm", "22.9 x 0.6 x 29.8 cm", "12.9 x 2 x 19.8 cm", "19.6 x 12.6 x 0.4 cm", " 17.6 x 5.2 x 23.1 cm", "15.3 x 2.3 x 23.4 cm"};

    String languagefiction[] = {"English", "English", "English", "English", "English", "English"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)

    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_science_fiction_drawer, container, false);

        gridView = (GridView) view.findViewById(R.id.gridview_science_fiction);


        //  listView.setAdapter(adapter);
        science_arraylist = new ArrayList<>();

        for (int i = 0; i < namefiction.length; i++)
        {
            Books movieNames = new Books(namefiction[i],imgfiction[i]);
            // Binds all strings into an array
            science_arraylist.add(movieNames);
        }


        adapter = new CustomGridScienceAdapter(view.getContext());

        gridView.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearchsci = (SearchView) view.findViewById(R.id.search_view_science);

        //editsearch.setOnClickListener((View.OnClickListener) this);

        editsearchsci.setOnQueryTextListener(this);

        editsearchsci.setIconifiedByDefault(false);
        // editsearch.setSubmitButtonEnabled(true);
        editsearchsci.setQueryHint("Search Here...");


    /* gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id)
         {
             Intent j=new Intent(getActivity(),Science_Grid.class);

             j.putExtra("bookname",namefiction[position]);
             j.putExtra("image1",imgfiction[position]);
             j.putExtra("bookauthor",authorfiction[position]);
             j.putExtra("bookprice",pricefiction[position]);
             j.putExtra("publisher",fictionpublisher[position]);
             j.putExtra("paperback",paperbackfiction[position]);
             j.putExtra("code",productcode[position]);
             j.putExtra("dimension",fictiondimension[position]);
             j.putExtra("language",languagefiction[position]);

             startActivity(j);
         }
     });*/
        return view;
    }

       @Override
       public boolean onQueryTextSubmit(String query)
       {
           return false;
       }

       @Override
       public boolean onQueryTextChange(String newText){
           String text = newText;
           adapter.filtersci(text);
           return true;
    }


       public class CustomGridScienceAdapter extends BaseAdapter
    {
        private Context mContext;
        LayoutInflater inflater;
        private ArrayList<Books> arraylist;  //done



        public CustomGridScienceAdapter(Context context)
        {
            mContext = context;
            inflater = LayoutInflater.from(mContext);

            this.arraylist = new ArrayList<Books>();
            this.arraylist.addAll(Science_fiction_drawer.science_arraylist);
        }


        public class ViewHolder
        {
            TextView sciname;
            ImageView sciimage;
        }

        @Override
        public int getCount()
        {
            return Science_fiction_drawer.science_arraylist.size();
        }

        @Override
        public Object getItem(int position)
        {
            return Science_fiction_drawer.science_arraylist.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            //View grid;
            //LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            final ViewHolder holder;

            convertView=null;

            if (convertView == null)
            {
                holder = new ViewHolder();
                convertView=inflater.inflate(R.layout.adapter_activity3,null);


                // Locate the TextViews in listview_item.xml
                holder.sciname = (TextView) convertView.findViewById(R.id.booknamegrid);
                holder.sciimage = (ImageView) convertView.findViewById(R.id.imagegrid);
                convertView.setTag(holder);
            }

            else{
                holder = (ViewHolder)convertView.getTag();
            }

            //set the results into textviews
            holder.sciname.setText(Science_fiction_drawer.science_arraylist.get(position).getName());
            //set the result in imageview
            holder.sciimage.setImageResource(Science_fiction_drawer.science_arraylist.get(position).getImg());






            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)

                {

                    Intent j=new Intent(getActivity(), Science_Grid.class);

                    j.putExtra("bookname",namefiction[position]);
                    j.putExtra("image1",imgfiction[position]);
                    j.putExtra("bookauthor",authorfiction[position]);
                    j.putExtra("bookprice",pricefiction[position]);
                    j.putExtra("publisher",fictionpublisher[position]);
                    j.putExtra("paperback",paperbackfiction[position]);
                    j.putExtra("code",productcode[position]);
                    j.putExtra("dimension",fictiondimension[position]);
                    j.putExtra("language",languagefiction[position]);

                    startActivity(j);

                }
            });


            return convertView;
        }


        // Filter Class
        public void filtersci(String charText)
        {
            charText = charText.toLowerCase(Locale.getDefault());

            Science_fiction_drawer.science_arraylist.clear();

            if (charText.length() == 0)
            {
                Science_fiction_drawer.science_arraylist.addAll(arraylist);
            }
            else
            {
                for (Books wp : arraylist)
                {
                    if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText))
                    {
                        Science_fiction_drawer.science_arraylist.add(wp);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }  //end of adapter

   }