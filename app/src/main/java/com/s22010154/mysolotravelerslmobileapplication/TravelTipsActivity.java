package com.s22010154.mysolotravelerslmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TravelTipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_tips);

        TextView temp = findViewById(R.id.textViewtemp);
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to Temperature
                Intent intent = new Intent(TravelTipsActivity.this, TemperatureActivity.class);
                startActivity(intent);
            }
        });

    }
}