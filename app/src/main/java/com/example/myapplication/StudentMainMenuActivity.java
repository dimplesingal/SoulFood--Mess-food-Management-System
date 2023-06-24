package com.example.myapplication;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class StudentMainMenuActivity extends AppCompatActivity {

    Button attendance_studentMenu;
    private RecyclerView recyclerView;
    private Adapter_StudentMenu adapter_studentMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main_menu);

        attendance_studentMenu = findViewById(R.id.attendace_studentMenu);
        recyclerView = findViewById(R.id.recycle_studentM);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<modelStudentMenu> options =
                new FirebaseRecyclerOptions.Builder<modelStudentMenu>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Menu"),modelStudentMenu.class)
                        .build();

        adapter_studentMenu= new Adapter_StudentMenu(options);
        recyclerView.setAdapter(adapter_studentMenu);
        attendance_studentMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentMainMenuActivity.this ,Student_Attendence.class);
                startActivity(intent);
            }
        });
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));
    }
    @Override
    protected void onStart(){
        super.onStart();
        adapter_studentMenu.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter_studentMenu.stopListening();
    }
}