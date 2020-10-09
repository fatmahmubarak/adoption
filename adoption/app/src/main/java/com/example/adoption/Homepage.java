package com.example.adoption;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Homepage extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);



    }

    public void ClickMenu(View view){
        //Open drawer
       openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
        }


    public void ClickLogo(View view){
        //close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close drawer layout
        //check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //when drawer is open
            //close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //recreate activity
        recreate();
    }

    public void ClickDashboard(View view){
        //recreate activity to Dashboard
        redirectActivity(this,Tips.class);
    }

    public void ClickAboutUs(View view){
        //recreate activity to adout us
        redirectActivity(this,hospital.class);
    }

    public void ClickLogout(View view){
        //Close app 
        logout(this);
    }

    public static void logout(final Activity activity) {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //set title
        builder.setTitle("logout");
        //set massage
        builder.setMessage("Are you sure you want to logout ?");
        //positive yes button
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            //finish activity
                activity.finishAffinity();
            //exit app
                System.exit(0);
            }
        });

        //negative no button
         builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 //Dismiss dialog
                 dialog.dismiss();
             }
         });
         //show dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity,aClass);
        //set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closeDrawer(drawerLayout);
    }
}