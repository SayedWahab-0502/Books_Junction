package com.wahab.books_junction.Fragments;

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
import com.wahab.books_junction.R;
import com.wahab.books_junction.Activities.twelveth_addtobag_commerce;

import java.util.ArrayList;
import java.util.Locale;


public class BlankFragment222_12th extends Fragment implements SearchView.OnQueryTextListener

{
    private ListView listView;
    // Declare Variables
    private CustomListAdapter adapter;

    private SearchView editsearch;

    public static ArrayList<Books> arraylist = new ArrayList<Books>();


    String[] bookname_commerce_twelveth={"Organisation of Commerce"+"\n"+"& Management.","Mathematics and Statistics-1","Economics Notes,Commerce","Secretarial Practice Notes","Book Keeping and Accountancy"};

    int[] bookimg_commerce_twelveth={R.drawable.uttam_organization_12th,R.drawable.maths_12th_commerce,R.drawable.economic_commerce12th,R.drawable.sp_commerce_12th,R.drawable.book_keeping_12th};

    String[] book_price={"₹ 150.00","₹ 247.50","₹ 220.00","₹ 189.00","₹ 297.50"};

    String[] book_author={"Uttam ","Mr. Vinod Singh"," Ms. Toral Juthani","Ms. Urvi Mehta","Ms.Toral Juthani"};

    String[] book_pages={"200 pages","255 pages","322 pages","232 pages","300 pages"};

    String[]  book_language={"English","English","English","English","English"};

    String[] book_publisher={"Noble Publishing"+"\n"+"House (2018)","Target Publications Pvt"+"\n"+"Ltd.;2018 edition(2018)","Target Publications Pvt"+"\n"+"Ltd.;2018 edition(2017)","Target Publications Pvt"+"\n"+"Ltd.;2018 edition(2017)","Target Publications Pvt"+"\n"+"Ltd.;2018 edition(2018)"};

    String[] book_dimension={"2 x 2 x 2 cm","27.8 x 20.4 x 1.7 cm","28 x 20.3 x 1.3 cm","28 x 20.5 x 1.2 cm","27.7 x 20.3 x 2 cm"};

    String[] book_code={"#12TH_COMMERCE01","#12TH_COMMERCE02","#12TH_COMMERCE03","#12TH_COMMERCE04","#12TH_COMMERCE05"};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {

        View view=inflater.inflate(R.layout.fragment_blank_fragment222_12th, container, false);

        listView=(ListView)view.findViewById(R.id.listview_twelveth_commerce);


        //  listView.setAdapter(adapter);
        arraylist = new ArrayList<>();

        for (int i = 0; i < bookname_commerce_twelveth.length; i++)
        {
            Books movieNames = new Books(bookname_commerce_twelveth[i],bookimg_commerce_twelveth[i]);
            // Binds all strings into an array
            arraylist.add(movieNames);
        }


        adapter=new CustomListAdapter(view.getContext());

        listView.setAdapter(adapter);


        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) view.findViewById(R.id.search_view_twelveth_com);

        //editsearch.setOnClickListener((View.OnClickListener) this);

        editsearch.setOnQueryTextListener(this);

        editsearch.setIconifiedByDefault(false);
        // editsearch.setSubmitButtonEnabled(true);
        editsearch.setQueryHint("Search Here...");



       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                Intent j=new Intent(getActivity(),twelveth_addtobag_commerce.class);
                j.putExtra("image_com_twelveth",bookimg_commerce_twelveth[position]);
                j.putExtra("name_com_twelveth",bookname_commerce_twelveth[position]);
                j.putExtra("author_com_twelveth",book_author[position]);
                j.putExtra("price_com_twelveth",book_price[position]);
                j.putExtra("language_com_twelveth",book_language[position]);
                j.putExtra("publisher_com_twelveth",book_publisher[position]);
                j.putExtra("paperback_com_twelveth",book_pages[position]);
                j.putExtra("code_com_twelveth",book_code[position]);
                j.putExtra("dimension_com_twelveth",book_dimension[position]);
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
        private ArrayList<Books> arraylist;


        public CustomListAdapter(Context context)
        {

            mContext=context;

            inflater = LayoutInflater.from(mContext);

            this.arraylist = new ArrayList<Books>();

            this.arraylist.addAll(BlankFragment222_12th.arraylist);

        }

        public class ViewHolder
        {
            TextView name;
            ImageView image;
        }

        @Override
        public int getCount() {
            return BlankFragment222_12th.arraylist.size();
        }

        @Override
        public Object getItem(int position) {
            return BlankFragment222_12th.arraylist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent)
        {

            //View list;
            //LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
            holder.name.setText(BlankFragment222_12th.arraylist.get(position).getName());
            //set the result in imageview
            holder.image.setImageResource(BlankFragment222_12th.arraylist.get(position).getImg());




            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent j=new Intent(mContext, twelveth_addtobag_commerce.class);

                    j.putExtra("image_com_twelveth",bookimg_commerce_twelveth[position]);
                    j.putExtra("name_com_twelveth",bookname_commerce_twelveth[position]);
                    j.putExtra("author_com_twelveth",book_author[position]);
                    j.putExtra("price_com_twelveth",book_price[position]);
                    j.putExtra("language_com_twelveth",book_language[position]);
                    j.putExtra("publisher_com_twelveth",book_publisher[position]);
                    j.putExtra("paperback_com_twelveth",book_pages[position]);
                    j.putExtra("code_com_twelveth",book_code[position]);
                    j.putExtra("dimension_com_twelveth",book_dimension[position]);

                    mContext.startActivity(j);

                }
            });


            return convertView;

        }


        // Filter Class
        public void filter(String charText)

        {
            charText = charText.toLowerCase(Locale.getDefault());

            BlankFragment222_12th.arraylist.clear();

            if (charText.length() == 0)
            {
                BlankFragment222_12th.arraylist.addAll(arraylist);
            }
            else
            {
                for (Books twel : arraylist)
                {
                    if (twel.getName().toLowerCase(Locale.getDefault()).contains(charText))
                    {
                        BlankFragment222_12th.arraylist.add(twel);
                    }
                }
            }
            notifyDataSetChanged();
        }

    }  //Custom Adapter Ends

}
