package com.wahab.books_junction;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity
{
    EditText FULL_NAME,EMAIL,PASSWORD,DOB,MOBNO,ADD;

    Button register_btn;

    private Toolbar toolbar;

    DatePickerDialog datePickerDialog;

    AlertDialog.Builder builder;

    private FirebaseAuth firebaseAuth;

    String namee, mail, passwordd, dobb, mob_noo, add;

    //DataBaseHelper dataBaseHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        builder = new AlertDialog.Builder(this);


        firebaseAuth = FirebaseAuth.getInstance();

        //   dataBaseHelper=new DataBaseHelper(this);
        //toolbar=(Toolbar)findViewById(R.id.toolbar_register);


        FULL_NAME = (EditText) findViewById(R.id.user_fullname);//fullname
        EMAIL = (EditText) findViewById(R.id.user_email);//email
        PASSWORD = (EditText) findViewById(R.id.user_password);//password
        DOB = (EditText) findViewById(R.id.user_dob);  //dob
        MOBNO = (EditText) findViewById(R.id.user_mobile_no);//mob no
        ADD = (EditText) findViewById(R.id.user_address); //address

        register_btn = (Button) findViewById(R.id.registeration_btn);


        /*FragmentManager fragmentManager=getSupportFragmentManager();
        final FragmentTransaction transaction=fragmentManager.beginTransaction();
        final my_profile myprofile=new my_profile();*/


        DOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Calendar calendar = Calendar.getInstance();
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                final int month = calendar.get(Calendar.MONTH);
                final int year = calendar.get(Calendar.YEAR);


                datePickerDialog = new DatePickerDialog(Main2Activity.this, new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker datePicker, int dayyy, int monthh, int yearr)
                    {
                        DOB.setText(yearr+"/"+(monthh + 1)+"/"+dayyy);
                    }
                },day,month,year);

                datePickerDialog.show();

            }
        });


        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate2())
                {
                    // isme sendEmailVerification daal dia....aur sendEmailVerification me database ka part daal dia
                    String mail = EMAIL.getText().toString().trim();
                    String psswrd = PASSWORD.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(mail,psswrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(Task<AuthResult> task2)
                        {
                            if (task2.isSuccessful()) {

                                sendEmailVerification();

                                //startActivity(new Intent(Main2Activity.this, MainActivity.class));

                                builder.setMessage("Successfully Registered, Verification mail sent!").setCancelable(true).setPositiveButton("OK",new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        firebaseAuth.signOut();
                                        finish();
                                        startActivity(new Intent(Main2Activity.this, MainActivity.class));
                                    }
                                });
                            AlertDialog alert=builder.create();
                            alert.setTitle("Book's Junction.");
                            alert.show();

                            }
                            else
                                {
                                Toast.makeText(getApplicationContext(), "REGISTRATION UNSUCCESSFUL", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }


    private Boolean validate2()
    {
        Boolean result = false;

        namee = FULL_NAME.getText().toString();
        mail = EMAIL.getText().toString();
        passwordd = PASSWORD.getText().toString();
        dobb = DOB.getText().toString();
        mob_noo = MOBNO.getText().toString();
        add = ADD.getText().toString();

        if (namee.isEmpty() || mail.isEmpty() || passwordd.isEmpty() || dobb.isEmpty() || mob_noo.isEmpty() || add.isEmpty())
        {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }
        else {
            result = true;
        }
        return result;
    }

    private void sendEmailVerification()
    {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {
                        sendUserData();
                        //Toast.makeText(Main2Activity.this, "Successfully Registered, Verification mail sent!", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        //finish();
                    }
                    else
                        {
                        Toast.makeText(Main2Activity.this, "Verification mail has'nt been sent!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    private void sendUserData()
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());

        User_Profile user_profile = new User_Profile(namee,mail,dobb,mob_noo,add);

        myRef.setValue(user_profile);

    }

}