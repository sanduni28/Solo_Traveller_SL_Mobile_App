package com.s22010154.mysolotravelerslmobileapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import com.s22010154.mysolotravelerslmobileapplication.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {
    ActivityForgotPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Handle reset button click
        binding.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.editTextEmailInput.getText().toString();
                String mobile = binding.editTextMobileNumberInput.getText().toString();

                if (email.isEmpty() || mobile.isEmpty()) {
                    Toast.makeText(ForgotPasswordActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    // For demonstration purposes, we will just show a success message
                    Toast.makeText(ForgotPasswordActivity.this, "Password reset instructions sent to your email", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
