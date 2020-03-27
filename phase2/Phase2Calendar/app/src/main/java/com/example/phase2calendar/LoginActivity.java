package com.example.phase2calendar;

import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.phase2calendar.logic.LoginValidator;
import com.example.phase2calendar.logic.User;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginUser() {
        EditText usernameField = findViewById(R.id.editText);
        EditText passwordField = findViewById(R.id.editText2);
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        LoginValidator loginValidator = new LoginValidator();
        User currentUser = loginValidator.validate(username, password);
        if(currentUser == null){
            // Incorrect credentials
        } else {
            // Successful login
        }
    }
}
