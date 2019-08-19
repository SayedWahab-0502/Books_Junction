package com.wahab.books_junction;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Story_drawer extends Fragment implements SearchView.OnQueryTextListener

{
    // Declare Variables
    private CustomListAdapter adapter;

    private SearchView editsearch;

    public static ArrayList<Books> story_arraylist;

   private ListView listView;  //listview=list

    String bookname[]= {"The Best of Panchatantra.","Alibaba Aur Chalis Chor.","The Jungle Book.","The Best of Tenali Raman.","The Best of Akbar and Birbal."};

    int bookpic[] ={R.drawable.panchatantra,R.drawable.alibaba_40chor,R.drawable.thejungle_book,R.drawable.tanalirama,R.drawable.akbarbirbal};

    //String bookauthor[] ={"Rungeen Singh","Maple Press","Rudyard Kipling","Rungeen Singh","Rungeen Singh"};
   // String bookprice[] ={"₹ 69.00","₹ 150.00","₹ 99.00","₹ 110.00","₹ 59.00"};
   // String languagebook[]={"English","Hindi","English","English","English"};
  // String codelist[]={"#SB0001","#SB0002","#SB0003","#SB0004","#SB0005"};
  // String publisherstory[]={"Young Learner Publications"+"\n"+"(1 October 2011)"," Maple Press (2013)","Fingerprint! Publishing;"+"\n"+"First edition (2012)","Young Learner Publications;"+"\n"+"1 edition (1 October 2011)","Young Learner Publications"+"\n"+"(1 October 2011)"};
   // String paperbackstory[]={"160 pages","170 pages","200 pages","160 pages","180 pages"};
  // String dimensionstory[]={"17.9 x 11.8 x 1.5 cm","23 x 15.2 x 0.4 cm","21.5 x 13.9 x 2 cm"," 18 x 12.2 x 2.2 cm","18 x 11.7 x 0.5 cm"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)

    {
        View view = inflater.inflate(R.layout.fragment_story_drawer,container,false);
        listView=(ListView)view.findViewById(R.id.listview_story);

      //  listView.setAdapter(adapter);
        story_arraylist = new ArrayList<Books>();

        for (int i = 0; i < bookname.length; i++)
        {
            Books movieNames = new Books(bookname[i],bookpic[i]);
            // Binds all strings into an array
            story_arraylist.add(movieNames);
        }

        // Pass results to ListViewAdapter Class
        adapter=new CustomListAdapter(view.getContext());

        // Binds the Adapter to the ListView
        listView.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) view.findViewById(R.id.search_view_story);

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
        // this is your adapter that will be filtered
        //listAdapter.getFilter().filter(query)
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText)
    {
        String text = newText;
        adapter.filter(text);
        return true;
    }

    public class CustomListAdapter extends BaseAdapter
    {
       private Context mContext;
        LayoutInflater inflater;
        private ArrayList<Books> arraylist;  //done

        public CustomListAdapter(Context context)

        {
            mContext=context;
            inflater = LayoutInflater.from(mContext);

            this.arraylist = new ArrayList<Books>();

            this.arraylist.addAll(Story_drawer.story_arraylist);

        }


    public class ViewHolder
    {
        TextView name;
        ImageView image;
    }

        @Override
        public int getCount()
        {
            return Story_drawer.story_arraylist.size();
        }

        @Override
        public Object getItem(int position)
        {
            return Story_drawer.story_arraylist.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent)
        {
            final ViewHolder holder;
           // LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView=null;

            if (convertView == null)
            {

                holder = new ViewHolder();
                convertView=inflater.inflate(R.layout.activity_adapter_activity,null);

                // Locate the TextViews in listview_item.xml
                holder.name = (TextView) convertView.findViewById(R.id.bookname);
                holder.image = (ImageView) convertView.findViewById(R.id.bookimage);
                convertView.setTag(holder);
            }

            else
                {
                holder = (ViewHolder)convertView.getTag();
            }

            //set the results into textviews
            holder.name.setText(Story_drawer.story_arraylist.get(position).getName());
            //set the result in imageview
            holder.image.setImageResource(Story_drawer.story_arraylist.get(position).getImg());


            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {

                    //code later
                    if (Story_drawer.story_arraylist.get(position).getName().equals("The Best of Panchatantra.")){
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext,Story_Book_List.class);
                        intent.putExtra("Bookname", "The Best of Panchatantra.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image",R.drawable.panchatantra);
                        intent.putExtra("author","Rungeen Singh");
                        intent.putExtra("price","₹ 69.00");
                        intent.putExtra("language","English");
                        intent.putExtra("publisher","Young Learner Publications"+"\n"+"(1 October 2011)");
                        intent.putExtra("paperback","160 pages");
                        intent.putExtra("code","#SB0001");
                        intent.putExtra("dimension","17.9 x 11.8 x 1.5 cm");

                        mContext.startActivity(intent);
                    }


                    //code later
                    if (Story_drawer.story_arraylist.get(position).getName().equals("Alibaba Aur Chalis Chor."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext,Story_Book_List.class);
                        intent.putExtra("Bookname", "Alibaba Aur Chalis Chor.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image",R.drawable.alibaba_40chor);
                        intent.putExtra("author","Maple Press");
                        intent.putExtra("price","₹ 150.00");
                        intent.putExtra("language","Hindi");
                        intent.putExtra("publisher","Maple Press (2013)");
                        intent.putExtra("paperback","170 pages");
                        intent.putExtra("code","#SB0002");
                        intent.putExtra("dimension","23 x 15.2 x 0.4 cm");

                        mContext.startActivity(intent);
                    }

                    if (Story_drawer.story_arraylist.get(position).getName().equals("The Jungle Book."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext,Story_Book_List.class);
                        intent.putExtra("Bookname", "The Jungle Book.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image",R.drawable.thejungle_book);
                        intent.putExtra("author","Rudyard Kipling");
                        intent.putExtra("price","₹ 99.00");
                        intent.putExtra("language","English");
                        intent.putExtra("publisher","Fingerprint! Publishing;"+"\n"+"First edition (2012)");
                        intent.putExtra("paperback","200 pages");
                        intent.putExtra("code","#SB0003");
                        intent.putExtra("dimension","21.5 x 13.9 x 2 cm");

                        mContext.startActivity(intent);
                    }
                    if (Story_drawer.story_arraylist.get(position).getName().equals("The Best of Tenali Raman."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext,Story_Book_List.class);
                        intent.putExtra("Bookname", "The Best of Tenali Raman.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image",R.drawable.tanalirama);
                        intent.putExtra("author","Rungeen Singh");
                        intent.putExtra("price","₹ 110.00");
                        intent.putExtra("language","English");
                        intent.putExtra("publisher","Young Learner Publications;"+"\n"+"1 edition (1 October 2011)");
                        intent.putExtra("paperback","160 pages");
                        intent.putExtra("code","#SB0004");
                        intent.putExtra("dimension"," 18 x 12.2 x 2.2 cm");

                        mContext.startActivity(intent);
                    }

                    if (Story_drawer.story_arraylist.get(position).getName().equals("The Best of Akbar and Birbal."))
                    {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mContext,Story_Book_List.class);
                        intent.putExtra("Bookname", "The Best of Akbar and Birbal.");
                        //intent.putExtra("contentTv", "This is Battery detail...");
                        intent.putExtra("image",R.drawable.akbarbirbal);
                        intent.putExtra("author","Rungeen Singh");
                        intent.putExtra("price","₹ 59.00");
                        intent.putExtra("language","English");
                        intent.putExtra("publisher","Young Learner Publications"+"\n"+"(1 October 2011)");
                        intent.putExtra("paperback","180 pages");
                        intent.putExtra("code","#SB0005");
                        intent.putExtra("dimension","18 x 11.7 x 0.5 cm");

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

            Story_drawer.story_arraylist.clear();

            if (charText.length() == 0)
            {
                Story_drawer.story_arraylist.addAll(arraylist);
            }
            else
                {
                for (Books wp : arraylist)
                {
                    if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText))
                    {
                        Story_drawer.story_arraylist.add(wp);
                    }
                }
            }
            notifyDataSetChanged();
        }
    } //end of CustomAdapter

    }