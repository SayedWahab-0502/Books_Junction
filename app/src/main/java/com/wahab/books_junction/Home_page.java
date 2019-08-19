package com.wahab.books_junction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;


public class Home_page extends Fragment
{

    private ArrayList<Books_Home> arrayList, arrayList2, arrayList3, arrayList4, arrayList5;

    ViewFlipper viewFlipper;
    RecyclerView MyRecyclerView, MyRecyclerView2, MyRecyclerView3, MyRecyclerView4, MyRecyclerView5;

    Animation fade_in, fade_out;
    int images[] = {R.drawable.book2, R.drawable.bookss1, R.drawable.books3};

    String Book_Price[] = {"Price :-₹396.00", "Price :-₹190.00", "Price :-₹80.00", "Price :-₹210.00", "Price :-₹225.00"};
    int Images_Books[] = {R.drawable.marathi_ssc, R.drawable.biology_science_11th, R.drawable.computer_science_11th, R.drawable.physics_science_11th, R.drawable.uttam_chemistry_science12th};


    String bookprice_story[] = {"Price :-₹69.00", "Price :-₹150.00", "Price :-₹99.00", "Price :-₹110.00", "Price :-₹59.00"};
    int bookpic_story[] = {R.drawable.panchatantra, R.drawable.alibaba_40chor, R.drawable.thejungle_book, R.drawable.tanalirama, R.drawable.akbarbirbal};


    String bookprice_novel[] = {"Price :-₹99.00", "Price :-₹150.00", "Price :-₹110.00", "Price :-₹120.00", "Price :-₹174.00"};
    int bookimage_novel[] = {R.drawable.wings_of_fire, R.drawable.life_is_what, R.drawable.think_grow_rich, R.drawable.power_of_mind, R.drawable.the_perfect_ending};


    String price_historical[] = {"Price :-₹250.00", "Price :-₹150.00", "Price :-₹399.00", "Price :-₹199.00", "Price :-₹169.00", "Price :-₹299.00"};
    int images_historical[] = {R.drawable.india_history, R.drawable.krishnadevray, R.drawable.moghal_empire, R.drawable.padmavat, R.drawable.prithviraj_chauhan, R.drawable.war_peace};


    String price_fiction[] = {"Price :-₹179.00", "Price :-₹602.00", "Price :-₹399.00", "Price :-₹99.00", "Price :-₹885.00", "Price :-₹299.00"};
    int img_fiction_science[] = {R.drawable.albert_fiction, R.drawable.exploring_space, R.drawable.physics_fiction, R.drawable.time_machine, R.drawable.big_book_fiction, R.drawable.artemis_fiction};


    Button click1, click_story, click_novel, click_historical, click_science_fiction;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        arrayList = readbookes();
        arrayList2 = readstory();
        arrayList3 = readnovel();
        arrayList4 = readhistorical();
        arrayList5 = readfiction();

        MyRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        MyRecyclerView.setHasFixedSize(true);

        MyRecyclerView2 = (RecyclerView) view.findViewById(R.id.recycler_view_story);
        MyRecyclerView2.setHasFixedSize(true);

        MyRecyclerView3 = (RecyclerView) view.findViewById(R.id.recycler_view_novels);
        MyRecyclerView3.setHasFixedSize(true);

        MyRecyclerView4 = (RecyclerView) view.findViewById(R.id.recycler_view_hitorical);
        MyRecyclerView4.setHasFixedSize(true);

        MyRecyclerView5 = (RecyclerView) view.findViewById(R.id.recycler_view_fiction);
        MyRecyclerView5.setHasFixedSize(true);


        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        if (arrayList.size() > 0 & MyRecyclerView != null) {
            MyRecyclerView.setAdapter(new MyAdapter(arrayList));
        }
        MyRecyclerView.setLayoutManager(MyLayoutManager);


        LinearLayoutManager MyLayoutManager2 = new LinearLayoutManager(getActivity());
        MyLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        if (arrayList2.size() > 0 & MyRecyclerView2 != null) {
            MyRecyclerView2.setAdapter(new MyAdapter2(arrayList2));
        }
        MyRecyclerView2.setLayoutManager(MyLayoutManager2);


        LinearLayoutManager MyLayoutManager3 = new LinearLayoutManager(getActivity());
        MyLayoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        if (arrayList3.size() > 0 & MyRecyclerView3 != null) {
            MyRecyclerView3.setAdapter(new MyAdapter3(arrayList3));
        }
        MyRecyclerView3.setLayoutManager(MyLayoutManager3);


        LinearLayoutManager MyLayoutManager4 = new LinearLayoutManager(getActivity());
        MyLayoutManager4.setOrientation(LinearLayoutManager.HORIZONTAL);
        if (arrayList4.size() > 0 & MyRecyclerView4 != null) {
            MyRecyclerView4.setAdapter(new MyAdapter4(arrayList4));
        }
        MyRecyclerView4.setLayoutManager(MyLayoutManager4);


