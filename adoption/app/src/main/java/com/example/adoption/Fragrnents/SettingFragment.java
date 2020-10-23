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
public class SettingFragment extends Fragment {

    View view;
    TextView textView;
    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_setting, container, false);

        textView= view.findViewById(R.id.settingTxt);
        textView.setText("setting Fragment");

        return view;
    }
}