package com.s22010154.mysolotravelerslmobileapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.s22010154.mysolotravelerslmobileapplication.databinding.ActivityHomeScreenBinding;
public class HomeScreenActivity extends AppCompatActivity {
    private @NonNull ActivityHomeScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            // Handle navigation item clicks
            if (item.getItemId() == R.id.home) {
                replaceFragment(new HomeFragment());
                return true;
            } else if (item.getItemId() == R.id.favo) {
                replaceFragment(new FavouriteFragment());
                return true;
            } else if (item.getItemId() == R.id.map) {
                replaceFragment(new LocationFragment());
                return true;
            } else if (item.getItemId() == R.id.pro) {
                replaceFragment(new ProfileFragment());
                return true;
            }
            return false;
        });
        ImageView imageViewMenu = findViewById(R.id.imageView2);
        imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the category screen
                Intent intent = new Intent(HomeScreenActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
        ImageView imageViewTemperature = findViewById(R.id.imageViewtemp);
        imageViewTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the temperature screen
                Intent intent = new Intent(HomeScreenActivity.this, TemperatureActivity.class);
                startActivity(intent);
            }
        });

        TextView safety = findViewById(R.id.textView7);
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to safety screen
                Intent intent = new Intent(HomeScreenActivity.this, SafetyActivity.class);
                startActivity(intent);
            }
        });

        TextView transport = findViewById(R.id.textView8);
        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to Transport screen
                Intent intent = new Intent(HomeScreenActivity.this, TransportActivity.class);
                startActivity(intent);
            }
        });

        TextView food = findViewById(R.id.textView);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to food screen
                Intent intent = new Intent(HomeScreenActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE); // Clear the back stack
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
