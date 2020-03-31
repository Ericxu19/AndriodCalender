package com.example.phase2calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        Button memoBack = findViewById(R.id.memoBack);
        memoBack.setOnClickListener(v -> {
            Intent memoGoBack = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(memoGoBack);
        });
    }
}
