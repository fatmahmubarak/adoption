package com.example.adoption.Fragrnents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adoption.Clinics;
import com.example.adoption.R;
import com.example.adoption.RecyclerViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClinicsFragment extends Fragment {

    View view;
//    TextView textView;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager LayoutManager;
    RecyclerViewAdapter recyclerViewAdapter;


//    int []arr = (R.drawable.btnlogin);

    public ClinicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_school, container, false);
//        textView= view.findViewById(R.id.schoolTxt);
//        textView.setText("Ciinics Fragment");
         recyclerView= view.findViewById(R.id.recylerView);

         //حطيت thisبدالها get
         LayoutManager = new GridLayoutManager(getActivity(),2);
         recyclerView.setLayoutManager(LayoutManager);
//        recyclerViewAdapter = new RecyclerViewAdapter(Clinics);
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerView.setHasFixedSize(true);


        ArrayList<Clinics> clinics = new ArrayList<>();
        Clinics c1 = new Clinics( "مستشفى بيت الحيوان البيطري" ,"234567",R.drawable.animal);
        Clinics c2 = new Clinics( "مستشفى بيت الحيوان البيطري" ,"234567",R.drawable.animal);

        clinics.add(c1);
        clinics.add(c2);
         return view;
    }
}