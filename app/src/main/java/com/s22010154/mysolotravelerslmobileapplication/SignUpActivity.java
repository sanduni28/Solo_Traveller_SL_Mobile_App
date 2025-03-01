package com.s22010154.mysolotravelerslmobileapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.s22010154.mysolotravelerslmobileapplication.databinding.ActivitySignUpBinding;
public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        //navigate to Login when successfully signup
        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.editTextNameInput.getText().toString();
                String email = binding.editTextEmailInput.getText().toString();
                String password = binding.editTextPasswordInput.getText().toString();
                String confirmPassword = binding.editTextConfirmPasswordInput.getText().toString();

                if(name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    if(password.equals(confirmPassword)) {
                        if(!databaseHelper.checkEmail(email)) {
                            if(databaseHelper.insertData(name, email, password)) {
                                Toast.makeText(SignUpActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            } else {
                                Toast.makeText(SignUpActivity.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignUpActivity.this, "User already exists, Please Login", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUpActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        //navigate to login in text
        binding.textViewSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });
    }
}