package com.example.adoption;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    ArrayList<Clinics> CArray;
    Context context;
//    int []arr;
//    public RecyclerViewAdapter(int[] arr) {
//        this.arr = arr;
//    }
public RecyclerViewAdapter(ArrayList<Clinics> pArray, Context context) {
    this.CArray = pArray;
    this.context = context;
}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view2,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,final int position) {
//      holder.imageView.setImageResource(arr[position]);
//      holder.textView.setText("Image No."+position);
        ((MyViewHolder) holder).name.setText(CArray.get(position).getName());
        ((MyViewHolder) holder).imageView.setImageResource(CArray.get(position).getImage());
        ((MyViewHolder) holder).phone.setText(CArray.get(position).getPhone());


    }

    @Override
    public int getItemCount() {
        return CArray.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

       public ImageView imageView;
        public TextView name;
        public TextView phone;
        public View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textView);
            phone = itemView.findViewById(R.id.textView2);
        }
    }
}
