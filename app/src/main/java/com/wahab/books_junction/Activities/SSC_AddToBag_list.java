package com.wahab.books_junction.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wahab.books_junction.R;

public class SSC_AddToBag_list extends AppCompatActivity
{

    ImageView sscimage;
    TextView txt1,txt2,txt3,txt5,txt6,txt7,txt8,txt9;
    Button button;
    AlertDialog.Builder builder;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_historical__grid);


        toolbar = (Toolbar)findViewById(R.id.toolbar_ssc);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.ssc_name);

        getSupportActionBar().setLogo(R.drawable.books_new);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setDisplayUseLogoEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbar.setTitleTextColor(getResources().getColor(R.color.cornsilk));

       // customtext=toolbar.findViewById(R.id.header_name_text_story);
        //customtext.setText("10TH STD");
        button=(Button)findViewById(R.id.button_ssc);
        builder=new AlertDialog.Builder(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                builder.setMessage("You have Successfully Added to My Bag").setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                });

                AlertDialog alert=builder.create();
                alert.setTitle("Book's Junction(10TH STD)");
                alert.show();

            }
        });

        sscimage=(ImageView)findViewById(R.id.imageView2);
        txt1=(TextView)findViewById(R.id.textView15);

        txt2=(TextView)findViewById(R.id.pricegrid);
        txt3=(TextView)findViewById(R.id.authorgrid);
        txt5=(TextView)findViewById(R.id.language);


        txt6=(TextView)findViewById(R.id.paperbackdata);
        txt7=(TextView)findViewById(R.id.publisherdata);
        txt8=(TextView)findViewById(R.id.productdimensiondata);
        txt9=(TextView)findViewById(R.id.codenodata);



        Intent i=getIntent();
        sscimage.setImageResource(i.getIntExtra("imagessc",4));

        txt1.setText(i.getStringExtra("namessc"));
        txt2.setText(i.getStringExtra("pricessc"));
        txt3.setText(i.getStringExtra("authorssc"));
        txt5.setText(i.getStringExtra("languagessc"));
        txt6.setText(i.getStringExtra("paperbackssc"));
        txt7.setText(i.getStringExtra("publisherssc"));
        txt8.setText(i.getStringExtra("dimensionssc"));
        txt9.setText(i.getStringExtra("codessc"));




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
