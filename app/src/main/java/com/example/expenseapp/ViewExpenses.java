package com.example.expenseapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

import lecho.lib.hellocharts.view.PieChartView;

public class ViewExpenses extends AppCompatActivity {

    DrawerLayout drawerLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_expenses);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
        PieChartView pieChartView = findViewById(R.id.chart);

        pieChartView = findViewById(R.id.chart);

        //initialize the data for displaying the Android pie chart.
        List pieData = new ArrayList<>();

        // Adding the data inside the pieData
        pieData.add(new SliceValue(15, Color.BLUE).setLabel("Gas"));
        pieData.add(new SliceValue(25, Color.YELLOW).setLabel("Food"));
        pieData.add(new SliceValue(10, Color.RED).setLabel("Cloting"));
        pieData.add(new SliceValue(60, Color.GREEN).setLabel("Bills"));


        // passing the data inside the model
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Expense Chart").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);
    }

    public void ClickMenu(View v){
        //Oped drawer
        Dashboard.openDrawer(drawerLayout);
    }

    private static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickProfile(View v) {
        Dashboard.closeDrawer(drawerLayout);
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


    public void ClickViewExpense(View v) {
        recreate();
    }



    public void ClickHome(View v){
        //Recreate activity
        Dashboard.redirectActivity(this,Dashboard.class);
    }

    public void ClickDashboard(View v) {
        //Redirect activity to dashboard
        Dashboard.redirectActivity(this,Profile.class);
    }


    public void ClickLogout(View v) {
        //close app
        Dashboard.logout(this);
    }

    protected void onPause() {
        super.onPause();
        //Close drawer
        Dashboard.closeDrawer(drawerLayout);
    }



}

