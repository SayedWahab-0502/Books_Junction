package com.wahab.books_junction.Fragments.DrawerClass;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.wahab.books_junction.HelperClasses.Books;
import com.wahab.books_junction.Activities.Novel_List;
import com.wahab.books_junction.R;

import java.util.ArrayList;
import java.util.Locale;


public class Novel_drawer extends Fragment implements SearchView.OnQueryTextListener
{

    // Declare Variables
    private CustomListAdapter adapter;

    private SearchView editsearch;

    public static ArrayList<Books> novels_arraylist = new ArrayList<Books>();

    private ListView listView;  //listview=list


    String bookname[]={"Wings of Fire.","Life is What You Make It.","Think and Grow Rich.","The Power of your Subconscious Mind.","Be My Perfect Ending."};

    int bookimage[]={R.drawable.wings_of_fire,R.drawable.life_is_what,R.drawable.think_grow_rich,R.drawable.power_of_mind,R.drawable.the_perfect_ending};

    String bookauthor[]={" A. P. J. Abdul Kalam"," Preeti Shenoy "," Napoleon Hill"," Joseph Murphy"," Arpit Vageria"};

    String bookprice[]={"₹ 99.00","₹ 150.00","₹ 110.00","₹ 120.00","₹ 174.00"};

    String languagebook[]={"English","English","English","English","English"};

    String paperbacklist[]={"180 pages","226 pages","250 pages","312 pages","200 pages"};

    String codelist[]={"#N0001","#N0002","#N0003","#N0004","#N0005"};

    String publishernovel[]={"Universities Press;"+"\n"+"1st edition (1999)","Srishti Publishers;"+"\n"+"1 edition (1 January 2011)","Amazing Reads"+"\n"+"(1 January 2014)","Amazing Reads"+"\n"+"(1 December 2015)","Srishti Publishers;"+"\n"+"First edition (28 December 2017)"};

