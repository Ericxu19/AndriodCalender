package com.example.phase2calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.phase2calendar.logic.User;
import com.example.phase2calendar.logic.Calendar;

public class MenuActivity extends AppCompatActivity {

    private User user;
    private Calendar currentCalendar;
    private int currentCalendarIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Gets the User object and creates the Calender around it
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("currentUser");
        currentCalendarIndex = (int) intent.getSerializableExtra("currentCalendarIndex");
        currentCalendar = user.getCalendar(currentCalendarIndex);

        //Updates the page with the info from the Calender
       TextView textView = findViewById(R.id.textView6);
        textView.setText(currentCalendar.getName());

    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent back = new Intent(this, MainMenuActivity.class);
        back.putExtra("currentUser", user);
        startActivity(back);
        return true;
    }

    public void memoMenu(View view)
    {
        Intent goToMemos = new Intent(this, MemoListActivity.class);
        goToMemos.putExtra("currentCalendarIndex", currentCalendarIndex);
        goToMemos.putExtra("currentUser", user);
        startActivity(goToMemos);
    }

    public void eventMenu(View view)
    {
        Intent goToEvents = new Intent(this, EventMenuActivity.class);
        goToEvents.putExtra("currentCalendarIndex", currentCalendarIndex);
        goToEvents.putExtra("currentUser", user);
        startActivity(goToEvents);
    }

    public void seriesMenu(View view) {
        Intent intent = new Intent(this, SeriesListActivity.class);
        intent.putExtra("currentUser", user);
        intent.putExtra("currentCalendarIndex", currentCalendarIndex);
    }

    public void alertMenu(View view)
    {
        Intent goToAlert = new Intent(this, AlertMenu.class);
        goToAlert.putExtra("currentUser", user);
        startActivity(goToAlert);
    }

}
