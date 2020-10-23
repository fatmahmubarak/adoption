package com.example.adoption;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adoption.Fragrnents.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Login extends AppCompatActivity {
   EditText mEmail,mPassword;
   Button mLoginBtn;
   TextView mCreateBnt;
   ProgressBar progressBar;
   FirebaseAuth fAuth;

   DatabaseReference Datausers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.loginBtn);
        mCreateBnt = findViewById(R.id.createText);
        Datausers = FirebaseDatabase.getInstance().getReference().child("users");


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mPassword.setError("password is Required");
                    return;
                }

                if (password.length() < 6){
                    mPassword.setError("password must be >= 6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // authenticate the user

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Login.this,"Logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Homepage.class));
                    }else {
                        Toast.makeText(Login.this,"Error !"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }

                    }
                }); //end oncomplete


//                final String user = mEmail.getText().toString();
//                if (user != null){
//                    users(user);
//                }


            }
        });



        mCreateBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register.class));
//                Intent intent = new Intent(Login.this,Register.class);
//                startActivity(intent);
            }
        });



    }

//    public class User {
//
//        public String username;
//        public String email;
//
//        public User() {
//            // Default constructor required for calls to DataSnapshot.getValue(User.class)
//        }
//
//        public User(String username, String email) {
//            this.username = username;
//            this.email = email;
//        }
//
//    }
//
//    private void writeNewUser(String userId, String name, String email) {
//        User user = new User(name, email);
//
//        Datausers.child("users").child(userId).setValue(user);
//    }

}