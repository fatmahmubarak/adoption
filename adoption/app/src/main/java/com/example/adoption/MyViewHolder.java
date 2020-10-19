package com.example.adoption;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;

public class MyViewHolder extends RecyclerView.ViewHolder {


    public TextView textView;
    public ImageView imageView;
//    public TextView textView2;
    public View v;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView_single_view);
        imageView = itemView.findViewById(R.id.image_single_view);
//        textView2 = itemView.findViewById(R.id.textView2_single_view)
        v = itemView;
    }
}
