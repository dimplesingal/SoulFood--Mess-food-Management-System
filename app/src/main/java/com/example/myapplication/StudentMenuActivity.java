package com.example.myapplication;


import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class StudentMenuActivity extends AppCompatActivity {
Button logout;
    GridLayout homepage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_menu);

        logout = findViewById(R.id.logoutBtn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),loginactivity.class));
                finish();
            }
        });

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));
        homepage=(GridLayout) findViewById(R.id.homePage);
        setSingleEvent(homepage);

    }
    private void setSingleEvent(GridLayout homepage) {
        for (int i =0; i <homepage.getChildCount(); i++){
            CardView cardView = (CardView) homepage.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(finalI ==4){
                        Intent intent=new Intent(StudentMenuActivity.this, FeedbackStudentActivity.class);
                        startActivity(intent);
                    }

                    if(finalI ==2){
                        Intent intent=new Intent(StudentMenuActivity.this, SpecialNotesStudentActivity.class);
                        startActivity(intent);
                    }

                    if(finalI ==3){
                        Intent intent=new Intent(StudentMenuActivity.this, ImpNoticeStudentActivity.class);
                        startActivity(intent);
                    }

                    if(finalI ==1){
                        Intent intent=new Intent(StudentMenuActivity.this, MilkDetailStudentActivity.class);
                        startActivity(intent);
                    }

                    if(finalI ==0){
                        Intent intent=new Intent(StudentMenuActivity.this, StudentMainMenuActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}