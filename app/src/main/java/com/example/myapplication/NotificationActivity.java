package com.example.myapplication;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Objects;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Actionbar)));

        FirebaseMessaging.getInstance().subscribeToTopic("all");
        EditText title = findViewById(R.id.title_notification);
        EditText message = findViewById(R.id.message_notification);
        findViewById(R.id.send_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!title.getText().toString().isEmpty() && !message.getText().toString().isEmpty()){
                    FcmNotificationsSender notificationsSender = new FcmNotificationsSender("/topics/all",
                            title.getText().toString(),
                            message.getText().toString(),getApplicationContext(),NotificationActivity.this);
                    notificationsSender.SendNotifications();
                }else{
                    Toast.makeText(NotificationActivity.this, "Write some text", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    }
