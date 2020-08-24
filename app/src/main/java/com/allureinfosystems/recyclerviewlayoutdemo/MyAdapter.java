package com.allureinfosystems.recyclerviewlayoutdemo;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.DataHolder> {

    private int [] image ;
    Context context;
    public MyAdapter(Context context, int[]image)
    {
        this.image = image;
        this.context = context;
    }
    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_layout,parent,false);
        return new DataHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {

       //StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();

        if(position % 2 == 0)
        {

           //layoutParams.setFullSpan(true);
            holder.itemView.setBackgroundColor(Color.parseColor("#55761a"));

        }else
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#9db33e"));
           // layoutParams.setFullSpan(false);

        }

        final int posi = (int) Array.get(image, position);
        holder.imagehold.setImageResource(posi);

    }

    @Override
    public int getItemCount() {
        return image.length;
    }



    public class DataHolder extends RecyclerView.ViewHolder
    {
        private ImageView imagehold;
        public DataHolder(@NonNull View itemView) {

            super(itemView);
            imagehold = itemView.findViewById(R.id.imageSource);
        }
    }
}
