package com.s22010154.mysolotravelerslmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        TextView placesToVisitText = findViewById(R.id.textView18);
        placesToVisitText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to PlacesToVisitActivity
                Intent intent = new Intent(CategoryActivity.this, PlacesToVisitActivity.class);
                startActivity(intent);
            }
        });

        TextView tripPlanner = findViewById(R.id.textView21);
        tripPlanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to TripPlanner
                Intent intent = new Intent(CategoryActivity.this, TripPlanner.class);
                startActivity(intent);
            }
        });

        TextView soloActivities = findViewById(R.id.textView19);
        soloActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to SoloActivities
                Intent intent = new Intent(CategoryActivity.this, SoloActivities.class);
                startActivity(intent);
            }
        });

        TextView safety = findViewById(R.id.textView22);
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to Safety
                Intent intent = new Intent(CategoryActivity.this, SafetyActivity.class);
                startActivity(intent);
            }
        });

        TextView food = findViewById(R.id.textView23);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to Foods
                Intent intent = new Intent(CategoryActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });

        TextView transport = findViewById(R.id.textView24);
        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to Transport
                Intent intent = new Intent(CategoryActivity.this, TransportActivity.class);
                startActivity(intent);
            }
        });

        TextView accommodation = findViewById(R.id.textView20);
        accommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to Transport
                Intent intent = new Intent(CategoryActivity.this, AccommodationActivity.class);
                startActivity(intent);
            }
        });

        TextView travel_tips = findViewById(R.id.textView25);
        travel_tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to Travel Tips
                Intent intent = new Intent(CategoryActivity.this, TravelTipsActivity.class);
                startActivity(intent);
            }
        });

    }
}