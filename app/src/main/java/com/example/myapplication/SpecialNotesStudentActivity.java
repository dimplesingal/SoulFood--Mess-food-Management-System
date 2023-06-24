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

public class SpecialNotesStudentActivity extends AppCompatActivity {
    EditText spnName,spnRoom_no,spnMessage;
    Button spnButton;
    DatabaseReference specialnoteDbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_notesstudent);

        spnName = findViewById(R.id.specialname);
        spnRoom_no = findViewById(R.id.specialnumber);
        spnMessage = findViewById(R.id.specialmessage);
        spnButton = findViewById(R.id.sendspecialnotes);
        specialnoteDbRef = FirebaseDatabase.getInstance().getReference().child("Special Notes");
        
        spnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSpecialNotes();
            }
        });
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));
    }
    private void insertSpecialNotes(){
        String name = spnName.getText().toString();
        String room_no = spnMessage.getText().toString();
        String message = spnRoom_no.getText().toString();

        Specialnotes specialnotes = new Specialnotes(name,room_no,message);

        specialnoteDbRef.push().setValue(specialnotes);
        Toast.makeText(SpecialNotesStudentActivity.this, "Special Notes Send Successfully", Toast.LENGTH_SHORT).show();
    }
}