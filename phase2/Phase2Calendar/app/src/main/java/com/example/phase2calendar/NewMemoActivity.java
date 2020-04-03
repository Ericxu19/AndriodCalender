package com.example.phase2calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.phase2calendar.logic.Memo;
import com.example.phase2calendar.logic.User;

public class NewMemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_memo);
    }

    public void createMemo (View view) {
        EditText memoNameField = findViewById(R.id.eventName);
        EditText memoDescriptionField = findViewById(R.id.eventDescription);
        String memoName = memoNameField.getText().toString();
        String memoDescription = memoDescriptionField.getText().toString();

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        Memo memo = new Memo(memoName, memoDescription);
        //user.addMemoToCalendar(memo, user.getCurrentCalender);
    }
}
