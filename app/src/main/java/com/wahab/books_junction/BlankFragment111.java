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


public class BlankFragment111 extends Fragment implements SearchView.OnQueryTextListener
{

   private ListView listView;
    // Declare Variables
    private CustomListAdapterele adapter;

    private SearchView editsearchele;

    public static ArrayList<Books> eleventh_arraylist = new ArrayList<Books>();


    String booknameeleventh[]= {"TPS Computer Science"+"\n"+"Paper-1 & 2","Physics Notes"+"\n"+",Science(MH Board)","Mathematics - 1 Notes"+"\n"+",Science(MH Board)","Chemistry - 2 Notes"+"\n"+",Science(MH Board)","Biology Notes Precise"+"\n"+",Science(MH Board)","TPS Information Technology"+"\n"+"Std.11th"};

    int bookpiceleventh[] ={R.drawable.computer_science_11th,R.drawable.physics_science_11th,R.drawable.maths_science11th,R.drawable.chemistry_science11th,R.drawable.biology_science_11th,R.drawable.information_system_science11th};


    String bookauthor[]={"Kinnari Prakashan","Mr. Collin Fernandes","Mr. Vikram Bathula","Prof. Anil Thomas Prof","Dr. Nikhila Gokhale Prof","Archana Raut"};

    String bookprice[]={"₹ 80.00","₹ 210.00","₹ 323.00 ","₹ 240.00","₹ 190.00","₹ 180.00"};

    String booklanguage[]={"English","English","English","English","English","English"};

    String bookdimension[]={"35.7 x 8 x 1.5 cm","27.7 x 20.4 x 1.3 cm","28 x 20 x 1.9 cm","27.7 x 20.3 x 1.5 cm","27.7 x 20.1 x 1.2 cm","24 x 18.4 x 1 cm"};

    String bookpages[]={"150 pages","180 pages","196 pages","349 pages","248 pages","299 pages"};

    String bookcode[]={"#11thSCIENCE(01)","#11thSCIENCE(02)","#11thSCIENCE(03)","#11thSCIENCE(04)","#11thSCIENCE(05)","#11thSCIENCE(06)"};

    String bookpublisher[]={"Kinnari Prakashan (2017)","Target Publications Pvt."+"\n"+"Ltd.;2018 edition(2017)","Target Publications Pvt."+"\n"+"Ltd.;2018 edition(2018)","Target Publications Pvt."+"\n"+"Ltd.;2018 edition(2018)","Target Publications Pvt."+"\n"+"Ltd.;2018 edition(2018)","Kinnari Prakashan (2017)"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)

    {

        View view=inflater.inflate(R.layout.fragment_blank_fragment111, container, false);
        listView=(ListView)view.findViewById(R.id.listview_eleventh_science);

        //  listView.setAdapter(adapter);
        eleventh_arraylist = new ArrayList<>();

        for (int i = 0; i < booknameeleventh.length; i++)
        {
            Books movieNames = new Books(booknameeleventh[i],bookpiceleventh[i]);
            // Binds all strings into an array
            eleventh_arraylist.add(movieNames);
        }


        adapter=new CustomListAdapterele(view.getContext());

        listView.setAdapter(adapter);



        // Locate the EditText in listview_main.xml
        editsearchele = (SearchView) view.findViewById(R.id.search_view_eleventh_science);

        //editsearch.setOnClickListener((View.OnClickListener) this);

        editsearchele.setOnQueryTextListener(this);

        editsearchele.setIconifiedByDefault(false);
        // editsearch.setSubmitButtonEnabled(true);
        editsearchele.setQueryHint("Search Here...");


        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent j=new Intent(getActivity(),eleventh_addtobag_science.class);

                j.putExtra("image_sci_eleventh",bookpiceleventh[position]);
                j.putExtra("name_sci_eleventh",booknameeleventh[position]);
                j.putExtra("author_sci_eleventh",bookauthor[position]);
                j.putExtra("price_sci_eleventh",bookprice[position]);
                j.putExtra("language_sci_eleventh",booklanguage[position]);
                j.putExtra("publisher_sci_eleventh",bookpublisher[position]);
                j.putExtra("paperback_sci_eleventh",bookpages[position]);
                j.putExtra("code_sci_eleventh",bookcode[position]);
                j.putExtra("dimension_sci_eleventh",bookdimension[position]);

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
        adapter.filterele(text);
        return true;
    }

    public class CustomListAdapterele extends BaseAdapter
    {

        private Context mContext;
        LayoutInflater inflater;
        private ArrayList<Books> arraylistele;  //done


        public CustomListAdapterele(Context context)
        {
            mContext=context;
            inflater = LayoutInflater.from(mContext);

            this.arraylistele = new ArrayList<Books>();

            this.arraylistele.addAll(BlankFragment111.eleventh_arraylist);
        }

        public class ViewHolder
        {
            TextView elename;
            ImageView eleimage;
        }


        @Override
        public int getCount()
        {
            return BlankFragment111.eleventh_arraylist.size();
        }

        @Override
        public Object getItem(int position)
        {
            return BlankFragment111.eleventh_arraylist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent)
        {
         //   View list;

           // LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            final ViewHolder holder;

            convertView=null;

            if (convertView == null)
            {
                holder = new ViewHolder();
                convertView=inflater.inflate(R.layout.activity_adapter_activity,null);

                // Locate the TextViews in listview_item.xml
                holder.elename = (TextView) convertView.findViewById(R.id.bookname);
                holder.eleimage = (ImageView) convertView.findViewById(R.id.bookimage);

                convertView.setTag(holder);

            }

            else
            {
                holder = (ViewHolder)convertView.getTag();
            }

            //set the results into textviews
            holder.elename.setText(BlankFragment111.eleventh_arraylist.get(position).getName());
            //set the result in imageview
            holder.eleimage.setImageResource(BlankFragment111.eleventh_arraylist.get(position).getImg());


            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent j=new Intent(mContext,eleventh_addtobag_science.class);

                    j.putExtra("image_sci_eleventh",bookpiceleventh[position]);
                    j.putExtra("name_sci_eleventh",booknameeleventh[position]);
                    j.putExtra("author_sci_eleventh",bookauthor[position]);
                    j.putExtra("price_sci_eleventh",bookprice[position]);
                    j.putExtra("language_sci_eleventh",booklanguage[position]);
                    j.putExtra("publisher_sci_eleventh",bookpublisher[position]);
                    j.putExtra("paperback_sci_eleventh",bookpages[position]);
                    j.putExtra("code_sci_eleventh",bookcode[position]);
                    j.putExtra("dimension_sci_eleventh",bookdimension[position]);

                    mContext.startActivity(j);

                }
            });


            return convertView;

        }


        // Filter Class
        public void filterele(String charText)

        {
            charText = charText.toLowerCase(Locale.getDefault());

            BlankFragment111.eleventh_arraylist.clear();

            if (charText.length() == 0)
            {
                BlankFragment111.eleventh_arraylist.addAll(arraylistele);
            }
            else
            {
                for (Books ele : arraylistele)
                {
                    if (ele.getName().toLowerCase(Locale.getDefault()).contains(charText))
                    {
                        BlankFragment111.eleventh_arraylist.add(ele);
                    }
                }
            }
            notifyDataSetChanged();
        }

    }   //end of CustomAdapter

}
