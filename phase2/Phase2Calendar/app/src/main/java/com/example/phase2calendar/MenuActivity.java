package com.example.phase2calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.phase2calendar.logic.User;
import com.example.phase2calendar.logic.Calendar;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Gets the User object and creates the Calender around it
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("currentUser");
        Calendar calendar = (Calendar) intent.getSerializableExtra("currentCalendar");
        user.addCalendar(calendar);

        //Updates the page with the info from the Calender
        TextView textView = findViewById(R.id.textView6);
        textView.setText(R.string.calendar);

        Button memo = findViewById(R.id.memos);
        memo.setOnClickListener(v -> {
            Intent goToMemos = new Intent(getApplicationContext(), MemoListActivity.class);
            goToMemos.putExtra("currentUser", user);
            startActivity(goToMemos);
        });

        Button event_butt = findViewById(R.id.event);
        event_butt.setOnClickListener(v -> {
            Intent goToEvents = new Intent(getApplicationContext(), EventActivity.class);
            goToEvents.putExtra("currentUser", user);
            startActivity(goToEvents);
        });



    }

    
}
