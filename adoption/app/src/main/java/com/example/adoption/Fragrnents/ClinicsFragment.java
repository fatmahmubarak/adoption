package com.example.adoption.Fragrnents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adoption.Clinics;
import com.example.adoption.ClinicsAdapter;
import com.example.adoption.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClinicsFragment extends Fragment {

    View view;
//    TextView textView;
   // RecyclerView recyclerView;
//    RecyclerView.LayoutManager LayoutManager;
//    RecyclerViewAdapter recyclerViewAdapter;


//    int []arr = (R.drawable.btnlogin);

    public ClinicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_school, container, false);

         RecyclerView recyclerView= view.findViewById(R.id.recylerView);
         recyclerView.setHasFixedSize(true);

         RecyclerView.LayoutManager lm = new LinearLayoutManager(this.getActivity());
         recyclerView.setLayoutManager(lm);

       // recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(),DividerItemDecoration.VERTICAL));


         //حطيت thisبدالها get
//         LayoutManager = new GridLayoutManager(getActivity(),2);
//         recyclerView.setLayoutManager(LayoutManager);
//        recyclerViewAdapter = new RecyclerViewAdapter();
//        recyclerView.setAdapter(recyclerViewAdapter);

//        recyclerView.setHasFixedSize(true);


        ArrayList<Clinics> clinics = new ArrayList<>();
        Clinics c1 = new Clinics( "مستشفى بيت الانماء البيطري" ,"25746467",R.drawable.veterinary,"29.3023708,47.5356604,9");
        Clinics c2 = new Clinics( "مستشفى رويال للحيوانات الأليفة" ,"99856696",R.drawable.veterinary,"29.3070514,47.5356861,9z");
        Clinics c3 = new Clinics( "مستشفى بيطري" ,"90950101",R.drawable.veterinary,"29.3093918,47.535699,9z");
        Clinics c4 = new Clinics( "طبيب بيطرى" ,"65703624",R.drawable.veterinary,"29.3117324,47.5357119,9z");
        Clinics c5 = new Clinics( "مستشفى بيت الانماء البيطري" ,"25746467",R.drawable.veterinary,"29.3023708,47.5356604,9");
        Clinics c6 = new Clinics( "مستشفى رويال للحيوانات الأليفة" ,"99856696",R.drawable.veterinary,"29.3070514,47.5356861,9z");
        Clinics c7 = new Clinics( "مستشفى بيطري" ,"90950101",R.drawable.veterinary,"29.3093918,47.535699,9z");
        Clinics c8 = new Clinics( "طبيب بيطرى" ,"65703624",R.drawable.veterinary,"29.3117324,47.5357119,9z");
        //29.3117324,47.5357119,9z

        clinics.add(c1);
        clinics.add(c2);
        clinics.add(c3);
        clinics.add(c4);
        clinics.add(c5);
        clinics.add(c6);
        clinics.add(c7);
        clinics.add(c8);

        ClinicsAdapter pa = new ClinicsAdapter(clinics,this.getActivity());
        recyclerView.setAdapter(pa);


         return view;
    }
}