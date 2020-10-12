package com.wahab.books_junction.Activities;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wahab.books_junction.Fragments.About_Us;
import com.wahab.books_junction.Fragments.DrawerClass.Educational_drawer;
import com.wahab.books_junction.Fragments.DrawerClass.Historical_drawer;
import com.wahab.books_junction.Fragments.DrawerClass.Novel_drawer;
import com.wahab.books_junction.Fragments.DrawerClass.Science_fiction_drawer;
import com.wahab.books_junction.Fragments.Home_page;
import com.wahab.books_junction.Fragments.DrawerClass.Story_drawer;
import com.wahab.books_junction.Fragments.my_profile;
import com.wahab.books_junction.R;
import com.wahab.books_junction.HelperClasses.User_Profile;

public class Navigation_main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

   TextView custom_title;

    Toolbar toolbar;

    AlertDialog.Builder builder;

    private FirebaseAuth firebaseAuth;

    private FirebaseDatabase firebaseDatabase;

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        builder=new AlertDialog.Builder(this);

        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();
       firebaseDatabase=FirebaseDatabase.getInstance();

        custom_title=toolbar.findViewById(R.id.header_name_text_nav);

        custom_title.setText("Book's Junction");
        setFragment(new Home_page());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView)findViewById(R.id.nav_view);

        View headview = navigationView.getHeaderView(0);

        final TextView header_name=headview.findViewById(R.id.nav_header_fullname);
       final TextView header_mail=headview.findViewById(R.id.nav_header_mail_id);

        navigationView.setNavigationItemSelectedListener(this);

        DatabaseReference databaseReference= firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                User_Profile user_profile= dataSnapshot.getValue(User_Profile.class);

                header_name.setText(user_profile.getUserName());
                header_mail.setText(user_profile.getUserEmail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Navigation_main.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Logout()
    {
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(Navigation_main.this, MainActivity.class));
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.Home_Page)
        {
            custom_title.setText("Book's Junction");
            setFragment(new Home_page());
            Toast.makeText(getApplicationContext(),"Home Page",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //Fragment fragment;

        if (id == R.id.about_us_new)
        {
            custom_title.setText("About Us");
              setFragment(new About_Us());
        }
        else if (id == R.id.profile)
        {
            custom_title.setText("My Profile");
            setFragment(new my_profile());

        }
        else if (id == R.id.education)
        {
            custom_title.setText("Educational Book's");
            setFragment(new Educational_drawer());

    /*        android.app.FragmentManager fragmentManager=getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

            Educational_drawer educational_drawer=new Educational_drawer();
            fragmentTransaction.replace(R.id.framelayout,educational_drawer);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
*/
        }
        else if (id == R.id.Story)
        {
            custom_title.setText("Story Book's");
            setFragment(new Story_drawer());
/*
            android.app.FragmentManager fragmentManager=getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

            Story_drawer storyDrawer=new Story_drawer();
            fragmentTransaction.replace(R.id.framelayout,storyDrawer);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
  */
        }
        else if (id == R.id.novels)
        {
            custom_title.setText("Novel's");
            setFragment(new Novel_drawer());

  /*          android.app.FragmentManager fragmentManager=getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

            Novel_drawer novels_drawer=new Novel_drawer();
            fragmentTransaction.replace(R.id.framelayout,novels_drawer);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
*/
        }
        else if (id == R.id.historical) {

            custom_title.setText("Historical Book's");
            setFragment(new Historical_drawer());

/*
            android.app.FragmentManager fragmentManager=getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();


            Historical_drawer historical_drawer=new Historical_drawer();
            fragmentTransaction.replace(R.id.framelayout,historical_drawer);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
*/
        }
        else if (id == R.id.science)
        {
            custom_title.setText("Science Fiction");
            setFragment(new Science_fiction_drawer());
           /* android.app.FragmentManager fragmentManager=getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();


            Science_fiction_drawer science_fiction_drawer=new Science_fiction_drawer();
            fragmentTransaction.replace(R.id.framelayout,science_fiction_drawer);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
*/
        }
        else if (id == R.id.action_log_out)
        {
            builder.setMessage("Are you Sure you want to Log out Book's Junction.").setCancelable(true).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Logout();
                    //Intent i = new Intent(Navigation_main.this, MainActivity.class);
                    //startActivityForResult(i, 2);
                    Toast.makeText(getApplicationContext(), "You have Log out Successfully", Toast.LENGTH_LONG).show();

                }
            })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();
                            Toast.makeText(getApplicationContext(), "You say No to Log out.", Toast.LENGTH_LONG).show();
                        }

                    });
            AlertDialog alert = builder.create();
            alert.setTitle("Confirm Log out.");
            alert.show();

        }
        return true;
    }

   public void setFragment(Fragment fragment)
   {
        if (fragment!=null)
        {

            FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.framelayout,fragment);
            ft.addToBackStack(null);
            ft.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}