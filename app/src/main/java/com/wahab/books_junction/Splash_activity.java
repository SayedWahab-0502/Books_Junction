package com.wahab.books_junction;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

public class Splash_activity extends AppCompatActivity

{

    private static int SPLASH_SCREEN_TIME=5000;

    Toolbar toolbar;

    TextView customtext;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activity);

        /*toolbar=(Toolbar)findViewById(R.id.toolbar_splash);
        setSupportActionBar(toolbar);

        customtext=toolbar.findViewById(R.id.header_name_text_splash);

        customtext.setText("Book's_Junction!!!");*/


        new Handler().postDelayed(new Runnable()
        {
            @Override

            public void run()
            {
                Intent iHomeScreen=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(iHomeScreen);
                finish();
            }

        },SPLASH_SCREEN_TIME);

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}
