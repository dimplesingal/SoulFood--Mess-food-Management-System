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

public class FeedbackStudentActivity extends AppCompatActivity  {

    EditText Messagefeed;
    Button feedbtn;

    DatabaseReference feedbackDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackstudent);

        Messagefeed = findViewById(R.id.feedbackmessage);
        feedbtn = findViewById(R.id.sendfeedback);

        feedbackDbRef = FirebaseDatabase.getInstance().getReference().child("Feedback");

        feedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertFeedbackData();
            }
        });

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));

    }

    private void insertFeedbackData(){

        String Message = Messagefeed.getText().toString();

        Feedback feedback = new Feedback(Message);

        feedbackDbRef.push().setValue(feedback);
        Toast.makeText(FeedbackStudentActivity.this, "Feedback Send Successfully", Toast.LENGTH_SHORT).show();
    }
}

