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

public class MainMenuAdminActivity extends AppCompatActivity {

    Button addMenu;
    private RecyclerView recyclerView;
    private Adapt_menu adapt_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_admin);

        addMenu = findViewById(R.id.add_menu);
        recyclerView = findViewById(R.id.recycle_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<modelMenu> options =
                new FirebaseRecyclerOptions.Builder<modelMenu>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Menu"),modelMenu.class)
                                .build();

        adapt_menu= new Adapt_menu(options,this);
        recyclerView.setAdapter(adapt_menu);
        addMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuAdminActivity.this , AddMenuContentActivity.class);
                startActivity(intent);
            }
        });
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));
    }
    @Override
    protected void onStart(){
        super.onStart();
        adapt_menu.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        adapt_menu.stopListening();
    }
}