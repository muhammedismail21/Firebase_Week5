package com.example.ismail.myapplication;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{
    DatabaseReference myRef;
    TextView valueTV;
    String value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valueTV = (TextView)this.findViewById(R.id.valueTV);
        myRef = FirebaseDatabase.getInstance().getReference().child("Zones").child("Dungeons");
    }

    public void normalDungeonsButtonPressed(View v)
    {
        value = "";
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //normalDungeons = new String[(int)dataSnapshot.child("Normal").getChildrenCount()];

                String name = "-----------------------------\nNormal Dungeons\n-----------------------------\n";
                for (DataSnapshot child : dataSnapshot.child("Normal").getChildren())
                {
                    name +=  (String)child.getKey() + "\n";
                    //String a = (String) map.get("Normal");
                    //String b = (String) map.get("name");
                    //textView.append(b + " -- " + a + "\n");
                    valueTV.setTextColor(Color.GREEN);
                    valueTV.setText( name + "");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    public void heroicDungeonsButtonPressed(View v)
    {
        value = "";
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = "-----------------------------\nHeroic Dungeons\n-----------------------------\n";
                for (DataSnapshot child : dataSnapshot.child("Heroic").getChildren()) {

                    name +=  (String)child.getKey() +"\n";
                    //String a = (String) map.get("Normal");
                    //String b = (String) map.get("name");
                    //textView.append(b + " -- " + a + "\n");
                    valueTV.setTextColor(Color.BLUE);
                    valueTV.setText( name + "");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void mythicDungeonsButtonPressed(View v)
    {
        value = "";
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = "-----------------------------\nMythic Dungeons\n-----------------------------\n";
                for (DataSnapshot child : dataSnapshot.child("Mythic").getChildren()) {

                    name +=  (String)child.getKey() +"\n";
                    //String a = (String) map.get("Normal");
                    //String b = (String) map.get("name");
                    //textView.append(b + " -- " + a + "\n");
                    valueTV.setTextColor(Color.RED);
                    valueTV.setText( name + "");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
