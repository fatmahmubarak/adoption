package com.example.adoption;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.ClosedSubscriberGroupInfo;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
 Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView name = findViewById(R.id.textView);
//
//        Bundle a = getIntent().getExtras();
//        String m = a.getString("name");
//        name.setText(m);

//        button = (Button) findViewById(R.id.button);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openRegister();
//
//            }
//        });

    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();//logout
      startActivity(new Intent(getApplicationContext(), Login.class));
      finish();
    }

//    public void logout(View view){
//        FirebaseAuth.getInstance().signOut();
//        startActivity(new Intent(getApplicationContext(),login.class));
//        finish();
//    }


//    public void openRegister(){
//        Intent intent = new Intent(this,Register.class);
//        startActivity(intent);
//
//    }
}