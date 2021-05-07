package com.example.expenseapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Dashboard extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;
    Activity activity;


    protected void onCreate(Bundle savedInstanceState) {
        //overriding the class method for each activity
        super.onCreate(savedInstanceState);

        //setting xml layout to the dasboard activity which will render of the activity.
        setContentView(R.layout.activity_dashboard);

        //setting up the date
        TextView view=findViewById(R.id.date);
        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd");
        String currentDate = date.format(new Date());
        view.setText(currentDate);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    //Navigation to menu
    public void ClickMenu(View v){
        //Oped drawer
        openDrawer(drawerLayout);
    }

    //method for openning the navigation drawer
    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    //Navigation to edit profile layout
    public void ClickProfile(View v) {
        closeDrawer(drawerLayout);
    }


    // Closing the navigation drawer
    public static void closeDrawer(DrawerLayout drawerLayout) {

        //Close drawer Layout
        //Check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            // When drawe is open
            //close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }


    //Navigation to view expense screen
    public void ClickViewExpense(View v) {
        // Redirect activity
        redirectActivity(this,ViewExpenses.class);
    }


    //Navigation to view home screen
    public void ClickHome(View v){
        //Redirct activity
        redirectActivity(this,HomeScreen.class);
    }

    //Navigation to dashboard screen
    public void ClickDashboard(View v) {
        //Redirect activity to dashboard
        redirectActivity(this,Profile.class);
    }


    //Navigation to logout
    public void ClickLogout(View v) {
        //close app
        logout(this);
    }

    //Method for setting the logout activity and determinning user's choice
    public static void logout(Activity activity) {

        //alert the dialog for user's choice
        AlertDialog.Builder alertMsg= new AlertDialog.Builder(activity);
        //set title
        alertMsg.setTitle("Logout");

        //set the message
        alertMsg.setMessage("Are you sure you want to logout ?");

        //If the user choose to say yes just exit
        alertMsg.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();

                System.exit(0);
            }
        });
        //If the user choose to say no
        alertMsg.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertMsg.show();
    }

    //redirecting activities
    public static void redirectActivity(Activity activity, Class aClass) {
        Intent intent = new Intent(activity,aClass);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //start activity
        activity.startActivity(intent);
    }

    //exiting from the navigation drawer
    protected void onPause() {
        super.onPause();
        //Close drawer
        closeDrawer(drawerLayout);
    }



}
