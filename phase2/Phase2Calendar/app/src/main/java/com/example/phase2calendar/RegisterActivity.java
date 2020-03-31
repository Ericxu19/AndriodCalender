package com.example.phase2calendar;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.phase2calendar.logic.User;
import com.example.phase2calendar.logic.UserManager;

import java.io.IOException;
import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void registerUser(View view) throws IOException {
        UserManager userManager = new UserManager();
        String pattern = "^[A-Za-z0-9]+$";
        EditText usernameField = (EditText) findViewById(R.id.editText);
        EditText passwordField = (EditText) findViewById(R.id.editText2);
        EditText confirmPasswordField = (EditText) findViewById(R.id.editText3);
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        String confirmPassword = confirmPasswordField.getText().toString();

        ArrayList<String> popups = new ArrayList<>();
        Intent intent = new Intent(this, RegisterActivity.class);

        if(username.length() == 0 || password.length() == 0){
            popups.add("Username and password cannot be empty");
            intent.putExtra("com.example.phase2calendar.popups", popups);
        }
        else if(!username.matches(pattern)){
            popups.add("Username must only contain letters and numbers");
            intent.putExtra("com.example.phase2calendar.popups", popups);
        }
        else if(!password.equals(confirmPassword)){
            popups.add("Passwords must match");
            intent.putExtra("com.example.phase2calendar.popups", popups);
        } else {
            Object[] res = userManager.createUser(username, password);
            if(!(boolean) res[1]){
                popups.add("This username is already in use");
                intent.putExtra("com.example.phase2calendar.popups", popups);
            } else {
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("currentUser", (User) res[0]);
            }
        }
        startActivity(intent);
    }
}
