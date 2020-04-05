package com.example.phase2calendar;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.phase2calendar.adapters.GenericAdapter;
import com.example.phase2calendar.adapters.MessageAdapter;
import com.example.phase2calendar.dialogs.CalendarCreationDialog;
import com.example.phase2calendar.logic.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainMenuActivity extends AppCompatActivity implements CalendarCreationDialog.CalendarCreationDialogListener {

    private RecyclerView recyclerView;
    private GenericAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private User currentUser;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Intent intent = getIntent();
        currentUser = (User) intent.getSerializableExtra("currentUser");
        currentUser.setContext(getApplicationContext());
        UserWriter userWriter = new UserWriter();
        currentUser.addObserver(userWriter);

        this.recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        this.layoutManager = new LinearLayoutManager(this);
        this.adapter = new GenericAdapter((ArrayList) currentUser.getCalendarsList());

        recyclerView.setLayoutManager(this.layoutManager);
        recyclerView.setAdapter(this.adapter);

        adapter.setOnClickListener(new GenericAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
                Intent newIntent = new Intent(MainMenuActivity.this, MenuActivity.class);
                Calendar currentCalendar = currentUser.getCalendarsList().get(i);
                newIntent.putExtra("currentCalendar", currentCalendar);
                newIntent.putExtra("currentUser", currentUser);
                startActivity(newIntent);
            }
        });
    }

    public void openDialog(View view) {
        CalendarCreationDialog dialog = new CalendarCreationDialog();
        dialog.show(getSupportFragmentManager(), "calendar creation dialog");
    }

    @Override
    public void createCalendar(String title, String description) {
        Calendar cal = new Calendar(title, description);
        currentUser.addCalendar(cal);
        adapter.notifyItemInserted(currentUser.getCalendarsList().size()-1);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent back = new Intent(this, UserMenuActivity.class);
        back.putExtra("currentUser", currentUser);
        startActivity(back);
        return true;
    }
}
