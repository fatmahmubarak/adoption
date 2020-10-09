package com.example.adoption;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
   EditText mfullName,mEmail,mPassword,mPhone;
   Button mRegisterBtn;
   TextView mloginBut;
   FirebaseAuth fAuth;
   ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

      mfullName = findViewById(R.id.fullName);
      mEmail = findViewById(R.id.Email);
      mPassword = findViewById(R.id.password);
      mPhone = findViewById(R.id.phone);
      mRegisterBtn = findViewById(R.id.registerBut);
      mloginBut = findViewById(R.id.createText);

      fAuth =FirebaseAuth.getInstance();
      progressBar = findViewById(R.id.progressBar);

      if (fAuth.getCurrentUser() != null){
          startActivity(new Intent(getApplicationContext(),MainActivity.class));
          finish();
      }



      mRegisterBtn.setOnClickListener(new View.OnClickListener() {//onClick start
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

             // register the user in firebase

             fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() { // start oncomplete
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                 if (task.isSuccessful()){
                     Toast.makeText(Register.this,"user created", Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(getApplicationContext(),Homepage.class));
                 }else {
                     Toast.makeText(Register.this,"Error !"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                     progressBar.setVisibility(View.GONE);
                 }


                 }
             }); //end oncomplete

          }
      });//onClick end



        mloginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });



    }
}