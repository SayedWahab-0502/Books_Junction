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

import com.wahab.books_junction.Activities.Historical_Grid;
import com.wahab.books_junction.HelperClasses.Books;
import com.wahab.books_junction.R;

import java.util.ArrayList;
import java.util.Locale;

public class Historical_drawer extends Fragment  implements SearchView.OnQueryTextListener
{
   private GridView gridView;

   private CustomGridAdapterHis adapter;

    private SearchView editsearchhis;

    public static ArrayList<Books> historical_arraylist = new ArrayList<Books>();


    String name[] ={"The Incredible History of"+"\n"+"India's Geography.","I, Krishnadevaraya.","Empire of the Moghul.",
            "Padmavati: The Queen"+"\n"+"Tells Her Own Story.","Prithviraj Chauhan:"+"\n"+"The Emperor of Hearts.","   War & Peace."};

    int images[] = {R.drawable.india_history,R.drawable.krishnadevray,R.drawable.moghal_empire,R.drawable.padmavat,R.drawable.prithviraj_chauhan,R.drawable.war_peace};

    String author[] ={"Sanjeev Sanyal","Ra.Ki.Rangarajan","Alex Rutherford","Sutapa Basu","Anuja Chandramouli","Leo Tolstoy"};

    String price[] ={"₹ 250.00","₹ 150.00","₹ 399.00","₹ 199.00","₹ 169.00","₹ 299.00"};

   String historicalublisher[] ={"Penguin Books Limited;"+"\n"+"Latest edition"+"\n"+"(26 January 2015)"," Westland (20 March 2017)","Headline Book Publishing;"+"\n"+"Latest Edition edition"+"\n"+"(7 January 2010)","Readomania (2 December 2017)","Ebury Press (23 November 2017)","Fingerprint! Publishing;"+"\n"+"Latest edition (1 April 2015)"};

    String paperback_historical[] ={"264 pages","412 pages","512 pages","300 pages","288 pages","1232 pages"};

    String productcode[] ={"#H0001","#H0002","#H0003","#H0004","#H0005","#H0006"};

    String historicaldimension[] ={"20 x 1.7 x 13.4 cm","19.6 x 13 x 2.6 cm","11.2 x 17.7 x 3.4 cm","19.6 x 13 x 2.4 cm","20.2 x 13 x 3.2 cm","14 x 21.6 cm"};

