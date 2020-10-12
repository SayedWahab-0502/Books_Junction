package com.wahab.books_junction.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.wahab.books_junction.Activities.Navigation_main;
import com.wahab.books_junction.R;

public class MainActivity extends AppCompatActivity
{
   private EditText mail,password;
   private Button log_in,forget,register;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
   // DataBaseHelper dataBaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_log_in);

        setSupportActionBar(toolbar);
       */

     // dataBaseHelper=new DataBaseHelper(this);
        mail=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        log_in=(Button)findViewById(R.id.button);
        forget=(Button)findViewById(R.id.button2);
       register=(Button)findViewById(R.id.button3);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null)
        {
            finish();
            startActivity(new Intent(MainActivity.this, Navigation_main.class));
        }


        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Forget_password.class);
                startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i);

            }
        });


        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                validate(mail.getText().toString(), password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword)
    {
        progressDialog.setMessage("Loading...please wait!");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    //startActivity(new Intent(MainActivity.this,SecondActivity.class));
                    //Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    checkEmailVerification();
                    progressDialog.dismiss();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        });
    }

    // EMAIL VERIFICATION

    private void checkEmailVerification()
    {
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();

        Boolean emailflag = firebaseUser.isEmailVerified();

        //startActivity(new Intent(MainActivity.this,SecondActivity.class));

        if(emailflag)
        {
            finish();
            startActivity(new Intent(MainActivity.this,Navigation_main.class));
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Verify your email", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }


}