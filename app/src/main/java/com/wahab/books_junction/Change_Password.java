package com.wahab.books_junction;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Change_Password extends AppCompatActivity {

    private EditText new_password;
    private Button enter_btn;

   //private TextView custom_title;
  private Toolbar toolbar;

    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change__password);

        toolbar = (Toolbar) findViewById(R.id.toolbar_change_pssword);
     //custom_title=(TextView)findViewById(R.id.change_password_text);

        new_password=(EditText)findViewById(R.id.etNewPassword);
        enter_btn=(Button)findViewById(R.id.btnChangePassword);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.Change_password);

        getSupportActionBar().setLogo(R.drawable.books_new);
         getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbar.setTitleTextColor(getResources().getColor(R.color.cornsilk));

        //getSupportActionBar().setLogo(R.drawable.book_new);


       // custom_title.setText("Change Password");
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

     enter_btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             String neww_passwrd = new_password.getText().toString();
             if (neww_passwrd.isEmpty())
             {
                 Toast.makeText(getApplicationContext(),"Please Enter Your New Password",Toast.LENGTH_SHORT).show();
             }
             else
                 {
                 firebaseUser.updatePassword(neww_passwrd).addOnCompleteListener(new OnCompleteListener<Void>() {
                     @Override
                     public void onComplete(@NonNull Task<Void> task) {

                         if (task.isSuccessful())
                         {
                             Toast.makeText(Change_Password.this, "Password Changed Successfully", Toast.LENGTH_SHORT).show();
                             finish();
                         }
                         else
                             {
                             Toast.makeText(Change_Password.this, "Password Change Failed", Toast.LENGTH_SHORT).show();
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
