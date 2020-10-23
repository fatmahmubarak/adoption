package com.example.adoption.Fragrnents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.adoption.Homepage;
import com.example.adoption.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class workFragment extends Fragment {
    private static final int REQUEST_CODE_IMAGE = 101;
    View view;
//    TextView textView;
    private ImageView imageViewAdd;
    private EditText inputImageName;
    private EditText inputAge;
    private EditText inputColor;
    private TextView textViewProgress;
    private ProgressBar progressBar;
    private Button btnUpload;


    Uri imageUri;
    boolean isImageADDed = false;


    DatabaseReference Dataref;
    DatabaseReference DataAge;
    StorageReference StorageRef;



    public workFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_work, container, false);

         imageViewAdd = view.findViewById(R.id.imageVIewAdd);
         inputImageName = view.findViewById(R.id.inputImageName);
        progressBar = view.findViewById(R.id.progressBar);
        btnUpload = view.findViewById(R.id.btnUpload);
        textViewProgress = view.findViewById(R.id.textViewProgress);
         //nbn
         inputAge = view.findViewById(R.id.inputage);
         inputColor = view.findViewById(R.id.coloranimal);



         textViewProgress.setVisibility(View.GONE);
         progressBar.setVisibility(View.GONE);

        Dataref = FirebaseDatabase.getInstance().getReference().child("animal");
        StorageRef = FirebaseStorage.getInstance().getReference().child("AnimalImage");
        DataAge = FirebaseDatabase.getInstance().getReference().child("Age");


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
             if (isImageADDed != false && imageName!= null && Ageanimal != null){
                 uploadImage(imageName,Ageanimal);
             }
            }
        });

        return view;
    }

    private void uploadImage(final String imageName, final String Ageanimal) {

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
                        hashMap.put("ImageUrl",uri.toString());

                        Dataref.child(key).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

//                                Intent intent = new Intent(intent.GetApplicationContext(), HomeFragment.class);
//                                startActivity(intent);
//                                startActivity(new Intent(getApplicationContext(),HomeFragment.class));
                                Intent i= new Intent(workFragment.this.getActivity(), Homepage.class);
                                startActivity(i);
                                //Toast.makeText(workFragment.this.getActivity(), "Data Successfully Uploaded!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
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