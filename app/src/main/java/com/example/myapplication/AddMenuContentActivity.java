package com.example.myapplication;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class AddMenuContentActivity extends AppCompatActivity {
    private EditText days;
    private EditText breakfast1,breakfast2,breakfast3;
    private EditText lunch1,lunch2,lunch3;
    private EditText snacks1,snacks2;
    private EditText dinner1,dinner2;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu_content);

        days = findViewById(R.id.Days);
        breakfast1= findViewById(R.id.Breakfast1);
        breakfast2 = findViewById(R.id.breakfast2);
        breakfast3 = findViewById(R.id.Breakfast3);
        lunch1= findViewById(R.id.Lunch1);
        lunch2=findViewById(R.id.Lunch2);
        lunch3 = findViewById(R.id.Lunch3);
        snacks1 = findViewById(R.id.Snacks1);
        snacks2 = findViewById(R.id.Snacks2);
        dinner1 =findViewById(R.id.Dinner1);
        dinner2 = findViewById(R.id.Dinner2);
        save = findViewById(R.id.saveMenu);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,Object> map = new HashMap<>();
                map.put("days",days.getText().toString());
                map.put("breakfast1",breakfast1.getText().toString());
                map.put("breakfast2",breakfast2.getText().toString());
                map.put("breakfast3",breakfast3.getText().toString());
                map.put("lunch1",lunch1.getText().toString());
                map.put("lunch2",lunch2.getText().toString());
                map.put("lunch3",lunch3.getText().toString());
                map.put("snacks1",snacks1.getText().toString());
                map.put("snacks2",snacks2.getText().toString());
                map.put("dinner1",dinner1.getText().toString());
                map.put("dinner2",dinner2.getText().toString());

                FirebaseDatabase.getInstance().getReference().child("Menu").push()
                        .setValue(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(AddMenuContentActivity.this, "Menu Saved Successfully", Toast.LENGTH_SHORT).show();
                                Log.i("mainmenu","onComplete:");
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.i("mainmenufail","onFailure:"+e.toString());

                            }
                        });
            }
        });



        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));
    }
}