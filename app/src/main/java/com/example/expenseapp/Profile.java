package com.example.expenseapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Profile extends AppCompatActivity {
    DrawerLayout drawerLayout;

    protected void onCreate(Bundle savedInstanceState) {
        //overriding the class method for each activity
        super.onCreate(savedInstanceState);

        //setting xml layout to the dasboard activity which will render of the activity.
        setContentView(R.layout.activity_profile);
        drawerLayout = findViewById(R.id.drawer_layout);
    }
    //Navigation to menu
    public void ClickMenu(View v){
        //Oped drawer
        Dashboard.openDrawer(drawerLayout);
    }

    //Method for openning the navigation drawer
    private static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    //Navigation to edit profile layout
    public void ClickProfile(View v) {
        Dashboard.closeDrawer(drawerLayout);
    }


    //Closing the navigation drawer
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
        Dashboard.redirectActivity(this,Dashboard.class);
    }

    //Navigation to home screen
    public void ClickHome(View v){
        //Recreate activity
        Dashboard.redirectActivity(this,HomeScreen.class);

    }

    //Navigation to dashboard
    public void ClickDashboard(View v) {
        //Redirect activity to dashboard
        recreate();

    }


    //closing the app if the user chose to logout
    public void ClickLogout(View v) {
        //close app
        Dashboard.logout(this);
    }

    //exit from the navigation drawer
    protected void onPause() {
        super.onPause();
        //Close drawer
        Dashboard.closeDrawer(drawerLayout);
    }



}

