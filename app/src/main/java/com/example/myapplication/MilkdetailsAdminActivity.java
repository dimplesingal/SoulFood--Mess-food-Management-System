package com.example.myapplication;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MilkdetailsAdminActivity extends AppCompatActivity {

RecyclerView recyclerView;
milk_adapter milk_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milkdetails_admin);

        recyclerView = (RecyclerView)findViewById(R.id.recycle_milk);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<milkModel> options =
                new FirebaseRecyclerOptions.Builder<milkModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Milk Details"), milkModel.class)
                                .build();

        milk_adapter = new milk_adapter(options);
        recyclerView.setAdapter(milk_adapter);

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));

    }

    @Override
    protected void onStart() {
        super.onStart();
        milk_adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        milk_adapter.stopListening();
    }
}