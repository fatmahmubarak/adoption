package com.example.adoption;

import android.app.slice.SliceItem;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter1 extends RecyclerView.Adapter<SliderAdapter1.SliderViewHolder>{

    private List<SliceItem> sliceItems;
    private ViewPager2 viewPager2;

    public SliderAdapter1(List<SliceItem> sliceItems, ViewPager2 viewPager2) {
        this.sliceItems = sliceItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
//        ((SliderViewHolder) holder).imageView.setImageResource(sliceItems.get(position));
//        holder.setImage(sliceItems.get(position));
    }

    @Override
    public int getItemCount() {
        return sliceItems.size();
    }

    public static class SliderViewHolder extends RecyclerView.ViewHolder{
             private RoundedImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlider);
        }

        void setImage(SliderItem slideritem){
            imageView.setImageResource(slideritem.getImage());
        }

    }
}
