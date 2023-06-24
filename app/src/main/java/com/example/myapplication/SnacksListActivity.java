package com.example.myapplication;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SnacksListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    snack_Adapter snack_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks_list);

        recyclerView = (RecyclerView)findViewById(R.id.recycle_snackAttend);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Member> options =
                new FirebaseRecyclerOptions.Builder<Member>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Snacks"), Member.class)
                        .build();

        snack_adapter = new snack_Adapter(options);
        recyclerView.setAdapter(snack_adapter);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        snack_adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        snack_adapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu,menu);

        MenuItem item = menu.findItem(R.id.search);

        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                processsearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                processsearch(query);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String query) {
        FirebaseRecyclerOptions<Member> options =
                new FirebaseRecyclerOptions.Builder<Member>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Snacks").orderByChild("name").startAt(query).endAt(query+"\uf8ff"), Member.class)
                        .build();

        snack_adapter = new snack_Adapter(options);
        snack_adapter.startListening();
        recyclerView.setAdapter(snack_adapter);
    }
}