package com.example.expenseapp;

import android.app.slice.Slice;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

import androidx.annotation.RequiresApi;
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
        PieChartView pieChart = findViewById(R.id.chart);

        pieChart = findViewById(R.id.chart);

        //initialize the data for displaying the Android pie chart.
        List pieData = new ArrayList<>();
        // Adding the data inside the pieData
        pieData.add(new SliceValue(20, Color.BLUE).setLabel("Shopping 20%"));
        pieData.add(new SliceValue(20, Color.YELLOW).setLabel("Food 10%"));
        pieData.add(new SliceValue(10, Color.RED).setLabel("Gas 10 %"));
        pieData.add(new SliceValue(50, Color.GREEN).setLabel("Bills 50%"));


        // passing the data inside the model
        PieChartData data= new PieChartData(pieData);

        //Setting the size of the string
        data.setHasLabels(true).setValueLabelTextSize(14);

        //Setting the size/color of the string inside the char
        data.setHasCenterCircle(true).setCenterText1("Expense Chart").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChart.setPieChartData(data);

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

