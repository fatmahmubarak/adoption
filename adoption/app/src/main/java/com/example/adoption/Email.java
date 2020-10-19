package com.example.adoption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends AppCompatActivity {
   private EditText mEditTextTo;
   private EditText mEditTextSubject;
   private EditText mEditTextMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
       mEditTextTo = findViewById(R.id.edit_text_to);
        mEditTextSubject = findViewById(R.id.edit_text_subject);
         mEditTextMessage = findViewById(R.id.edit_text_message);

        Button buttonSend = findViewById(R.id.button_send);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });

        Bundle a = getIntent().getExtras();

        String e = a.getString("Email");
        mEditTextTo.setText(e);
    }

    private void sendMail (){
        //حط اللي يبي يندز له مو البائع
        String recipientList = mEditTextTo.getText().toString();
        String[] recipients = recipientList.split(",");
        //example1@gmail.com , example2@gmail.com , example3@gmail.com

        String subject = mEditTextSubject.getText().toString();
        String message = mEditTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        intent.setType("massage/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));


    }
}