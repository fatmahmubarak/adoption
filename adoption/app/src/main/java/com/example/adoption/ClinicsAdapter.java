package com.example.adoption;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageButton;
import pl.droidsonroids.gif.GifImageView;

public class ClinicsAdapter extends RecyclerView.Adapter {

    ArrayList<Clinics> CArray;
    Context context;

    public ClinicsAdapter(ArrayList<Clinics> pArray, Context context) {
        this.CArray = pArray;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view2,parent, false);
        ViewHolder vh =new  ViewHolder (v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ((ViewHolder) holder).relativeLayout.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animation));

        ((ViewHolder) holder).name.setText(CArray.get(position).getName());
        ((ViewHolder) holder).phone.setText(CArray.get(position).getPhone()+"");
        ((ViewHolder) holder).imageView.setImageResource(CArray.get(position).getImage());

        ((ViewHolder) holder).button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+CArray.get(position).getPhone()));
                context.startActivity(intent);
//                CArray.remove(position);
//                notifyDataSetChanged();
//                Toast.makeText(context, "item is deleted", Toast.LENGTH_SHORT).show();
            }
        });

        ((ViewHolder) holder).button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:"+CArray.get(position).getMap()));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return CArray.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

       public ImageView imageView;
        public TextView name;
        public TextView phone;
        public View view;
        public GifImageView button;
        public GifImageView button2;
         public RelativeLayout relativeLayout;
//        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textView);
            phone = itemView.findViewById(R.id.textView2);
            button = (GifImageView) itemView.findViewById(R.id.button);
            button2 = (GifImageView) itemView.findViewById(R.id.button2);
            relativeLayout = itemView.findViewById(R.id.relative);
//            linearLayout = itemView.findViewById(R.id.lin);
        }
    }
}
