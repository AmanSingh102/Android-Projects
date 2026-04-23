package com.example.api;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Activity context;
    List<Product> productList;

    public MyAdapter(Activity context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Product product = productList.get(position);

        holder.title.setText(product.getTitle());

        Picasso.get()
                .load(product.getThumbnail())
                .into(holder.image);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ShapeableImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.productTitle);
            image = itemView.findViewById(R.id.productImage);
        }
    }
}