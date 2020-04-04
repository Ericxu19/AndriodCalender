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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Gets the User object and creates the Calender around it
        Intent intent = getIntent();
        this.user = (User) intent.getSerializableExtra("currentUser");
        Calendar calendar = (Calendar) intent.getSerializableExtra("currentCalendar");
        user.addCalendar(calendar);

        //Creates the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Updates the page with the info from the Calender
        TextView textView = findViewById(R.id.textView6);
        textView.setText(R.string.calendar);

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
        Button memo = findViewById(R.id.memos);
        Intent goToMemos = new Intent(getApplicationContext(), MemoListActivity.class);
        goToMemos.putExtra("currentUser", user);
        startActivity(goToMemos);
    }

    public void eventMenu(View view)
    {
        Button event_butt = findViewById(R.id.event);
        Intent goToEvents = new Intent(getApplicationContext(), EventActivity.class);
        goToEvents.putExtra("currentUser", user);
        startActivity(goToEvents);
    }

    public void alertMenu(View view)
    {
        Button alert = findViewById(R.id.alert);
        Intent goToAlert = new Intent(getApplicationContext(), AlertMenu.class);
        goToAlert.putExtra("currentUser", user);
        startActivity(goToAlert);
    }

}
