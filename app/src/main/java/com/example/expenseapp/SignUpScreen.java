package com.example.expenseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class SignUpScreen extends AppCompatActivity {

   Button submitButton;

    protected void onCreate(Bundle savedInstanceState) {
        //overriding the class method for each activity
        super.onCreate(savedInstanceState);

        //setting xml layout to the signning up activity which will render of the activity.
        setContentView(R.layout.activity_sign_up_screen);
        submitButton = findViewById(R.id.submitButton);

        // listener method for specifying the events after clicking a widget
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpScreen.this, Dashboard.class));
                finish();
            }
        });
    }
}