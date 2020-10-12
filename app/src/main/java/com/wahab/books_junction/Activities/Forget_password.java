package com.wahab.books_junction.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.wahab.books_junction.Activities.MainActivity;
import com.wahab.books_junction.R;

public class Forget_password extends AppCompatActivity {

    private EditText passwordEmail;
    private Button resetPassword;
    private FirebaseAuth firebaseAuth;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        passwordEmail = (EditText) findViewById(R.id.reset_mail);
        resetPassword = (Button) findViewById(R.id.reset_button);
        firebaseAuth = FirebaseAuth.getInstance();


        toolbar=(Toolbar)findViewById(R.id.toolbar_forget_pssword);


        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.forget_password);

        getSupportActionBar().setLogo(R.drawable.books_new);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbar.setTitleTextColor(getResources().getColor(R.color.cornsilk));




        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String useremail = passwordEmail.getText().toString().trim();
// below line means if you've entered nothing in email  then display  the Toast  given below
                if (useremail.equals(""))
                {
                    Toast.makeText(Forget_password.this, "Please enter your registered email ID", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(),"Password reset email sent",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(Forget_password.this, MainActivity.class));
                            }
                            else
                                {
                                Toast.makeText(getApplicationContext(),"Error in Password reset email",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
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
