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
import java.util.Locale;


public class BlankFragment111_12th extends Fragment implements SearchView.OnQueryTextListener

{
    private ListView listView;
    // Declare Variables
    private CustomListAdapter adapter;

    private SearchView editsearch;

    public static ArrayList<Books> arraylist = new ArrayList<Books>();


    String[] bookname_science_twelveth={"Chemistry Papers with Solution","Perfect Mathematics-2"+"\n"+"Notes.","Physics Paper Solutions","English Yuvakbharati","TPS Computer Science-1"};

    int[] bookimg_science_twelveth={R.drawable.uttam_chemistry_science12th , R.drawable.science_maths_12th , R.drawable.physics_uttam_12th_science , R.drawable.english_science_12th , R.drawable.computer_science_1_12th};

    String[] book_price={"₹ 225.00","₹ 280.00","₹ 225.00","₹ 279.00","₹ 144.00"};

    String[] book_author={" Mr. Uttam ","Mr.Vinodkumar Pandey"," Uttam ","Ms. Sweety Sharma","Shweta Jawale"};

    String[] book_pages={"234 pages","432 pages","268 pages","360 pages","300 pages"};

    String[]  book_language={"English","English","English","English","English"};

    String[] book_publisher={"Noble Publishing"+"\n"+"House (2018)","Target Publications Pvt"+"\n"+"Ltd.;2018 edition(2018)","Noble Publishing"+"\n"+"House (2018)","Target Publications Pvt."+"\n"+"Ltd.;Second edition(2018)","Kinnari Prakashan"+"\n"+"(2017)"};

    String[] book_dimension={"2 x 3 x 3 cm","28 x 20.4 x 1.8 cm","2 x 2 x 2 cm","28 x 20.2 x 1.7 cm","24.2 x 18.3 x 1.5 cm"};

    String[] book_code={"#12TH_SCIENCE01","#12TH_SCIENCE02","#12TH_SCIENCE03","#12TH_SCIENCE04","#12TH_SCIENCE05"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)

    {

        View view=inflater.inflate(R.layout.fragment_blank_fragment111_12th, container, false);

        listView=(ListView)view.findViewById(R.id.listview_twelveth_science);

        //  listView.setAdapter(adapter);
        arraylist = new ArrayList<>();

        for (int i = 0; i < bookname_science_twelveth.length; i++)
        {
            Books movieNames = new Books(bookname_science_twelveth[i],bookimg_science_twelveth[i]);
            // Binds all strings into an array
            arraylist.add(movieNames);
        }


        adapter=new CustomListAdapter(view.getContext());

        listView.setAdapter(adapter);


        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) view.findViewById(R.id.search_view_twelveth_sci);

        //editsearch.setOnClickListener((View.OnClickListener) this);

        editsearch.setOnQueryTextListener(this);

        editsearch.setIconifiedByDefault(false);
        // editsearch.setSubmitButtonEnabled(true);
        editsearch.setQueryHint("Search Here...");



        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent j=new Intent(getActivity(),twelveth_addtobag_science.class);

                j.putExtra("image_sci_twelveth",bookimg_science_twelveth[position]);
                j.putExtra("name_sci_twelveth",bookname_science_twelveth[position]);
                j.putExtra("author_sci_twelveth",book_author[position]);
                j.putExtra("price_sci_twelveth",book_price[position]);
                j.putExtra("language_sci_twelveth",book_language[position]);
                j.putExtra("publisher_sci_twelveth",book_publisher[position]);
                j.putExtra("paperback_sci_twelveth",book_pages[position]);
                j.putExtra("code_sci_twelveth",book_code[position]);
                j.putExtra("dimension_sci_twelveth",book_dimension[position]);

                startActivity(j);
            }
        });*/

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
        private ArrayList<Books> arraylist;  //done


        public CustomListAdapter(Context context)
        {

            mContext=context;
            inflater = LayoutInflater.from(mContext);

            this.arraylist = new ArrayList<Books>();

            this.arraylist.addAll(BlankFragment111_12th.arraylist);
        }

        public class ViewHolder
        {
            TextView name;
            ImageView image;
        }


        @Override
        public int getCount()
        {
            return BlankFragment111_12th.arraylist.size();
        }

        @Override
        public Object getItem(int position)
        {
            return BlankFragment111_12th.arraylist.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent)
        {
            //View list;
            //LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            final ViewHolder holder;

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
            holder.name.setText(BlankFragment111_12th.arraylist.get(position).getName());
            //set the result in imageview
            holder.image.setImageResource(BlankFragment111_12th.arraylist.get(position).getImg());




            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent j=new Intent(mContext,twelveth_addtobag_science.class);

                    j.putExtra("image_sci_twelveth",bookimg_science_twelveth[position]);
                    j.putExtra("name_sci_twelveth",bookname_science_twelveth[position]);
                    j.putExtra("author_sci_twelveth",book_author[position]);
                    j.putExtra("price_sci_twelveth",book_price[position]);
                    j.putExtra("language_sci_twelveth",book_language[position]);
                    j.putExtra("publisher_sci_twelveth",book_publisher[position]);
                    j.putExtra("paperback_sci_twelveth",book_pages[position]);
                    j.putExtra("code_sci_twelveth",book_code[position]);
                    j.putExtra("dimension_sci_twelveth",book_dimension[position]);

                    mContext.startActivity(j);

                }
            });


            return convertView;
        }

        // Filter Class
        public void filter(String charText)

        {
            charText = charText.toLowerCase(Locale.getDefault());

            BlankFragment111_12th.arraylist.clear();

            if (charText.length() == 0)
            {
                BlankFragment111_12th.arraylist.addAll(arraylist);
            }
            else
            {
                for (Books twel : arraylist)
                {
                    if (twel.getName().toLowerCase(Locale.getDefault()).contains(charText))
                    {
                        BlankFragment111_12th.arraylist.add(twel);
                    }
                }
            }
            notifyDataSetChanged();
        }

    }  //custom adapter ends
}