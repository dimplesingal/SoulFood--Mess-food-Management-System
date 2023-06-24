package com.example.myapplication;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Student_Attendence extends AppCompatActivity {
    EditText AttName;
    EditText AttRoom_no;
    FirebaseDatabase database;
    DatabaseReference brkfstreference;
    DatabaseReference lunchreference;
    DatabaseReference snackreference;
    DatabaseReference dinnerreference;
    Button brkfastAttendance;
    Button lunchtAttendance;
    Button snacAttendance;
    Button dinnAttendance;
    Member member;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendence);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));

        AttName = findViewById(R.id.attendence_name);
        AttRoom_no = findViewById(R.id.attendence_roomno);
        brkfastAttendance = findViewById(R.id.AttendanceBreakfast);
        lunchtAttendance = findViewById(R.id.AttendanceLunch);
        snacAttendance = findViewById(R.id.AttendanceSnacks);
        dinnAttendance = findViewById(R.id.AttendanceDinner);

        brkfstreference = database.getInstance().getReference().child("Breakfast");
        lunchreference = database.getInstance().getReference().child("Lunch");
        snackreference =database.getInstance().getReference().child("Snacks");
        dinnerreference = database.getInstance().getReference().child("Dinner");
        brkfastAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertbreakfastAttendance();
            }
        });


        lunchtAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertlunchAttendance();
            }
        });

        snacAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertsnackAttendance();
            }
        });

        dinnAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertdinnerAttendance();
            }
        });
    }
    private void insertbreakfastAttendance(){
        String name = AttName.getText().toString();
        String room_no = AttRoom_no.getText().toString();

        Member member = new Member(name,room_no);
        brkfstreference.push().setValue(member);
        Toast.makeText(this, "Breakfast added", Toast.LENGTH_SHORT).show();

    }

    private void insertlunchAttendance(){
        String name = AttName.getText().toString();
        String room_no = AttRoom_no.getText().toString();

        Member member = new Member(name,room_no);
        lunchreference.push().setValue(member);
        Toast.makeText(this, "Lunch added", Toast.LENGTH_SHORT).show();

    }

    private void insertsnackAttendance(){
        String name = AttName.getText().toString();
        String room_no = AttRoom_no.getText().toString();

        Member member = new Member(name,room_no);
        snackreference.push().setValue(member);
        Toast.makeText(this, "Snacks added", Toast.LENGTH_SHORT).show();

    }

    private void insertdinnerAttendance(){
        String name = AttName.getText().toString();
        String room_no = AttRoom_no.getText().toString();

        Member member = new Member(name,room_no);
        dinnerreference.push().setValue(member);
        Toast.makeText(this, "Dinner added", Toast.LENGTH_SHORT).show();

    }


}