    String dimensionnovel[] ={"15.9 x 1.1 x 23.9 cm","13 x 1.3 x 19.7 cm","19.7 x 13 x 2.2 cm","20 x 13 x 1.5 cm","13 x 1.2 x 19.7 cm"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {

        View view=inflater.inflate(R.layout.fragment_novel_drawer, container, false);

        listView=(ListView)view.findViewById(R.id.listview_novel);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) view.findViewById(R.id.search_view_novel);

        novels_arraylist = new ArrayList<>();

        for (int i = 0; i < bookname.length; i++)
        {
            Books movieNames = new Books(bookname[i],bookimage[i]);
            // Binds all strings into an array
            novels_arraylist.add(movieNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new CustomListAdapter(view.getContext());

        // Binds the Adapter to the ListView
        listView.setAdapter(adapter);

        editsearch.setOnQueryTextListener(this);

        editsearch.setQueryHint("Search Here...");



        return view;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return true;
    }

    public class CustomListAdapter extends BaseAdapter
    {

        private Context mContext;
        LayoutInflater inflater;
        private ArrayList<Books> arraylist;

        public CustomListAdapter(Context context)
        {
            mContext=context;
            inflater = LayoutInflater.from(mContext);
            this.arraylist = new ArrayList<Books>();
            this.arraylist.addAll(Novel_drawer.novels_arraylist);

        }
        public class ViewHolder
        {
            TextView novelname;
            ImageView novelimage;
        }

        @Override
        public int getCount() {
            return Novel_drawer.novels_arraylist.size();
        }

        @Override
        public Object getItem(int position) {
            return Novel_drawer.novels_arraylist.get(position);
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
                convertView=inflater.inflate(R.layout.activity_adapter_activity,null);
                holder = new ViewHolder();

                // Locate the TextViews in listview_item.xml
                holder.novelname = (TextView) convertView.findViewById(R.id.bookname);
                holder.novelimage = (ImageView) convertView.findViewById(R.id.bookimage);

                convertView.setTag(holder);
            }

            else
                {
                    holder =(ViewHolder)convertView.getTag();
            }
            //set the results into textviews
            holder.novelname.setText(Novel_drawer.novels_arraylist.get(position).getName());
            //set the result in imageview
            holder.novelimage.setImageResource(Novel_drawer.novels_arraylist.get(position).getImg());


            convertView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {

                    if (Novel_drawer.novels_arraylist.get(position).getName().equals("Wings of Fire."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext, Novel_List.class);
                        intent.putExtra("Bookname", "Wings of Fire.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image",R.drawable.wings_of_fire);
                        intent.putExtra("author"," A. P. J. Abdul Kalam");
                        intent.putExtra("price","₹ 99.00");
                        intent.putExtra("language","English");
                        intent.putExtra("publisher","Universities Press;"+"\n"+"1st edition (1999)");
                        intent.putExtra("paperback","180 pages");
                        intent.putExtra("codeno","#N0001");
                        intent.putExtra("dimension","15.9 x 1.1 x 23.9 cm");

                        mContext.startActivity(intent);
                    }

                    if (Novel_drawer.novels_arraylist.get(position).getName().equals("Life is What You Make It."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext,Novel_List.class);
                        intent.putExtra("Bookname", "Life is What You Make It.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image",R.drawable.life_is_what);
                        intent.putExtra("author"," Preeti Shenoy ");
                        intent.putExtra("price","₹ 150.00");
                        intent.putExtra("language","English");
                        intent.putExtra("publisher","Srishti Publishers;"+"\n"+"1 edition (1 January 2011)");
                        intent.putExtra("paperback","226 pages");
                        intent.putExtra("codeno","#N0002");
                        intent.putExtra("dimension","13 x 1.3 x 19.7 cm");

                        mContext.startActivity(intent);
                    }


                    if (Novel_drawer.novels_arraylist.get(position).getName().equals("Think and Grow Rich."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext,Novel_List.class);
                        intent.putExtra("Bookname", "Think and Grow Rich.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image",R.drawable.think_grow_rich);
                        intent.putExtra("author"," Napoleon Hill");
                        intent.putExtra("price","₹ 110.00");
                        intent.putExtra("language","English");
                        intent.putExtra("publisher","Amazing Reads"+"\n"+"(1 January 2014)");
                        intent.putExtra("paperback","250 pages");
                        intent.putExtra("codeno","#N0003");
                        intent.putExtra("dimension","19.7 x 13 x 2.2 cm");

                        mContext.startActivity(intent);
                    }

                    if (Novel_drawer.novels_arraylist.get(position).getName().equals("The Power of your Subconscious Mind."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext,Novel_List.class);
                        intent.putExtra("Bookname", "The Power of your Subconscious Mind.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image",R.drawable.power_of_mind);
                        intent.putExtra("author"," Joseph Murphy");
                        intent.putExtra("price","₹ 120.00");
                        intent.putExtra("language","English");
                        intent.putExtra("publisher","Amazing Reads"+"\n"+"(1 December 2015)");
                        intent.putExtra("paperback","312 pages");
                        intent.putExtra("codeno","#N0004");
                        intent.putExtra("dimension","20 x 13 x 1.5 cm");

                        mContext.startActivity(intent);
                    }

                    if (Novel_drawer.novels_arraylist.get(position).getName().equals("Be My Perfect Ending."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext,Novel_List.class);
                        intent.putExtra("Bookname", "Be My Perfect Ending.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image",R.drawable.the_perfect_ending);
                        intent.putExtra("author"," Arpit Vageria");
                        intent.putExtra("price","₹ 174.00");
                        intent.putExtra("language","English");
                        intent.putExtra("publisher","Srishti Publishers;"+"\n"+"First edition (28 December 2017)");
                        intent.putExtra("paperback","200 pages");
                        intent.putExtra("codeno","#N0005");
                        intent.putExtra("dimension","13 x 1.2 x 19.7 cm");

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

            Novel_drawer.novels_arraylist.clear();

            if (charText.length() == 0)
            {
                Novel_drawer.novels_arraylist.addAll(arraylist);
            }
            else
            {
                for (Books wp : arraylist)
                {
                    if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText))
                    {
                        Novel_drawer.novels_arraylist.add(wp);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }//end of customadapter
}