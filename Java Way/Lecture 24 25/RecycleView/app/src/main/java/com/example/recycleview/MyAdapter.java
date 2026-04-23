package com.example.recycleview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<News> newsArrayList;
    private Activity context;
    private onItemClickListener myListener;

    // Interface
    public interface onItemClickListener {
        void onItemClicking(int position);
    }

    // Listener setter
    public void setOnItemClickListener(onItemClickListener listener) {
        this.myListener = listener;
    }

    // Constructor
    public MyAdapter(ArrayList<News> newsArrayList, Activity context) {
        this.newsArrayList = newsArrayList;
        this.context = context;
    }

    // Create ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_row, parent, false);
        return new MyViewHolder(itemView, myListener);
    }

    // Bind data
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        News currentItem = newsArrayList.get(position);
        holder.hTitle.setText(currentItem.getNewsHeading());
        holder.hImage.setImageResource(currentItem.getNewsImage());
    }

    // Item count
    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    // ViewHolder class
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView hTitle;
        ShapeableImageView hImage;

        public MyViewHolder(View itemView, onItemClickListener listener) {
            super(itemView);

            hTitle = itemView.findViewById(R.id.headingTitle);
            hImage = itemView.findViewById(R.id.headingImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClicking(position);
                        }
                    }
                }
            });
        }
    }
}