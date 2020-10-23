package com.example.adoption.Fragrnents;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.adoption.Addanimal;
import com.example.adoption.Animal;
import com.example.adoption.MyViewHolder;
import com.example.adoption.PageAnimal;
import com.example.adoption.R;
import com.example.adoption.SliderItem;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

View view;


   EditText inputSearch;
   RecyclerView recyclerView;
    RecyclerView.LayoutManager LayoutManager;
   FloatingActionButton floatingbtn;
   FirebaseRecyclerOptions<Animal> oplions;
   FirebaseRecyclerAdapter<Animal, MyViewHolder>adapter;
   DatabaseReference Dataref;
   private ViewPager2 viewPager2;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
            super.onCreate(savedInstanceState);

//        textView = view.findViewById(R.id.HomeTxt);
//        textView.setText("History Fragment");
        Dataref = FirebaseDatabase.getInstance().getReference().child("animal");
        inputSearch = view.findViewById(R.id.inputSearch);
        recyclerView = view.findViewById(R.id.recylerView);
        floatingbtn = view.findViewById(R.id.floatingbtn);

//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        LayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(LayoutManager);
//        return view;
//        recyclerView.setHasFixedSize(true);


        floatingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomeFragment.this.getActivity(), Addanimal.class);
                startActivity(i);
            }
        });

        LoadData("");
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
             if (s.toString()!=null){
                 LoadData(s.toString());
             }
             else {
                 LoadData("");
             }
            }
        });




//        viewPager2 = view.findViewById(R.id.viewPagerImageSlider);

        List<SliderItem> slideritemss = new ArrayList<>();




        return view;
    }

    private void LoadData(String data) {
         Query query = Dataref.orderByChild("type").startAt(data).endAt(data+"\uf8ff");
        oplions = new FirebaseRecyclerOptions.Builder<Animal>().setQuery(query,Animal.class).build();

         adapter = new FirebaseRecyclerAdapter<Animal, MyViewHolder>(oplions) {
             @Override
             protected void onBindViewHolder(@NonNull MyViewHolder holder, final int position, @NonNull Animal model) {
                 holder.textView.setText(model.getAnimalName());
                 Picasso.get().load(model.getImageUrl()).into(holder.imageView);
                 holder.v.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Intent intent = new Intent(HomeFragment.this.getActivity(), PageAnimal.class);
                         intent.putExtra("Animalkey",getRef(position).getKey());
                         startActivity(intent);
                     }
                 });
             }

             @NonNull
             @Override
             public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                 View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);
                 return new MyViewHolder(v);
             }
         };

         adapter.startListening();
         recyclerView.setAdapter(adapter);
    }

}