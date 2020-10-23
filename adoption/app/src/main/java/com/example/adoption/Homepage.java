package com.example.adoption;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.adoption.Fragrnents.TipsFragment;
import com.example.adoption.Fragrnents.HomeFragment;
import com.example.adoption.Fragrnents.SettingFragment;
import com.example.adoption.Fragrnents.ClinicsFragment;
import com.google.android.material.navigation.NavigationView;

public class Homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Initialize variable
//    DrawerLayout drawerLayout;
    Toolbar toolbar;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        //Assign variable
//        drawerLayout = findViewById(R.id.drawer_layout);

        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        showFragments(new HomeFragment());
    }

//    private void setSupportActionBar(Toolbar toolbar) {
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();

       if (id == R.id.home){
      showFragments(new HomeFragment());
       }

//        if (id == R.id.work){
//            showFragments(new workFragment());
//                           final Intent intent = new Intent(Homepage.this,MainActivity.class);
//               startActivity(intent);
//        }

        if (id == R.id.school){
            showFragments(new ClinicsFragment());
        }

        if (id == R.id.Call){
            showFragments(new TipsFragment());
        }

//        if (id == R.id.Setting){
//            showFragments(new SettingFragment());
//        }

        mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    private void showFragments(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_Layout, fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    //    public void ClickMenu(View view){
//        //Open drawer
//       openDrawer(drawerLayout);
//    }
//
//    public static void openDrawer(DrawerLayout drawerLayout) {
//        //open drawer layout
//        drawerLayout.openDrawer(GravityCompat.START);
//        }
//
//
//    public void ClickLogo(View view){
//        //close drawer
//        closeDrawer(drawerLayout);
//    }
//
//    public static void closeDrawer(DrawerLayout drawerLayout) {
//        //Close drawer layout
//        //check condition
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
//            //when drawer is open
//            //close drawer
//            drawerLayout.closeDrawer(GravityCompat.START);
//        }
//    }
//
//    public void ClickHome(View view){
//        //recreate activity
//        recreate();
//    }
//
//    public void ClickDashboard(View view){
//        //recreate activity to Dashboard
//        redirectActivity(this,Tips.class);
//    }
//
//    public void ClickAboutUs(View view){
//        //recreate activity to adout us
//        redirectActivity(this,hospital.class);
//    }
//
//    public void ClickLogout(View view){
//        //Close app
//        logout(this);
//    }
//
//    public static void logout(final Activity activity) {
//        //Initialize alert dialog
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        //set title
//        builder.setTitle("logout");
//        //set massage
//        builder.setMessage("Are you sure you want to logout ?");
//        //positive yes button
//        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//            //finish activity
//                activity.finishAffinity();
//            //exit app
//                System.exit(0);
//            }
//        });
//
//        //negative no button
//         builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//             @Override
//             public void onClick(DialogInterface dialog, int which) {
//                 //Dismiss dialog
//                 dialog.dismiss();
//             }
//         });
//         //show dialog
//        builder.show();
//    }
//
//    public static void redirectActivity(Activity activity,Class aClass) {
//        //Initialize intent
//        Intent intent = new Intent(activity,aClass);
//        //set flag
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        //Start activity
//        activity.startActivity(intent);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        //Close drawer
//        closeDrawer(drawerLayout);
//    }
}