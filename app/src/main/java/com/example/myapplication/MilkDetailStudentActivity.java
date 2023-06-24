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

public class MilkDetailStudentActivity extends AppCompatActivity //implements View.OnClickListener
{

    EditText milkdetailName,milkdetailRoom_no;
    Button milkButton;

    DatabaseReference milkdetailDbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_detail_student);
        
        milkdetailName = findViewById(R.id.milkdetailname);
        milkdetailRoom_no = findViewById(R.id.milkdetailroomno);
        milkButton = findViewById(R.id.milkbtn_yes);

        milkdetailDbRef = FirebaseDatabase.getInstance().getReference().child("Milk Details");

        milkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertMilkData();
            }
        });

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));


    }
    private void insertMilkData(){
        String name = milkdetailName.getText().toString();
        String room_no = milkdetailRoom_no.getText().toString();

        Milkdetails milkdetails = new Milkdetails(name,room_no);

        milkdetailDbRef.push().setValue(milkdetails);
        Toast.makeText(MilkDetailStudentActivity.this, "Milk Details Send Successfully", Toast.LENGTH_SHORT).show();
    }
}
