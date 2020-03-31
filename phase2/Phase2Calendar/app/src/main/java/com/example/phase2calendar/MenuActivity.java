package com.example.phase2calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.phase2calendar.logic.User;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Gets the User object and creates the Calender around it
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("currentUser");

        TextView textView = findViewById(R.id.textView6);
        textView.setText();


    }

    
}
