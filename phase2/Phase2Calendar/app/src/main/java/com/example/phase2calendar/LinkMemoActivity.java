package com.example.phase2calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.phase2calendar.adapters.GenericAdapter;
import com.example.phase2calendar.adapters.HighlightAdapter;
import com.example.phase2calendar.logic.Calendar;
import com.example.phase2calendar.logic.Event;
import com.example.phase2calendar.logic.Memo;
import com.example.phase2calendar.logic.User;
import com.example.phase2calendar.logic.UserWriter;

import java.util.ArrayList;

public class LinkMemoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GenericAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private User currentUser;
    private Memo currentMemo;
    private Calendar currentCalendar;
    private int currentCalendarIndex;
    private int currentMemoIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_memo);

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
        currentMemoIndex = (int) intent.getSerializableExtra("currentMemoIndex");
        currentMemo = currentCalendar.getMemos().get(currentMemoIndex);
    }

    private void setRecyclerView() {
        this.recyclerView = findViewById(R.id.LinkEvents);
        recyclerView.setHasFixedSize(true);
        this.layoutManager = new LinearLayoutManager(this);
        this.adapter = new GenericAdapter((ArrayList) currentUser.getEventsFromCalendar(currentCalendar));

        recyclerView.setLayoutManager(this.layoutManager);
        recyclerView.setAdapter(this.adapter);

        adapter.setOnClickListener(new GenericAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
                currentUser.getEventsFromCalendar(currentCalendar).get(i).setMemo(currentMemo);
                Intent newIntent = new Intent(LinkMemoActivity.this, ViewMemoDetailsActivity.class);
                Memo currentMemo = currentUser.getMemosFromCalendar(currentCalendar).get(i);
                newIntent.putExtra("currentCalendarIndex", currentCalendarIndex);
                newIntent.putExtra("currentUser", currentUser);
                newIntent.putExtra("currentMemoIndex", i);
                startActivity(newIntent);
            }
        });
    }
}
