package com.wahab.books_junction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class twelveth_addtobag_science extends AppCompatActivity
{

    ImageView image_twelveth;
    TextView txt1,txt2,txt3,txt5,txt6,txt7,txt8,txt9;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical__grid);

      // Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_story);
        //setSupportActionBar(toolbar);

//        customtext=toolbar.findViewById(R.id.header_name_text_story);

        //customtext.setText("12TH STD(SCIENCE)");



        toolbar = (Toolbar)findViewById(R.id.toolbar_ssc);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.twel_science);

        getSupportActionBar().setLogo(R.drawable.books_new);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setDisplayUseLogoEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbar.setTitleTextColor(getResources().getColor(R.color.cornsilk));


        image_twelveth=(ImageView)findViewById(R.id.imageView2);
        txt1=(TextView)findViewById(R.id.textView15);

        txt2=(TextView)findViewById(R.id.pricegrid);
        txt3=(TextView)findViewById(R.id.authorgrid);
        txt5=(TextView)findViewById(R.id.language);


        txt6=(TextView)findViewById(R.id.paperbackdata);
        txt7=(TextView)findViewById(R.id.publisherdata);
        txt8=(TextView)findViewById(R.id.productdimensiondata);
        txt9=(TextView)findViewById(R.id.codenodata);


        Intent i=getIntent();

        image_twelveth.setImageResource(i.getIntExtra("image_sci_twelveth",5));

        txt1.setText(i.getStringExtra("name_sci_twelveth"));
        txt2.setText(i.getStringExtra("price_sci_twelveth"));

        txt3.setText(i.getStringExtra("author_sci_twelveth"));
        txt5.setText(i.getStringExtra("language_sci_twelveth"));
        txt6.setText(i.getStringExtra("paperback_sci_twelveth"));
        txt7.setText(i.getStringExtra("publisher_sci_twelveth"));
        txt8.setText(i.getStringExtra("dimension_sci_twelveth"));
        txt9.setText(i.getStringExtra("code_sci_twelveth"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}