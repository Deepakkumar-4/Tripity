package com.example.tripity.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tripity.ArchaeologyPlaceDetailActivity;
import com.example.tripity.Fragments.ArchaeologyPlace;
import com.example.tripity.R;

import java.util.List;

public class ArchaeologyPlaceAdapter extends RecyclerView.Adapter<ArchaeologyPlaceAdapter.ArchaeologyPlaceViewHolder>{

    List<ArchaeologyPlace> archaeologyPlacesList;
    Context context;

    public ArchaeologyPlaceAdapter(List<ArchaeologyPlace> archaeologyPlaces,Context context) {
        this.archaeologyPlacesList = archaeologyPlaces;
        this.context = context;
    }
    @NonNull
    @Override
    public ArchaeologyPlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.archaeology_place_item, parent, false);
        ArchaeologyPlaceViewHolder viewHolder=new ArchaeologyPlaceViewHolder(itemView);
        return viewHolder;

    }
    @Override
    public void onBindViewHolder(@NonNull ArchaeologyPlaceViewHolder holder, int position) {

        ArchaeologyPlace archaeologyPlace = archaeologyPlacesList.get(position);
        holder.archaeologyPlaceImageView.setImageResource(archaeologyPlace.getImageUrl());
        holder.archaeologyPlaceNameTextView.setText(archaeologyPlace.getName());
        holder.archaeologyPlaceLocationTextView.setText(archaeologyPlace.getLocation());

//        Glide.with(context)
//                .load(archaeologyPlace.getImageUrl())
//                .placeholder(R.drawable.ahmedabad_pana)
//                .into(holder.archaeologyPlaceImageView);
//
    }
    @Override
    public int getItemCount() {
        return archaeologyPlacesList.size();
    }

    public  class ArchaeologyPlaceViewHolder extends RecyclerView.ViewHolder {
        public TextView archaeologyPlaceNameTextView;
        public TextView archaeologyPlaceLocationTextView;
        public ImageView archaeologyPlaceImageView;
        public ArchaeologyPlaceViewHolder(View itemView) {
            super(itemView);
            archaeologyPlaceNameTextView = itemView.findViewById(R.id.archaeology_place_name_text_view);
            archaeologyPlaceLocationTextView = itemView.findViewById(R.id.archaeology_place_location_text_view);
            archaeologyPlaceImageView = itemView.findViewById(R.id.archaeology_place_image_view);
        }
    }


}
