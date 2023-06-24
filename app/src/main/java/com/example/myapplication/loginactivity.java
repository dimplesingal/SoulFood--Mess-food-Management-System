package com.example.myapplication;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class loginactivity extends AppCompatActivity {
    EditText email,password;
    Button loginBtn;

    boolean valid = true;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.btn_signin);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(email);
                checkField(password);


                if(valid){
                    fAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(loginactivity.this, "Loggedin Successfully", Toast.LENGTH_SHORT).show();
                            checkUserAccessLevel(authResult.getUser().getUid());
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(loginactivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }
            }
        });

        getSupportActionBar().setTitle("Sign In");
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));



    }

    private void checkUserAccessLevel(String uid) {
        DocumentReference df = fStore.collection("Users").document(uid);
        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Log.d("TAG","onSuccess: " + documentSnapshot.getData());

                if(documentSnapshot.getString("isAdmin") != null){
                    //user is admin

                    startActivity(new Intent(getApplicationContext(),menuactivity.class));
                    finish();
                }else{
                    if (documentSnapshot.getString("isStudent") != null){
                        startActivity(new Intent(getApplicationContext(),StudentMenuActivity.class));
                        finish();
                    }
                }
            }
        });
    }
    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error");
            valid = false;
        }else{
            valid = true;
        }

        return valid;
    }
}