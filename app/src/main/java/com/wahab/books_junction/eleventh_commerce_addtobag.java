package com.wahab.books_junction;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class eleventh_commerce_addtobag extends AppCompatActivity
{

    ImageView image_eleventh_commerce;
    TextView txt1,txt2,txt3,txt5,txt6,txt7,txt8,txt9;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_historical__grid);

//        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_story);
   //     setSupportActionBar(toolbar);

  //      customtext=toolbar.findViewById(R.id.header_name_text_story);

        //customtext.setText("11TH STD(COMMERCE)");

        toolbar = (Toolbar)findViewById(R.id.toolbar_ssc);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.ele_commerce);

        getSupportActionBar().setLogo(R.drawable.books_new);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setDisplayUseLogoEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbar.setTitleTextColor(getResources().getColor(R.color.cornsilk));



        image_eleventh_commerce=(ImageView)findViewById(R.id.imageView2);
        txt1=(TextView)findViewById(R.id.textView15);

        txt2=(TextView)findViewById(R.id.pricegrid);
        txt3=(TextView)findViewById(R.id.authorgrid);
        txt5=(TextView)findViewById(R.id.language);


        txt6=(TextView)findViewById(R.id.paperbackdata);
        txt7=(TextView)findViewById(R.id.publisherdata);
        txt8=(TextView)findViewById(R.id.productdimensiondata);
        txt9=(TextView)findViewById(R.id.codenodata);

        Intent i=getIntent();

        image_eleventh_commerce.setImageResource(i.getIntExtra("image_com_eleventh",7));

        txt1.setText(i.getStringExtra("name_com_eleventh"));
        txt2.setText(i.getStringExtra("price_com_eleventh"));

        txt3.setText(i.getStringExtra("author_com_eleventh"));
        txt5.setText(i.getStringExtra("language_com_eleventh"));
        txt6.setText(i.getStringExtra("paperback_com_eleventh"));
        txt7.setText(i.getStringExtra("publisher_com_eleventh"));
        txt8.setText(i.getStringExtra("dimension_com_eleventh"));
        txt9.setText(i.getStringExtra("code_com_eleventh"));



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