        LinearLayoutManager MyLayoutManager5 = new LinearLayoutManager(getActivity());
        MyLayoutManager5.setOrientation(LinearLayoutManager.HORIZONTAL);
        if (arrayList5.size() > 0 & MyRecyclerView5 != null) {
            MyRecyclerView5.setAdapter(new MyAdapter5(arrayList5));
        }
        MyRecyclerView5.setLayoutManager(MyLayoutManager5);


        viewFlipper = (ViewFlipper) view.findViewById(R.id.flipper);
        fade_in = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out);

        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();

        click1 = (Button) view.findViewById(R.id.button_education);
        click_story = (Button) view.findViewById(R.id.button_recycler_story);
        click_novel = (Button) view.findViewById(R.id.button_recycler_novels);
        click_historical = (Button) view.findViewById(R.id.button_recycler_historical);
        click_science_fiction = (Button) view.findViewById(R.id.button_recycler_fiction);


        click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout, new Educational_drawer());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        click_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout, new Story_drawer());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        click_novel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout, new Novel_drawer());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        click_historical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout, new Historical_drawer());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        click_science_fiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout, new Science_fiction_drawer());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return view;
    }


    private ArrayList<Books_Home> readbookes() {

        ArrayList<Books_Home> list = new ArrayList<>();
        for (int i = 0; i < Images_Books.length; i++) {
            Books_Home item = new Books_Home();
            item.setName(Book_Price[i]);
            item.setImage_drawable(Images_Books[i]);
            list.add(item);
        }
        return list;
    }

    private ArrayList<Books_Home> readstory() {

        ArrayList<Books_Home> list2 = new ArrayList<>();
        for (int i = 0; i < bookpic_story.length; i++) {
            Books_Home item2 = new Books_Home();
            item2.setName(bookprice_story[i]);
            item2.setImage_drawable(bookpic_story[i]);
            list2.add(item2);
        }
        return list2;
    }

    private ArrayList<Books_Home> readnovel() {

        ArrayList<Books_Home> list3 = new ArrayList<>();
        for (int i = 0; i < bookimage_novel.length; i++) {
            Books_Home item3 = new Books_Home();
            item3.setName(bookprice_novel[i]);
            item3.setImage_drawable(bookimage_novel[i]);
            list3.add(item3);
        }
        return list3;
    }

    private ArrayList<Books_Home> readhistorical() {

        ArrayList<Books_Home> list4 = new ArrayList<>();
        for (int i = 0; i < images_historical.length; i++) {
            Books_Home item4 = new Books_Home();
            item4.setName(price_historical[i]);
            item4.setImage_drawable(images_historical[i]);
            list4.add(item4);
        }
        return list4;
    }

    private ArrayList<Books_Home> readfiction() {

        ArrayList<Books_Home> list5 = new ArrayList<>();
        for (int i = 0; i < img_fiction_science.length; i++) {
            Books_Home item5 = new Books_Home();
            item5.setName(price_fiction[i]);
            item5.setImage_drawable(img_fiction_science[i]);
            list5.add(item5);
        }
        return list5;
    }


    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private ArrayList<Books_Home> list;

        public MyAdapter(ArrayList<Books_Home> Data) {
            list = Data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;

        }

        @Override
        public void onBindViewHolder(final MyViewHolder myViewHolder, int position) {
            myViewHolder.titleTextView.setText(list.get(position).getName());
            myViewHolder.coverImageView.setImageResource(list.get(position).getImage_drawable());

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView titleTextView;
        public ImageView coverImageView;

        public MyViewHolder(View v) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout, new Educational_drawer());
                    ft.addToBackStack(null);
                    ft.commit();
                }
            });
            titleTextView = (TextView) v.findViewById(R.id.text_home);
            coverImageView = (ImageView) v.findViewById(R.id.image_home);
        }

        @Override
        public void onClick(View v) {
        }
    }


    public class MyAdapter2 extends RecyclerView.Adapter<MyViewHolder2> {
        private ArrayList<Books_Home> list2;

        public MyAdapter2(ArrayList<Books_Home> Data2) {
            list2 = Data2;
        }

        @Override
        public MyViewHolder2 onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
            MyViewHolder2 holder2 = new MyViewHolder2(view2);
            return holder2;
        }

        @Override
        public void onBindViewHolder(MyViewHolder2 myViewHolder2, int i) {
            myViewHolder2.titleTextView2.setText(list2.get(i).getName());
            myViewHolder2.coverImageView2.setImageResource(list2.get(i).getImage_drawable());
        }

        @Override
        public int getItemCount() {
            return list2.size();
        }
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView titleTextView2;
        public ImageView coverImageView2;

        public MyViewHolder2(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout, new Story_drawer());
                    ft.addToBackStack(null);
                    ft.commit();
                }
            });

            titleTextView2 = (TextView) itemView.findViewById(R.id.text_home);
            coverImageView2 = (ImageView) itemView.findViewById(R.id.image_home);
        }

        @Override
        public void onClick(View v) {
        }
    }

    public class MyAdapter3 extends RecyclerView.Adapter<MyViewHolder3> {

        private ArrayList<Books_Home> list3;

        public MyAdapter3(ArrayList<Books_Home> Data3) {
            list3 = Data3;
        }

        @Override
        public MyViewHolder3 onCreateViewHolder(ViewGroup viewGroup, int i) {

            View view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
            MyViewHolder3 holder3 = new MyViewHolder3(view3);
            return holder3;
        }

        @Override
        public void onBindViewHolder(MyViewHolder3 myViewHolder3, int i) {

            myViewHolder3.titleTextView3.setText(list3.get(i).getName());
            myViewHolder3.coverImageView3.setImageResource(list3.get(i).getImage_drawable());
        }

        @Override
        public int getItemCount() {
            return list3.size();
        }
    }

    public class MyViewHolder3 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView titleTextView3;
        public ImageView coverImageView3;

        public MyViewHolder3(View itemView3) {
            super(itemView3);
            itemView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout, new Novel_drawer());
                    ft.addToBackStack(null);
                    ft.commit();
                }
            });
            titleTextView3 = (TextView) itemView3.findViewById(R.id.text_home);
            coverImageView3 = (ImageView) itemView3.findViewById(R.id.image_home);
        }

        @Override
        public void onClick(View v) {
        }
    }

    public class MyAdapter4 extends RecyclerView.Adapter<MyViewHolder4> {
        private ArrayList<Books_Home> list4;

        public MyAdapter4(ArrayList<Books_Home> Data4) {
            list4 = Data4;
        }

        @Override
        public MyViewHolder4 onCreateViewHolder(ViewGroup viewGroup, int i)
        {
            View view4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
            MyViewHolder4 holder4 = new MyViewHolder4(view4);
            return holder4;
        }

        @Override
        public void onBindViewHolder(MyViewHolder4 myViewHolder4, int i)
        {
            myViewHolder4.titleTextView4.setText(list4.get(i).getName());
            myViewHolder4.coverImageView4.setImageResource(list4.get(i).getImage_drawable());
        }

        @Override
        public int getItemCount() {
            return list4.size();
        }
    }

    public class MyViewHolder4 extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView titleTextView4;
        public ImageView coverImageView4;

        public MyViewHolder4(View itemView4)
        {
            super(itemView4);
            itemView4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout, new Historical_drawer());
                    ft.addToBackStack(null);
                    ft.commit();
                    }
            });
            titleTextView4 = (TextView) itemView4.findViewById(R.id.text_home);
            coverImageView4 = (ImageView) itemView4.findViewById(R.id.image_home);
        }

        @Override
        public void onClick(View v) {
        }
    }

    public class MyAdapter5 extends RecyclerView.Adapter<MyViewHolder5>
    {
        private ArrayList<Books_Home> list5;
        public MyAdapter5(ArrayList<Books_Home> Data5)
        {
            list5 = Data5;
        }

        @Override
        public MyViewHolder5 onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view5 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
            MyViewHolder5 holder5 = new MyViewHolder5(view5);
            return holder5;
        }

        @Override
        public void onBindViewHolder(MyViewHolder5 myViewHolder5, int i) {
            myViewHolder5.titleTextView5.setText(list5.get(i).getName());
            myViewHolder5.coverImageView5.setImageResource(list5.get(i).getImage_drawable());
        }

        @Override
        public int getItemCount() {
            return list5.size();
        }
    }


    public class MyViewHolder5 extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView titleTextView5;
        public ImageView coverImageView5;

        public MyViewHolder5(View itemView5)
        {
            super(itemView5);
            itemView5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout, new Science_fiction_drawer());
                    ft.addToBackStack(null);
                    ft.commit();
                }
            });
            titleTextView5 = (TextView) itemView5.findViewById(R.id.text_home);
            coverImageView5 = (ImageView) itemView5.findViewById(R.id.image_home);
        }
        @Override
        public void onClick(View v) {
        }
    }


   public class Books_Home
    {
        private String name;
        private int image_drawable;

        public String getName()
        {
            return name;
        }
        public void setName(String name)
        {
            this.name = name;
        }

        public int getImage_drawable()
        {
            return image_drawable;
        }

        public void setImage_drawable(int image_drawable)
        {
            this.image_drawable = image_drawable;
        }
    }

}
