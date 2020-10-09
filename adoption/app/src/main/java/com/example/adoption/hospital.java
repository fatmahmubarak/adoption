package com.example.adoption;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class hospital extends AppCompatActivity {
    //Initialize variale
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

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
        //redirect activity to dashboard
        Homepage.redirectActivity(this,Tips.class);
    }

    public void ClickAboutUs(View view){
        //Recreate activity
        recreate();

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
