package com.wahab.books_junction;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomListSSCAdapter extends BaseAdapter

{

        // Declare Variables
        Context mContext;
        LayoutInflater inflater;
        private List<Books> worldpopulationlist = null;
        private ArrayList<Books> booksssss;



        public CustomListSSCAdapter(Context context, List<Books> sscbooks)
        {
            this.mContext = context;
            this.worldpopulationlist = sscbooks;

            inflater = LayoutInflater.from(mContext);

            this.booksssss = new ArrayList<Books>();
            this.booksssss.addAll(worldpopulationlist);
        }



    public class ViewHolder
        {
            TextView rank;
            ImageView flag;
        }

        @Override
        public int getCount() {
            return worldpopulationlist.size();
        }

        @Override
        public Object getItem(int position)
        {
            return worldpopulationlist.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(final int position, View view, ViewGroup parent)
        {
             final ViewHolder holder;

            if (view == null)
            {
                holder = new ViewHolder();

                view = inflater.inflate(R.layout.activity_adapter_activity, null);

                // Locate the TextViews in listview_item.xml
                holder.rank = (TextView) view.findViewById(R.id.bookname);

                // Locate the ImageView in listview_item.xml
                holder.flag = (ImageView) view.findViewById(R.id.bookimage);

                view.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) view.getTag();
            }
            // Set the results into TextViews
            holder.rank.setText(worldpopulationlist.get(position).getName());

            // Set the results into ImageView
            holder.flag.setImageResource(worldpopulationlist.get(position).getImg());


            /*view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)

                {
                    Intent j = new Intent(mContext, SSC_AddToBag_list.class);

                    j.putExtra("imagessc", bookpicssc[position]);

                    j.putExtra("namessc", bookssc[position]);

                    j.putExtra("authorssc", bookauthorssc[position]);
                    j.putExtra("pricessc", bookpricessc[position]);
                    j.putExtra("languagessc", languagebookssc[position]);
                    j.putExtra("publisherssc", publisherssc[position]);
                    j.putExtra("paperbackssc", paperbackssc[position]);
                    j.putExtra("codessc", codelistssc[position]);
                    j.putExtra("dimensionssc", dimensionssc[position]);

                    mContext.startActivity(j);
                }
            });*/
            return view;
        }


        // Filter Class
        public void filter(String charText)
        {
            charText = charText.toLowerCase(Locale.getDefault());
            worldpopulationlist.clear();

            if (charText.length() == 0)
            {
                worldpopulationlist.addAll(booksssss);
            }
            else
            {
                for (Books wp : booksssss)
                {
                    if (wp.getName().toLowerCase(Locale.getDefault())
                            .contains(charText))
                    {
                        worldpopulationlist.add(wp);
                    }
                }
            }
            notifyDataSetChanged();
        }

    }//end of CustomAdapter

