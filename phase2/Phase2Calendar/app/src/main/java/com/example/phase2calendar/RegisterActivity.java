package com.example.phase2calendar;

import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.phase2calendar.logic.UserManager;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void registerUser() throws IOException {
        UserManager userManager = new UserManager();
        String pattern = "^[A-Za-z0-9]+$";
        EditText usernameField = (EditText) findViewById(R.id.editText);
        EditText passwordField = (EditText) findViewById(R.id.editText2);
        EditText confirmPasswordField = (EditText) findViewById(R.id.editText3);
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        String confirmPassword = confirmPasswordField.getText().toString();

        if(username.length() == 0 || password.length() == 0 || confirmPassword.length() == 0){
            // All must be >0 length
        }
        else if(!username.matches(pattern)){
            // Username must have only these characters
        }
        else if(!password.equals(confirmPassword)){
            // Passwords must match
        } else {
            Object[] res = userManager.createUser(username, password);
            if(!(boolean) res[1]){
                // This username is already in use
            } else {
                // Account creation successful
            }
        }
    }
}
