package com.example.expenseapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        //overriding the class method for each activity
        super.onCreate(savedInstanceState);

        //setting xml layout to the dasboard activity which will render of the activity.
        setContentView(R.layout.activity_login_screen);
    }
}
