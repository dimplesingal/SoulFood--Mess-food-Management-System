package com.example.myapplication;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SpecialNotesAdminActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter_spn adapter_spn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_notes_admin);

        recyclerView = (RecyclerView)findViewById(R.id.recycle_spn);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model_spn> options =
                new FirebaseRecyclerOptions.Builder<model_spn>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Special Notes"), model_spn.class)
                        .build();

        adapter_spn = new Adapter_spn(options);
        recyclerView.setAdapter(adapter_spn);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Special Notes");

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter_spn.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter_spn.stopListening();
    }
}
