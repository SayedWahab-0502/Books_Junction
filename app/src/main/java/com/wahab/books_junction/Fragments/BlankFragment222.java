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
import com.wahab.books_junction.Activities.eleventh_commerce_addtobag;

import java.util.ArrayList;
import java.util.Locale;


public class BlankFragment222 extends Fragment implements SearchView.OnQueryTextListener

{

    private ListView listView;

    // Declare Variables
    private CustomListAdapter adapter;

    private SearchView editsearchele;

    public static ArrayList<Books> eleventh_arraylist = new ArrayList<Books>();;



    String[] book_name_commerce = {"Secretarial Practice Notes.",
            "Organization of Commerce"+"\n"+"and Management Notes.","Information Technology.",
            "Economics Notes.","Book Keeping & Accountancy Notes."};

    int[] book_pic_commerce={R.drawable.secretarial_practice_commerce11th,R.drawable.organization_commerce_11th,R.drawable.maths_commerce11th,R.drawable.economic_commerce11th,R.drawable.book_keeping_commerce11th};


    String bookauthor[]={"Ms. Toral Juthani","Ms. Toral Juthani","Sharad Chilbule","Ms. Urvi Mehta","Ms. Toral Juthani"};

    String bookprice[]={"₹ 190.00","₹ 200.00","₹ 110.00","₹ 185.00","₹ 266.00"};

    String booklanguage[]={"English","English","English","English","English"};

    String bookdimension[]={"27.6 x 20.2 x 1 cm","27.7 x 20.3 x 1.1 cm","25 x 18 x 1 cm","27.7 x 20.4 x 1.2 cm","27.7 x 20.5 x 1.5 cm"};

    String bookpages[]={"233 pages","310 pages","250 pages","190 pages","499 pages"};

    String bookcode[]={"#11thCOMMERCE(01)","#11thCOMMERCE(02)","#11thCOMMERCE(03)","#11thCOMMERCE(04)","#11thCOMMERCE(05)"};

    String bookpublisher[]={"Target Publications Pvt."+"\n"+"Ltd.;2018 edition(2017)","Target Publications Pvt."+"\n"+"Ltd.;2018 edition(2017)","Maharashtra Prakashan (2018)","Target Publications Pvt."+"\n"+"Ltd.;2018 edition(2017)","Target Publications Pvt."+"\n"+"Ltd.;2018 edition(2018)"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {

        View view=inflater.inflate(R.layout.fragment_blank_fragment222, container, false);

        listView=(ListView)view.findViewById(R.id.listview_eleventh_commerce);

        //  listView.setAdapter(adapter);
        eleventh_arraylist = new ArrayList<>();

        for (int i = 0; i < book_name_commerce.length; i++)
        {
            Books movieNames = new Books(book_name_commerce[i],book_pic_commerce[i]);
            // Binds all strings into an array
            eleventh_arraylist.add(movieNames);
        }


        adapter=new CustomListAdapter(view.getContext());

        listView.setAdapter(adapter);



        // Locate the EditText in listview_main.xml
        editsearchele = (SearchView) view.findViewById(R.id.search_view_elecommerce);

        //editsearch.setOnClickListener((View.OnClickListener) this);

        editsearchele.setOnQueryTextListener(this);

        editsearchele.setIconifiedByDefault(false);
        // editsearch.setSubmitButtonEnabled(true);
        editsearchele.setQueryHint("Search Here...");


        CustomListAdapter adapter=new CustomListAdapter(view.getContext());
        listView.setAdapter(adapter);



       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent j=new Intent(getActivity(),eleventh_commerce_addtobag.class);

                j.putExtra("image_com_eleventh",book_pic_commerce[position]);
                j.putExtra("name_com_eleventh",book_name_commerce[position]);
                j.putExtra("author_com_eleventh",bookauthor[position]);
                j.putExtra("price_com_eleventh",bookprice[position]);
                j.putExtra("language_com_eleventh",booklanguage[position]);
                j.putExtra("publisher_com_eleventh",bookpublisher[position]);
                j.putExtra("paperback_com_eleventh",bookpages[position]);
                j.putExtra("code_com_eleventh",bookcode[position]);
                j.putExtra("dimension_com_eleventh",bookdimension[position]);

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
    public boolean onQueryTextChange(String newText) {

        String text = newText;
        adapter.filterele(text);
        return true;
    }


    public class  CustomListAdapter extends BaseAdapter
    {

        private Context mContext;
        LayoutInflater inflater;
        private ArrayList<Books> arraylistele;  //done


        public CustomListAdapter(Context context)
        {
            mContext=context;

            inflater = LayoutInflater.from(mContext);

            this.arraylistele = new ArrayList<Books>();

            this.arraylistele.addAll(BlankFragment222.eleventh_arraylist);

        }

        public class ViewHolder
        {
            TextView elename;
            ImageView eleimage;
        }

        @Override
        public int getCount()
        {
            return BlankFragment222.eleventh_arraylist.size();
        }

        @Override
        public Object getItem(int position)
        {
            return BlankFragment222.eleventh_arraylist.get(position);
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
            //LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


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
            holder.elename.setText(BlankFragment222.eleventh_arraylist.get(position).getName());
            //set the result in imageview
            holder.eleimage.setImageResource(BlankFragment222.eleventh_arraylist.get(position).getImg());



            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent j=new Intent(mContext, eleventh_commerce_addtobag.class);

                    j.putExtra("image_com_eleventh",book_pic_commerce[position]);
                    j.putExtra("name_com_eleventh",book_name_commerce[position]);
                    j.putExtra("author_com_eleventh",bookauthor[position]);
                    j.putExtra("price_com_eleventh",bookprice[position]);
                    j.putExtra("language_com_eleventh",booklanguage[position]);
                    j.putExtra("publisher_com_eleventh",bookpublisher[position]);
                    j.putExtra("paperback_com_eleventh",bookpages[position]);
                    j.putExtra("code_com_eleventh",bookcode[position]);
                    j.putExtra("dimension_com_eleventh",bookdimension[position]);

                    startActivity(j);
                }
            });



            return convertView;
        }



        // Filter Class
        public void filterele(String charText)

        {
            charText = charText.toLowerCase(Locale.getDefault());

            BlankFragment222.eleventh_arraylist.clear();

            if (charText.length() == 0)
            {
                BlankFragment222.eleventh_arraylist.addAll(arraylistele);
            }
            else
            {
                for (Books ele : arraylistele)
                {
                    if (ele.getName().toLowerCase(Locale.getDefault()).contains(charText))
                    {
                        BlankFragment222.eleventh_arraylist.add(ele);
                    }
                }
            }
            notifyDataSetChanged();
        }

    }  //end of custom adapter
}