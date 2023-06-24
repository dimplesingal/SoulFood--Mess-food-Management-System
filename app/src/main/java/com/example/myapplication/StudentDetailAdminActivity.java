package com.example.myapplication;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class StudentDetailAdminActivity extends AppCompatActivity {
  private   Button Brkfstlist;
    private Button Lunchlist;
    private Button Snacklist;
    private Button Dinnerlist;
    private DatabaseReference breakfastRef,lunchRef,snacksRef,dinnerRef;
    private FirebaseAuth mAuth;
    private String currentName;
    private int countBreakfast = 0;
    private int countLunch = 0;
    private int countSnacks = 0;
    private int countDinner = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail_admin);
        mAuth = FirebaseAuth.getInstance();
        currentName = mAuth.getCurrentUser().getDisplayName();
        breakfastRef = FirebaseDatabase.getInstance().getReference().child("Breakfast");
        lunchRef = FirebaseDatabase.getInstance().getReference().child("Lunch");
        snacksRef = FirebaseDatabase.getInstance().getReference().child("Snacks");
        dinnerRef = FirebaseDatabase.getInstance().getReference().child("Dinner");
        Brkfstlist = (Button) findViewById(R.id.brkfstlist);
        Lunchlist =(Button) findViewById(R.id.lunchlist);
        Snacklist =(Button) findViewById(R.id.snackslist);
        Dinnerlist =(Button) findViewById(R.id.dinnerlist);
        Brkfstlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDetailAdminActivity.this , BreakfastListActivity.class);
                startActivity(intent);
            }
        });
        breakfastRef.child(currentName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    countBreakfast = (int) snapshot.getChildrenCount();
                    Brkfstlist.setText(Integer.toString(countBreakfast) + " :Breakfast ");
                }else{
                    Brkfstlist.setText("0  Breakfast");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Lunchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(StudentDetailAdminActivity.this,LunchListActivity.class);
                startActivity(intent1);
            }
        });
        lunchRef.child(currentName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    countLunch = (int) snapshot.getChildrenCount();
                    Lunchlist.setText(Integer.toString(countLunch) + " :Lunch ");
                }else{
                    Lunchlist.setText("0  Lunch");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Snacklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(StudentDetailAdminActivity.this, SnacksListActivity.class);
                startActivity(intent2);
            }
        });
        snacksRef.child(currentName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    countSnacks = (int) snapshot.getChildrenCount();
                    Snacklist.setText(Integer.toString(countSnacks) + " :Snacks ");
                }else{
                    Snacklist.setText("0  Snacks");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Dinnerlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(StudentDetailAdminActivity.this, DinnerListActivity.class);
                startActivity(intent3);
            }
        });
        dinnerRef.child(currentName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    countDinner = (int) snapshot.getChildrenCount();
                    Dinnerlist.setText(Integer.toString(countDinner) + " :Dinner ");
                }else{
                    Dinnerlist.setText("0  Dinner");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));
    }
}