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
import android.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class Register extends AppCompatActivity {
  private EditText mfullName,mEmail,mPassword,mPhone;
   Button mRegisterBtn;
   TextView mloginBut;
   private FirebaseAuth fAuth;
   ProgressBar progressBar;
    DatabaseReference Datauser;
//    DatabaseReference mfullNamee;

//    private String userId;

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



        Datauser = FirebaseDatabase.getInstance().getReference().child("User");
//        mfullNamee = FirebaseDatabase.getInstance().getReference();
//        Datauser.child("User").child().child("animal").setValue();
//        Dataanimal = FirebaseDatabase.getInstance().getReference().child("animals");


//      if (fAuth.getCurrentUser() != null){
//          startActivity(new Intent(getApplicationContext(),Register.class));
//          finish();
//      }


//        final String key = Datauser.push().getKey();
//        final String UserId = mfullNamee.push().getKey();
      mRegisterBtn.setOnClickListener(new View.OnClickListener() {//onClick start

          @Override
          public void onClick(View view) {

              final String email = mEmail.getText().toString().trim();
              final String password = mPassword.getText().toString().trim();
              final String userId = mfullName.getText().toString().trim();

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

//                     Datauser.child(key).setValue(userId).addOnSuccessListener(new OnSuccessListener<Void>() {
//                         @Override
//                         public void onSuccess(Void aVoid) {
//                             startActivity(new Intent(getApplicationContext(),Homepage.class));
//                         }
//                     });
//                     HashMap hashMap = new HashMap();
//                     hashMap.put("name",mfullName);


               //      FirebaseRecyclerOptions<Addanimal>options=new FirebaseRecyclerOptions.Builder<Addanimal>().setQuery(Datauser = FirebaseDatabase.getInstance().getReference().child("animal"),Addanimal.class ).build();


//                     Animal animal = new Animal();
//                     User user = new User(password, email);
//                     Datauser.child("users").child(userId).setValue();



//              Datauser.child("User").child(userId).child("animal");
//                     Datauser.child("User").setValue(UserId);

//                     User user = new User(
//                             mfullName
////                             mEmail,
////                             mPhone
//                     );
//                     FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                         @Override
//                         public void onComplete(@NonNull Task<Void> task) {
//                             progressBar.setVisibility(View.VISIBLE);
//                             if (task.isSuccessful()){
//                                 Toast.makeText(Register.this,getString( R.string.registration_success), Toast.LENGTH_SHORT).show();
//                             }else {
//
//                             }
//                         }
//                     });



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
//                Intent intent = new Intent(Register.this,Login.class);
//                startActivity(intent);
            }
        });
    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        if (fAuth.getCurrentUser() != null){
//
//        }
//    }
}