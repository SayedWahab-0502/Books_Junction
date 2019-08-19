package com.wahab.books_junction;

import android.app.DatePickerDialog;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Calendar;

public class Update_Profile_User extends AppCompatActivity
{

    private Toolbar toolbar;

    private EditText FULL_NAME,EMAIL,DOB,MOBNO,ADD;
    private Button update_info_button;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__profile__user);


        FULL_NAME = (EditText) findViewById(R.id.user_fullname_update);//fullname
        EMAIL = (EditText) findViewById(R.id.user_email_update);//email

        DOB = (EditText) findViewById(R.id.user_dob_update);  //dob
        MOBNO = (EditText) findViewById(R.id.user_mobile_no_update);//mob no
        ADD = (EditText) findViewById(R.id.user_address_update); //address

        update_info_button = (Button) findViewById(R.id.update_prof_btn);  //button




        firebaseAuth= FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();

        final DatabaseReference databaseReference= firebaseDatabase.getReference(firebaseAuth.getUid());

        toolbar = (Toolbar) findViewById(R.id.toolbar_update_profile);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.profile_updation);

        getSupportActionBar().setLogo(R.drawable.books_new);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbar.setTitleTextColor(getResources().getColor(R.color.cornsilk));
        


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                User_Profile user_profile= dataSnapshot.getValue(User_Profile.class);

                FULL_NAME.setText(user_profile.getUserName());
                EMAIL.setText(user_profile.getUserEmail());
                DOB.setText(user_profile.getUserdob());
                MOBNO.setText(user_profile.getUsermobno());
                ADD.setText(user_profile.getUseradd());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Update_Profile_User.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });


        DOB.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Calendar calendar = Calendar.getInstance();
                                       final int day = calendar.get(Calendar.DAY_OF_MONTH);
                                       final int month = calendar.get(Calendar.MONTH);
                                       final int year = calendar.get(Calendar.YEAR);


                                       datePickerDialog = new DatePickerDialog(Update_Profile_User.this, new DatePickerDialog.OnDateSetListener() {
                                           @Override
                                           public void onDateSet(DatePicker datePicker, int dayyy, int monthh, int yearr) {
                                               DOB.setText(yearr + "/" + (monthh + 1) + "/" + dayyy);
                                           }
                                       }, day, month, year);

                                       datePickerDialog.show();

                                   }
                               });


        update_info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String new_update_name = FULL_NAME.getText().toString();
                String new_update_email = EMAIL.getText().toString();
                String new_update_dob= DOB.getText().toString();
                String new_update_mobno= MOBNO.getText().toString();
                String new_update_add= ADD.getText().toString();


                User_Profile user_profile=new User_Profile(new_update_name,new_update_email,new_update_dob,new_update_mobno,new_update_add);

                databaseReference.setValue(user_profile);

                Toast.makeText(getApplicationContext(),"Profile Updated Successfully",Toast.LENGTH_LONG).show();

                finish();
            }
        });

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
