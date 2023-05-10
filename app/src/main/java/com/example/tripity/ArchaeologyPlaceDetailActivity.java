package com.example.tripity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tripity.Fragments.ArchaeologyPlace;

public class ArchaeologyPlaceDetailActivity extends AppCompatActivity {
    private ImageView archaeologyPlaceImageView;
    private TextView archaeologyPlaceNameTextView;
    private TextView archaeologyPlaceLocationTextView;
    private TextView archaeologyPlaceDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archaeology_place_detail);

        archaeologyPlaceImageView = findViewById(R.id.archaeology_place_image_view);
        archaeologyPlaceNameTextView = findViewById(R.id.archaeology_place_name_text_view);
        archaeologyPlaceLocationTextView = findViewById(R.id.archaeology_place_location_text_view);
        archaeologyPlaceDescriptionTextView = findViewById(R.id.archaeology_place_description_text_view);

        // Get the selected archaeological place from the intent
        ArchaeologyPlace selectedPlace = (ArchaeologyPlace) getIntent().getSerializableExtra("selected_place");

        // Set the values of the views with the selected archaeological place
        Glide.with(this).load(selectedPlace.getImageUrl()).placeholder(R.drawable.ahmedabad_rafiki).into(archaeologyPlaceImageView);
        archaeologyPlaceNameTextView.setText(selectedPlace.getName());
        archaeologyPlaceLocationTextView.setText(selectedPlace.getLocation());
        archaeologyPlaceDescriptionTextView.setText(selectedPlace.getDescription());
    }
}