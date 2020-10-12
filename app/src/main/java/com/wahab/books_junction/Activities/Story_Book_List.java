package com.wahab.books_junction.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wahab.books_junction.R;


public class Story_Book_List extends AppCompatActivity
{

    ImageView gridimage;
    TextView txt1,txt2,txt3,txt5,txt6,txt7,txt8,txt9;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_historical__grid);

  //      Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_story);
    //    setSupportActionBar(toolbar);

//        customtext=toolbar.findViewById(R.id.header_name_text_story);

        //customtext.setText("Story_Book's");

        toolbar = (Toolbar)findViewById(R.id.toolbar_ssc);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.story_book);

        getSupportActionBar().setLogo(R.drawable.books_new);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setDisplayUseLogoEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbar.setTitleTextColor(getResources().getColor(R.color.cornsilk));


        gridimage=(ImageView)findViewById(R.id.imageView2);
        txt1=(TextView)findViewById(R.id.textView15);

        txt2=(TextView)findViewById(R.id.pricegrid);
        txt3=(TextView)findViewById(R.id.authorgrid);
        txt5=(TextView)findViewById(R.id.language);


        txt6=(TextView)findViewById(R.id.paperbackdata);
        txt7=(TextView)findViewById(R.id.publisherdata);
        txt8=(TextView)findViewById(R.id.productdimensiondata);
        txt9=(TextView)findViewById(R.id.codenodata);


        Intent i=getIntent();

        gridimage.setImageResource(i.getIntExtra("image",3));


        txt1.setText(i.getStringExtra("Bookname"));
        txt2.setText(i.getStringExtra("price"));

        txt3.setText(i.getStringExtra("author"));
        txt5.setText(i.getStringExtra("language"));
        txt6.setText(i.getStringExtra("paperback"));
        txt7.setText(i.getStringExtra("publisher"));
        txt8.setText(i.getStringExtra("dimension"));
        txt9.setText(i.getStringExtra("code"));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
