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
    public void ClickMenu(View v){
        //Oped drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickProfile(View v) {
        closeDrawer(drawerLayout);
    }

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

    public static void logout(Activity activity) {

        //alert the dialog for user's choice
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //set title
        builder.setTitle("Logout");

        //set message
        builder.setMessage("Are you sure you want to logout ?");

        //If the user say yes just exit
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();

                System.exit(0);
            }
        });
        //If the user say no
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        Intent intent = new Intent(activity,aClass);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //start activity
        activity.startActivity(intent);
    }

    protected void onPause() {
        super.onPause();
        //Close drawer
        closeDrawer(drawerLayout);
    }



}
