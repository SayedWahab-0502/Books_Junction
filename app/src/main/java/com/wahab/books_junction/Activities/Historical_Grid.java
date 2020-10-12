package com.wahab.books_junction.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.wahab.books_junction.R;

public class Historical_Grid extends AppCompatActivity {


    ImageView gridimage;
    TextView txt1,txt2,txt3,txt5,txt6,txt7,txt8,txt9;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical__grid);

//        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_story);
     //   setSupportActionBar(toolbar);

  //      customtext=toolbar.findViewById(R.id.header_name_text_story);

       // customtext.setText("Historical Book's");




        toolbar = (Toolbar)findViewById(R.id.toolbar_ssc);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.history);

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


        Intent intent=getIntent();
        gridimage.setImageResource(intent.getIntExtra("image",0));
        txt1.setText(intent.getStringExtra("Bookname"));
        txt2.setText(intent.getStringExtra("price"));
        txt3.setText(intent.getStringExtra("author"));


        txt5.setText(intent.getStringExtra("language"));
        txt6.setText(intent.getStringExtra("paperback"));
        txt7.setText(intent.getStringExtra("publisher"));
        txt8.setText(intent.getStringExtra("dimension"));
        txt9.setText(intent.getStringExtra("productcode"));


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
