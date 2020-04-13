package com.example.phase2calendar;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.phase2calendar.logic.Alert;
import com.example.phase2calendar.logic.User;
import com.example.phase2calendar.logic.UserWriter;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserMenuActivity extends AppCompatActivity {

    private User currentUser;
    private ArrayList<Alert> alerts;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);

        Intent intent = getIntent();
        currentUser = (User) intent.getSerializableExtra("currentUser");
        currentUser.setContext(getApplicationContext());
        UserWriter userWriter = new UserWriter();
        currentUser.addObserver(userWriter);

        TextView title = findViewById(R.id.welcome_view);
        title.setText("Welcome, " + currentUser.getUsername() + "!");

        LocalDateTime now = LocalDateTime.now();
        alerts = currentUser.raiseAllAlerts(now);

        Button alertsButton = findViewById(R.id.alerts_button);
        alertsButton.setText(alerts.size() + " New Alerts!");
    }

    public void openMainMenu(View view){
        Intent intent = new Intent(this, MainMenuActivity.class);
        intent.putExtra("currentUser", currentUser);
        startActivity(intent);
    }

    public void showMessages(View view){
        Intent intent = new Intent(this, MessagesActivity.class);
        intent.putExtra("currentUser", currentUser);
        startActivity(intent);
    }

    public void showAlerts(View view){
        Intent intent = new Intent(this, NewAlertsActivity.class);
        intent.putExtra("currentUser", currentUser);
        intent.putExtra("newAlerts", alerts);
        startActivity(intent);
    }
}
