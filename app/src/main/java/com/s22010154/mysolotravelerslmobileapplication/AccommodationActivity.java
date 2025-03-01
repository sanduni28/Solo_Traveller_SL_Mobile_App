package com.s22010154.mysolotravelerslmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccommodationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accommodation);

        Button btnStartHotels = findViewById(R.id.btn_star_hotels);
        Button btnBungalows = findViewById(R.id.btn_bungalows);
        Button btnGuest = findViewById(R.id.btn_guest);
        Button btnRented = findViewById(R.id.btn_rented);

        //navigate to star class hotels screen
        btnStartHotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccommodationActivity.this, StarClassHotelsActivity.class);
                startActivity(intent);
            }
        });

        //navigate to bungalows screen
        btnBungalows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccommodationActivity.this, BungalowsActivity.class);
                startActivity(intent);
            }
        });

        //navigate to Guest_Houses screen
        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccommodationActivity.this, Guest_HousesActivity.class);
                startActivity(intent);
            }
        });

        //navigate to rented homes screen
        btnRented.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccommodationActivity.this, Rented_HomesActivity.class);
                startActivity(intent);
            }
        });
    }
}