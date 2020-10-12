package com.wahab.books_junction.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wahab.books_junction.Activities.Change_Password;
import com.wahab.books_junction.R;
import com.wahab.books_junction.Activities.Update_Profile_User;
import com.wahab.books_junction.HelperClasses.User_Profile;


public class my_profile extends Fragment
{

 private  TextView txt1,txt2,txt3,txt4,txt5;
 private Button update_profile_btn,change_pssword_btn;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)

    {

        View view=inflater.inflate(R.layout.fragment_my_profile, container, false);

        txt1=(TextView)view.findViewById(R.id.fullname_data);
        txt2=(TextView)view.findViewById(R.id.email_data);
        txt3=(TextView)view.findViewById(R.id.dob_data);
        txt4=(TextView)view.findViewById(R.id.mobile_data);
        txt5=(TextView)view.findViewById(R.id.address_data);

        update_profile_btn=(Button)view.findViewById(R.id.update_profile_btn);
        change_pssword_btn=(Button)view.findViewById(R.id.change_password_btn);

        firebaseAuth=FirebaseAuth.getInstance();

        firebaseDatabase=FirebaseDatabase.getInstance();




        change_pssword_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Change_Password.class));
            }
        });

        update_profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Update_Profile_User.class));
            }
        });


        DatabaseReference databaseReference= firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                User_Profile user_profile= dataSnapshot.getValue(User_Profile.class);

                txt1.setText(user_profile.getUserName());
                txt2.setText(user_profile.getUserEmail());
                txt3.setText(user_profile.getUserdob());
                txt4.setText(user_profile.getUsermobno());
                txt5.setText(user_profile.getUseradd());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(getContext(),databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });


        return view;

    }

}
