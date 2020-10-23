package com.example.adoption;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Tips_activity extends AppCompatActivity {
    GifImageView imageView;
    TextView name;
    TextView Tips;
    String namee;
    String Tipss;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_activity);
        imageView = (GifImageView) findViewById(R.id.image);
        name = findViewById(R.id.name);
        Tips = findViewById(R.id.tips);

        namee = getIntent().getStringExtra("name");
        Tipss = getIntent().getStringExtra("Tips");
        image = getIntent().getIntExtra("image",0);

        name.setText(namee);
        Tips.setText(Tipss);
        imageView.setImageResource(image);
    }
}