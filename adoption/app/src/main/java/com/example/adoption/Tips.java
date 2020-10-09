package com.example.adoption;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Tips extends AppCompatActivity {
//Initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        //open drawer
        Homepage.openDrawer(drawerLayout);
    }

    public void Clicklogo(View view){
        //Close drawer
        Homepage.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redirect activity to home
        Homepage.redirectActivity(this,Homepage.class);
    }

    public void ClickDashboard(View view){
        //Recreate activity
        recreate();
    }

    public void ClickAboutUs(View view){
        //redirect activity to about us
        Homepage.redirectActivity(this,hospital.class);
    }

    public void ClickLogout(View view){
        //Close app
        Homepage.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        Homepage.closeDrawer(drawerLayout);

    }
}