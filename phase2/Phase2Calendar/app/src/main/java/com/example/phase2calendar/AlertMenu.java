package com.example.phase2calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.phase2calendar.logic.User;

public class AlertMenu extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_menu);

        Intent intent = getIntent();
        this.user = (User) intent.getSerializableExtra("currentUser");
    }
}
