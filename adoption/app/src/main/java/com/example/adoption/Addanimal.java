package com.example.adoption;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class Addanimal extends AppCompatActivity {
    private static final int REQUEST_CODE_IMAGE = 101;

    private ImageView imageViewAdd;
    private EditText inputImageName;
    private EditText inputAge;
    private EditText inputColor;
    private EditText inputStrainanimal;
    private EditText inputSexanimal;
    private EditText inputSterile;
    private EditText inputTyep;
    private EditText inputEmail;
//    private EditText mflluname;

    private TextView textViewProgress;
    private ProgressBar progressBar;
    private Button btnUpload;

    Uri imageUri;
    boolean isImageADDed = false;


    DatabaseReference Dataref;
    StorageReference StorageRef;

//    private Object User;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addanimal);

        imageViewAdd = findViewById(R.id.imageVIewAdd);
        inputImageName = findViewById(R.id.inputImageName);
        progressBar = findViewById(R.id.progressBar);
        btnUpload = findViewById(R.id.btnUpload);
        textViewProgress = findViewById(R.id.textViewProgress);
//        mflluname = findViewById(R.id.fullName);
        //nbn
        inputAge = findViewById(R.id.inputage);
        inputColor = findViewById(R.id.coloranimal);
        inputStrainanimal = findViewById(R.id.inputStrainanimal);
        inputSexanimal = findViewById(R.id.inputSexanimal);
        inputSterile = findViewById(R.id.inputSterile);
        inputTyep = findViewById(R.id.inputTyep);
        inputEmail = findViewById(R.id.inputEmail);

        textViewProgress.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);

        Dataref = FirebaseDatabase.getInstance().getReference().child("animal");
        StorageRef = FirebaseStorage.getInstance().getReference().child("AnimalImage");




//       textView= view.findViewById(R.id.wordTxt);
//        textView.setText("work Fragment");





        imageViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,REQUEST_CODE_IMAGE);
            }
        });


        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String imageName =inputImageName.getText().toString();
                //انا زايدتها مع اللي تحت الاند
                final String Ageanimal = inputAge.getText().toString();
                final String Coloranimal = inputColor.getText().toString();
                final String Strainanimal = inputStrainanimal.getText().toString();
                final String Sexanimal = inputSexanimal.getText().toString();
                final String Sterile = inputSterile.getText().toString();
                final String Tyep = inputTyep.getText().toString();
                final String Email = inputEmail.getText().toString();
//                final String name = mflluname.getText().toString();
                if (isImageADDed != false && imageName!= null && Ageanimal != null && Coloranimal != null && Strainanimal != null && Sexanimal != null && Sterile != null && Tyep != null && Email != null){
                    uploadImage(imageName,Ageanimal,Coloranimal,Strainanimal,Sexanimal,Sterile,Tyep,Email);
                }
//                Intent n = new Intent(Addanimal.this , PageAnimal.class);
//                n.putExtra("name",imageName);
//                n.putExtra("age",Ageanimal);
//                n.putExtra("color",Coloranimal);

//                startActivity(n);
            }
        });

    }


    private void uploadImage(final String imageName, final String Ageanimal , final String Coloranimal , final String Strainanimal, final String Sexanimal, final String Sterile , final String Type, final  String Email) {

        textViewProgress.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);

        final String key = Dataref.push().getKey();
        StorageRef.child(key+".jpg").putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                StorageRef.child(key+".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("animalName",imageName);
                        hashMap.put("Age",Ageanimal);
                        hashMap.put("color",Coloranimal);
                        hashMap.put("Strainanimal",Strainanimal);
                        hashMap.put("Sexanimal",Sexanimal);
                        hashMap.put("Sterile",Sterile);
                        hashMap.put("type",Type);
                        hashMap.put("Email",Email);
                        hashMap.put("ImageUrl",uri.toString());

                        Dataref.child(key).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startActivity(new Intent(getApplicationContext(),Homepage.class));
                            }
                        });


                    }
                });


//                Dataref.child("User").child("animal");
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (taskSnapshot.getBytesTransferred()*100)/taskSnapshot.getTotalByteCount();
                progressBar.setProgress((int) progress);
                textViewProgress.setText(progress+"%");
            }
        });




    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE_IMAGE && data!=null){
            imageUri = data.getData();
            isImageADDed = true;
            imageViewAdd.setImageURI(imageUri);
        }
    }
}