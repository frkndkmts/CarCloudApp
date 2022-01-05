package com.carcloud.fd201835019.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.carcloud.fd201835019.R;

public class SignUpActivity extends AppCompatActivity {

    Button signUpButton = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signUpButton = findViewById(R.id.signUpBT);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpButtonTapped();
            }
        });
    }

    private void signUpButtonTapped() {
        new AlertDialog.Builder(this).setTitle("Registration Success").setMessage("").show();
        startActivity(new Intent(this, LoginActivity.class));
        finish();


    }
}
