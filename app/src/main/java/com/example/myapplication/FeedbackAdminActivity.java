package com.example.myapplication;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class FeedbackAdminActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapt_feed adapt_feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_admin);

        recyclerView = (RecyclerView)findViewById(R.id.recycle_feed);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model_feed> options =
                new FirebaseRecyclerOptions.Builder<model_feed>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Feedback"), model_feed.class)
                        .build();

        adapt_feed = new Adapt_feed(options);
        recyclerView.setAdapter(adapt_feed);


        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapt_feed.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapt_feed.stopListening();
    }
}