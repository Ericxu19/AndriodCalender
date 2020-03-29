package com.example.phase2calendar;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.phase2calendar.logic.LoginValidator;
import com.example.phase2calendar.logic.User;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //TODO: show popups
    }

    public void loginUser(View view) {
        EditText usernameField = findViewById(R.id.editText);
        EditText passwordField = findViewById(R.id.editText2);
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        LoginValidator loginValidator = new LoginValidator();
        User currentUser = loginValidator.validate(username, password);
        if(currentUser == null){
            // Incorrect login credentials
            Intent intent = new Intent(this, LoginActivity.class);
            ArrayList<String> popups = new ArrayList<>();
            popups.add("Your login credentials are incorrect");
            intent.putExtra("com.example.phase2calendar.popups", popups);
            startActivity(intent);
        } else {
            // Successful login
            Intent intent = new Intent(this, MainMenuActivity.class);
            intent.putExtra("currentUser", currentUser);
            startActivity(intent);
        }
    }
}
