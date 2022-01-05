package com.carcloud.fd201835019.controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.carcloud.fd201835019.R;
import com.carcloud.fd201835019.controllers.CarBookMainActivity;
import com.carcloud.fd201835019.controllers.SignUpActivity;
import com.carcloud.fd201835019.helpers.UIHelper;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnFocusChangeListener {


    private boolean firstLogin = true;
    private String savedUsername = "";
    private String savedPassword = "";
    private SharedPreferences.Editor  editor;
    private SharedPreferences sharedPref;

    private EditText userNameET;
    private EditText userPasswordET;
    private Button loginButton;
    private Button signUpButton;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        userNameET = findViewById(R.id.userNameET);
        userPasswordET = findViewById(R.id.userPasswordET);
        loginButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.signUpButton);



        setListeners();
        checkPreviousLogin();

    }



    private void setListeners() {
        userNameET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //UIHelper.hideKeyboard(this, v);
            }
        });
        userPasswordET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //UIHelper.hideKeyboard(this, v);
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpButtonTapped();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInButtonTapped();
            }
        });
    }

    private void checkPreviousLogin() {
        savedUsername = sharedPref.getString("username", "");
        savedPassword = sharedPref.getString("password", "");

        if (!savedUsername.isEmpty() && !savedPassword.isEmpty()) {
            firstLogin = false;
            signInButtonTapped();
        }
    }

    private void signUpButtonTapped() {
        goToSignUpScreen();
    }

    private void signInButtonTapped() {
        goToCarBookActivity();
    }

    private void goToCarBookActivity() {
        startActivity(new Intent(this, CarBookMainActivity.class));
        finish();
    }

    private void goToSignUpScreen() {
        startActivity(new Intent(this, SignUpActivity.class));
        finish();
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        UIHelper.hideKeyboard(this, v);
    }
}
