package com.example.phase2calendar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.phase2calendar.dialogs.EventCreationDialog;
import com.example.phase2calendar.dialogs.MemoCreationDialog;
import com.example.phase2calendar.logic.Calendar;
import com.example.phase2calendar.logic.DateFormatConverter;
import com.example.phase2calendar.logic.Event;
import com.example.phase2calendar.logic.Memo;
import com.example.phase2calendar.logic.User;
import com.example.phase2calendar.logic.UserWriter;

import java.time.LocalDateTime;

public class ViewMemoDetailsActivity extends AppCompatActivity{
    private User currentUser;
    private Calendar currentCalendar;
    private int currentCalendarIndex;
    private Memo currentMemo;
    private int currentMemoIndex;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_memo_details);
        setCurrentUser();
        setMemoInfo();
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setMemoInfo() {
        TextView titleView = findViewById(R.id.title_view_memo);
        TextView descriptionView = findViewById(R.id.description_view_memo);

        DateFormatConverter converter = new DateFormatConverter();

        titleView.setText(currentMemo.getName());
        descriptionView.setText(currentMemo.getDescription());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void openDialog(View view) {
        MemoCreationDialog dialog = new MemoCreationDialog();
        Bundle args = new Bundle();
        args.putString("title", currentMemo.getName());
        args.putString("description", currentMemo.getDescription());
        dialog.setArguments(args);
        dialog.show(getSupportFragmentManager(), "memo creation dialog");
    }

    public void viewEvents(View view){

    }

    public void deleteMemo(View view) {
        currentUser.removeMemoFromCalendar(currentMemo, currentCalendar);
        Intent intent = new Intent(this, MemoListActivity.class);
        intent.putExtra("currentUser", currentUser);
        intent.putExtra("currentCalendarIndex", currentCalendarIndex);
        startActivity(intent);
    }

    public boolean onSupportNavigateUp() {
        Intent back = new Intent(this, MemoListActivity.class);
        back.putExtra("currentUser", currentUser);
        back.putExtra("currentCalendarIndex", currentCalendarIndex);
        startActivity(back);
        return true;
    }
}
