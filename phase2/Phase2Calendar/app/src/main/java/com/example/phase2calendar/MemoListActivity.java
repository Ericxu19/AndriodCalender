package com.example.phase2calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.phase2calendar.logic.User;

public class MemoListActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_list);

        Intent intent = getIntent();
        this.user = (User) intent.getSerializableExtra("currentUser");

        //Creates back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent back = new Intent(this, MenuActivity.class);
        back.putExtra("currentUser", user);
        startActivity(back);
        return true;
    }

    public void goToMemo(View view) {
        EditText memoNum = findViewById(R.id.memoNum);
        int memoInt = Integer.parseInt(memoNum.getText().toString());
        Intent toMemo = new Intent(this, MemoActivity.class);
        toMemo.putExtra("memoNum", memoInt);
        startActivity(toMemo);
    }

    public void newMemo(View view) {
        Intent newMemo = new Intent(this, NewMemoActivity.class);
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("currentUser");
        newMemo.putExtra("user", user);
        startActivity(newMemo);
    }
}
