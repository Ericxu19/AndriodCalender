package com.example.phase2calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.phase2calendar.logic.Memo;
import com.example.phase2calendar.logic.User;

public class MemoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_list);

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("currentUser");

        Button memoBack = findViewById(R.id.memoBack);
        memoBack.setOnClickListener(v -> {
            Intent memoGoBack = new Intent(getApplicationContext(), MenuActivity.class);
            memoGoBack.putExtra("currentUser", user);
            startActivity(memoGoBack);
        });

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
