package com.example.adoption;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class TipsAdapter extends RecyclerView.Adapter {

    ArrayList<Tips> TArray;
    Context context;

    public TipsAdapter(ArrayList<Tips> pArray, Context context) {
        this.TArray = pArray;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view3,parent, false);
        ViewHolder vh =new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((TipsAdapter.ViewHolder) holder).name.setText(TArray.get(position).getName());
        ((ViewHolder) holder).imageView.setImageResource(TArray.get(position).getImage());
//        ((ViewHolder) holder).recyclerView.setTag(TArray.get(position).getColor());
        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context,Tips_activity.class);
            intent.putExtra("image",TArray.get(position).getImage());
            intent.putExtra("name",TArray.get(position).getName());
            intent.putExtra("Tips",TArray.get(position).getTips());
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return TArray.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public GifImageView imageView;
        public TextView name;
        public View view;
//        public RecyclerView recyclerView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            imageView = (GifImageView)itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textView);
//            recyclerView = itemView.findViewById(R.id.relative);
        }
    }

}
