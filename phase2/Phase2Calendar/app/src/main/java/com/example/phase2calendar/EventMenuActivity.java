package com.example.phase2calendar;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.phase2calendar.adapters.GenericAdapter;
import com.example.phase2calendar.dialogs.CalendarCreationDialog;
import com.example.phase2calendar.dialogs.EventCreationDialog;
import com.example.phase2calendar.logic.Calendar;
import com.example.phase2calendar.logic.Event;
import com.example.phase2calendar.logic.User;
import com.example.phase2calendar.logic.UserWriter;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventMenuActivity extends AppCompatActivity implements EventCreationDialog.EventCreationDialogListener {

    private RecyclerView recyclerView;
    private GenericAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private User currentUser;
    private Calendar currentCalendar;
    private int currentCalendarIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_menu);

        setCurrentUser();
        setRecyclerView();
    }

    private void setCurrentUser() {
        Intent intent = getIntent();
        currentUser = (User) intent.getSerializableExtra("currentUser");
        currentUser.setContext(getApplicationContext());
        UserWriter userWriter = new UserWriter();
        currentUser.addObserver(userWriter);
        currentCalendarIndex = (int) intent.getSerializableExtra("currentCalendarIndex");
        currentCalendar = currentUser.getCalendar(currentCalendarIndex);
    }

    private void setRecyclerView() {
        this.recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        this.layoutManager = new LinearLayoutManager(this);
        this.adapter = new GenericAdapter((ArrayList) currentUser.getEventsFromCalendar(currentCalendar));

        recyclerView.setLayoutManager(this.layoutManager);
        recyclerView.setAdapter(this.adapter);

        adapter.setOnClickListener(new GenericAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
                Intent newIntent = new Intent(EventMenuActivity.this, ViewEventDetailsActivity.class);
                Event currentEvent = currentUser.getEventsFromCalendar(currentCalendar).get(i);
                newIntent.putExtra("currentCalendar", currentCalendar);
                newIntent.putExtra("currentUser", currentUser);
                newIntent.putExtra("currentEvent", currentEvent);
                startActivity(newIntent);
            }
        });
    }

    public void openDialog(View view) {
        EventCreationDialog dialog = new EventCreationDialog();
        dialog.show(getSupportFragmentManager(), "event creation dialog");
    }

    @Override
    public void createEvent(String title, String description, LocalDateTime startTime, LocalDateTime endTime) {
        Event event = new Event(title, description, startTime, endTime);
        currentUser.addEventToCalendar(event, currentCalendar);
        adapter.notifyItemInserted(currentUser.getEventsFromCalendar(currentCalendar).size()-1);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent back = new Intent(this, MenuActivity.class);
        back.putExtra("currentUser", currentUser);
        back.putExtra("currentCalendarIndex", currentCalendarIndex);
        startActivity(back);
        return true;
    }
}
