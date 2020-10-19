package com.example.adoption;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class PageAnimal extends AppCompatActivity {
    private ImageView imageView;
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    Button button;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_animal);

       imageView = findViewById(R.id.image_single_view_Activity);
       textView = findViewById(R.id.textView_single_view_activity);
       textView2 = findViewById(R.id.textView2_single_view_activity);
       textView3 = findViewById(R.id.textView3_single_view_activity);
       textView4 = findViewById(R.id.textView4_single_view_activity);
       textView5 = findViewById(R.id.textView5_single_view_activity);
       textView6 = findViewById(R.id.textView6_single_view_activity);
       textView7 = findViewById(R.id.textView7_single_view_activity);
       textView8 = findViewById(R.id.textView8_single_view_activity);
       button = findViewById(R.id.button);

       ref = FirebaseDatabase.getInstance().getReference().child("animal");

       String Animalkey = getIntent().getStringExtra("Animalkey");
       ref.child(Animalkey).addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()){
                String animalName = dataSnapshot.child("animalName").getValue().toString();
                String Ageanimal = dataSnapshot.child("Age").getValue().toString();
                String ImageUrl = dataSnapshot.child("ImageUrl").getValue().toString();
                String color = dataSnapshot.child("color").getValue().toString();
                String Strainanimal = dataSnapshot.child("Strainanimal").getValue().toString();
                String Sexanimal = dataSnapshot.child("Sexanimal").getValue().toString();
                String Sterile = dataSnapshot.child("Sterile").getValue().toString();
                String Type = dataSnapshot.child("type").getValue().toString();
                String Email = dataSnapshot.child("Email").getValue().toString();
                Picasso.get().load(ImageUrl).into(imageView);
                textView.setText(animalName);
                textView2.setText(Ageanimal);
                textView3.setText(color);
                textView4.setText(Strainanimal);
                textView5.setText(Sexanimal);
                textView6.setText(Sterile);
                textView7.setText(Type);
                textView8.setText(Email);
            }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = textView8.getText().toString();

                Intent n = new Intent(PageAnimal.this , Email.class);
                n.putExtra("Email",Email);

                startActivity(n);
            }
        });


    }
}