package com.example.phase2calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.phase2calendar.logic.Alert;
import com.example.phase2calendar.logic.AlertHandler;
import com.example.phase2calendar.logic.Calendar;
import com.example.phase2calendar.logic.Event;
import com.example.phase2calendar.logic.User;

import java.util.ArrayList;

public class NewAlertActivity extends AppCompatActivity {

    private User user;
    private Event event;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alert);

        Intent intent = getIntent();
        this.user = (User) intent.getSerializableExtra("currentUser");
        this.event = (Event) intent.getSerializableExtra("currentEvent");
        //this.calendar = user.getCurrentCalendar();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button create = findViewById(R.id.createAlert);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent back = new Intent(this, AlertMenu.class);
        back.putExtra("currentUser", user);
        startActivity(back);
        return true;
    }

    public void createAlert(View view)
    {
        ArrayList<Alert> alerts = new ArrayList<Alert>();
        EditText dateField = findViewById(R.id.date);
        EditText timeField = findViewById(R.id.time);
        TextView display = findViewById(R.id.displayAlerts);
        String date = dateField.getText().toString();
        String time = timeField.getText().toString();

        if (date.length() == 0)
        {

        }
    }
}
