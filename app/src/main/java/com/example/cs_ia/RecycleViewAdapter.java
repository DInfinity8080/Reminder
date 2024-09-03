package com.example.cs_ia;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<listName_model> everyone;
    Context context;

    public RecycleViewAdapter(List<listName_model> everyone, Context context) {
        this.everyone = everyone;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listrecycler_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.rv_listname.setText(everyone.get(position).getName());
        holder.rv_listdate.setText("Jan 1");
        //holder.rv_icon.setImageBitmap();

    }


    @Override
    public int getItemCount() {
        return everyone.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView rv_icon;
        TextView rv_listname, rv_listdate;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_icon = itemView.findViewById(R.id.rv_icon);
            rv_listname = itemView.findViewById(R.id.rv_listname);
            rv_listdate = itemView.findViewById(R.id.rv_listdate);

        }
    }
}
