package com.example.phase2calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
    }

    public void createEvent (View view) {
        EditText eventName = findViewById(R.id.eventName);
        EditText eventDescription = findViewById(R.id.eventDescription);
        EditText startDate = findViewById(R.id.startdate);
        EditText startTime = findViewById(R.id.starttime);
        EditText endDate = findViewById(R.id.enddate);
        EditText endTime = findViewById(R.id.endtime);

        String name = eventName.getText().toString();
        String desc = eventDescription.getText().toString();
        String sdate = startDate.getText().toString();
        String stime = startTime.getText().toString();
        String edate = endDate.getText().toString();
        String etime = endTime.getText().toString();

//        Intent intent = getIntent();
//        User user = (User) intent.getSerializableExtra("user");
//        Memo event = new Event(name, desc, fuck);
//        //user.addEventToCalendar(event, user.getCurrentCalender);
    }
}