    String historical_language[] ={"English","English","English","English","English","English"};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {

        View view=inflater.inflate(R.layout.fragment_historical_drawer, container, false);

      gridView=(GridView)view.findViewById(R.id.gridview_historical);


        //  listView.setAdapter(adapter);
        historical_arraylist = new ArrayList<>();

        for (int i = 0; i < name.length; i++)
        {
            Books movieNames = new Books(name[i],images[i]);
            // Binds all strings into an array
            historical_arraylist.add(movieNames);
        }

        adapter = new CustomGridAdapterHis(view.getContext());

        gridView.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearchhis = (SearchView)view.findViewById(R.id.search_view_historical);
        editsearchhis.setOnQueryTextListener(this);
        editsearchhis.setQueryHint("Search Here...");


     /* gridView.setOnItemClickListener(new View.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id)
          {

              Intent intent=new Intent(getActivity(),Historical_Grid.class);

              intent.putExtra("name",name[position]);
              intent.putExtra("image",images[position]);

              intent.putExtra("price",price[position]);
              intent.putExtra("author",author[position]);

              intent.putExtra("language",historical_language[position]);
              intent.putExtra("paperback",paperback_historical[position]);
              intent.putExtra("publisher",historicalublisher[position]);
              intent.putExtra("dimension",historicaldimension[position]);
              intent.putExtra("productcode",productcode[position]);

              startActivity(intent);
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
    public boolean onQueryTextChange(String newText)
    {
        String text = newText;
        adapter.filter(text);
        return true;
    }

    public class CustomGridAdapterHis extends BaseAdapter
    {

        private Context mContext;
        LayoutInflater inflater;
        private ArrayList<Books> arraylist;  //done


        public CustomGridAdapterHis(Context context)
        {
            mContext=context;
            inflater = LayoutInflater.from(mContext);
            this.arraylist = new ArrayList<Books>();
            this.arraylist.addAll(Historical_drawer.historical_arraylist);
        }

        public class ViewHolder
        {
            TextView hisname;
            ImageView hisimage;
        }

        @Override
        public int getCount()
        {
            return Historical_drawer.historical_arraylist.size();
        }

        @Override
        public Object getItem(int position)
        {
            return Historical_drawer.historical_arraylist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent)
        {
            final ViewHolder holder;

            convertView=null;

            if (convertView == null)
            {
                holder = new ViewHolder();
                convertView=inflater.inflate(R.layout.adapter_activity3,null);

                // Locate the TextViews in listview_item.xml
                holder.hisname = (TextView) convertView.findViewById(R.id.booknamegrid);
                holder.hisimage = (ImageView) convertView.findViewById(R.id.imagegrid);
                convertView.setTag(holder);

            }

            else {
                holder = (ViewHolder)convertView.getTag();
            }

            //set the results into textviews
            holder.hisname.setText(Historical_drawer.historical_arraylist.get(position).getName());
            //set the result in imageview
            holder.hisimage.setImageResource(Historical_drawer.historical_arraylist.get(position).getImg());


            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //code later
                    if (Historical_drawer.historical_arraylist.get(position).getName().equals("The Incredible History of"+"\n"+"India's Geography."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext, Historical_Grid.class);
                        intent.putExtra("Bookname", "The Incredible History of"+"\n"+"India's Geography.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image",R.drawable.india_history);
                        intent.putExtra("author"," Ra.Ki.Rangarajan");
                        intent.putExtra("price"," ₹ 250.00");
                        intent.putExtra("language"," English");
                        intent.putExtra("publisher"," Penguin Books Limited;"+"\n"+"Latest edition"+"\n"+"(26 January 2015)");
                        intent.putExtra("paperback"," 264 pages");
                        intent.putExtra("productcode"," #H0001");
                        intent.putExtra("dimension"," 20 x 1.7 x 13.4 cm");

                        mContext.startActivity(intent);
                    }


                    //code later
                    if (Historical_drawer.historical_arraylist.get(position).getName().equals("I, Krishnadevaraya."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext, Historical_Grid.class);
                        intent.putExtra("Bookname", "I, Krishnadevaraya.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image", R.drawable.krishnadevray);
                        intent.putExtra("author", " Sanjeev Sanyal");
                        intent.putExtra("price", " ₹ 150.00");
                        intent.putExtra("language", " English");
                        intent.putExtra("publisher", " Westland (20 March 2017)");
                        intent.putExtra("paperback", " 412 pages");
                        intent.putExtra("productcode", " #H0002");
                        intent.putExtra("dimension", " 19.6 x 13 x 2.6 cm");

                        mContext.startActivity(intent);
                    }


                    //code later
                    if (Historical_drawer.historical_arraylist.get(position).getName().equals("Empire of the Moghul."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext, Historical_Grid.class);
                        intent.putExtra("Bookname", "Empire of the Moghul.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image", R.drawable.moghal_empire);
                        intent.putExtra("author", " Alex Rutherford");
                        intent.putExtra("price", " ₹ 399.00");
                        intent.putExtra("language", " English");
                        intent.putExtra("publisher", " Headline Book Publishing;"+"\n"+"Latest Edition edition"+"\n"+"(7 January 2010)");
                        intent.putExtra("paperback", " 512 pages");
                        intent.putExtra("productcode", " #H0003");
                        intent.putExtra("dimension", " 11.2 x 17.7 x 3.4 cm");

                        mContext.startActivity(intent);
                    }


                    //code later
                    if (Historical_drawer.historical_arraylist.get(position).getName().equals("Padmavati: The Queen"+"\n"+"Tells Her Own Story."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext, Historical_Grid.class);
                        intent.putExtra("Bookname", "Padmavati: The Queen"+"\n"+"Tells Her Own Story.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image", R.drawable.padmavat);
                        intent.putExtra("author", " Sutapa Basu");
                        intent.putExtra("price", " ₹ 199.00");
                        intent.putExtra("language", " English");
                        intent.putExtra("publisher", " Readomania (2 December 2017)");
                        intent.putExtra("paperback", " 300 pages");
                        intent.putExtra("productcode", " #H0004");
                        intent.putExtra("dimension", " 19.6 x 13 x 2.4 cm");

                        mContext.startActivity(intent);
                    }


                    //code later
                    if (Historical_drawer.historical_arraylist.get(position).getName().equals("Prithviraj Chauhan:"+"\n"+"The Emperor of Hearts."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext, Historical_Grid.class);
                        intent.putExtra("Bookname", "Prithviraj Chauhan:"+"\n"+"The Emperor of Hearts.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image", R.drawable.prithviraj_chauhan);
                        intent.putExtra("author", " Anuja Chandramouli");
                        intent.putExtra("price", " ₹ 169.00");
                        intent.putExtra("language", " English");
                        intent.putExtra("publisher", " Ebury Press (23 November 2017)");
                        intent.putExtra("paperback", " 288 pages");
                        intent.putExtra("productcode", " #H0005");
                        intent.putExtra("dimension", " 20.2 x 13 x 3.2 cm");

                        mContext.startActivity(intent);
                    }


                    if (Historical_drawer.historical_arraylist.get(position).getName().equals("   War & Peace."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext, Historical_Grid.class);
                        intent.putExtra("Bookname", "  War & Peace.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image", R.drawable.war_peace);
                        intent.putExtra("author", " Leo Tolstoy");
                        intent.putExtra("price", " ₹ 299.00");
                        intent.putExtra("language", " English");
                        intent.putExtra("publisher", " Fingerprint! Publishing;"+"\n"+"Latest edition (1 April 2015)");
                        intent.putExtra("paperback", " 1232 pages");
                        intent.putExtra("productcode", " #H0006");
                        intent.putExtra("dimension", " 14 x 21.6 cm");

                        mContext.startActivity(intent);
                    }

                }
            });

            return convertView;
        }
        // Filter Class
        public void filter(String charText)
        {
            charText = charText.toLowerCase(Locale.getDefault());

            Historical_drawer.historical_arraylist.clear();

            if(charText.length() == 0)
            {
                Historical_drawer.historical_arraylist.addAll(arraylist);
            }
            else
            {
                for (Books wp : arraylist)
                {
                    if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText))
                    {
                        Historical_drawer.historical_arraylist.add(wp);
                    }
                }
            }

            notifyDataSetChanged();
        }

    }//end of custom adapter
}