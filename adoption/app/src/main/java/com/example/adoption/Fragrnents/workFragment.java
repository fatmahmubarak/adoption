package com.example.adoption.Fragrnents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adoption.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class workFragment extends Fragment {
    View view;
    TextView textView;

    public workFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false);

//       textView= view.findViewById(R.id.wordTxt);
//        textView.setText("work Fragment");

//        return view;
    }
}