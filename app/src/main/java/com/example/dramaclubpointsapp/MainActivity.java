package com.example.dramaclubpointsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;

    FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();
    private String uid = fUser.getUid();
    private int points = 0;

    DatabaseReference userRef, rootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String name = user.getDisplayName();
        TextView username = (TextView) findViewById(R.id.textView2);
        username.setText(name);

        rootRef = FirebaseDatabase.getInstance().getReference();
        userRef = rootRef.child("users");

        Button testb = (Button) findViewById(R.id.buttonn);
        TextView testtv = (TextView) findViewById(R.id.textView15);

        testb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User testuser = dataSnapshot.getValue(User.class);
                        points=testuser.getPoints();
                        Toast.makeText(getApplicationContext(),"points: " + testuser.getPoints(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });

    }

    public void goSubmitButton(View v){
        Intent intent = new Intent(this, SubmitPointsActivity.class);
        startActivity(intent);
    }

}
