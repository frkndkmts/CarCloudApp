package com.carcloud.fd201835019.controllers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.carcloud.fd201835019.R;
import com.carcloud.fd201835019.helpers.Constants;

public class CarBookResultActivity extends AppCompatActivity {

    private TextView tripTimeTV;
    private TextView pickUpLocationTV;
    private TextView priceTV;
    private TextView freeKilometerTV;
    private TextView thereAfterTV;
    private ImageView carImageIV;
    private AppCompatButton completeBookingBT;
    private AppCompatButton cancelBookingBT;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_carbook_result);

        tripTimeTV = findViewById(R.id.tripTimeTV);
        pickUpLocationTV = findViewById(R.id.pickUpLocationTV);
        priceTV = findViewById(R.id.priceTV);
        freeKilometerTV = findViewById(R.id.freeKilometerTV);
        thereAfterTV = findViewById(R.id.thereAfterTV);
        carImageIV = findViewById(R.id.carImageIV);
        completeBookingBT = findViewById(R.id.completeBookingBT);
        cancelBookingBT = findViewById(R.id.cancelBookingBT);

        int position = super.getIntent().getIntExtra("position", 0);
        String dates = super.getIntent().getStringExtra("startDate") + " - " + super.getIntent().getStringExtra("endDate");
        updateUI(position, dates);

        setClickListeners();
    }

    public void setClickListeners() {
        completeBookingBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSuccessDialog();
            }
        });

        cancelBookingBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCancelDialog();
            }
        });
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to complete the booking process?");
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                navigateToMainActivity();
            }
        });
        builder.show();
    }

    private void showCancelDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to cancel the booking process?");
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                navigateToMainActivity();
            }
        });
        builder.show();
    }

    private void navigateToMainActivity() {
        startActivity(new Intent(this, CarBookMainActivity.class));
    }

    private void updateUI(int position, String dates) {
        tripTimeTV.setText(dates);
        pickUpLocationTV.setText(Constants.getCarModels().get(position).getCarLocation());
        priceTV.setText(Constants.getCarModels().get(position).getCarPrice());
        freeKilometerTV.setText(Constants.getCarModels().get(position).getKmFree());
        thereAfterTV.setText(Constants.getCarModels().get(position).getKmPrice());
        carImageIV.setImageResource(Constants.getCarImages().get(position));

    }
}
