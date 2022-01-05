package com.carcloud.fd201835019.controllers;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.carcloud.fd201835019.R;
import com.carcloud.fd201835019.helpers.Constants;

import java.util.List;

public class CarBookAdapter extends RecyclerView.Adapter<CarBookAdapter.CarBookViewHolder> {

    private final List<CarModel> carList;
    private final Context carBookMainActivity;
    private final String startDate;
    private final String endDate;

    public CarBookAdapter(List<CarModel> carList, Context carBookMainActivity, String startDate, String endDate) {
        this.carList = carList;
        this.carBookMainActivity = carBookMainActivity;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @NonNull
    @Override
    public CarBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_car_booking, parent, false);
        return new CarBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarBookViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CarModel carModelItem = carList.get(position);
        holder.mTextView1.setText("Model: " + carModelItem.getCarName());
        holder.mTextView2.setText("Km price: " + carModelItem.getKmPrice());
        holder.mTextView3.setText("Rent fee: " + carModelItem.getCarPrice());
        holder.mTextView4.setText("Free KM: " + carModelItem.getKmFree());
        holder.mTextView5.setText("Pickup Location: " + carModelItem.getCarLocation());
        holder.carImage.setImageResource(Constants.getCarImages().get(position));

        holder.bookBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCarBookResultActivity(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public static class CarBookViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;
        public TextView mTextView5;
        public ImageView carImage;
        public Button bookBT;

        public CarBookViewHolder(View itemView) {
            super(itemView);
            mTextView1 =itemView.findViewById(R.id.textView1);
            mTextView2 =itemView.findViewById(R.id.textView2);
            mTextView3 =itemView.findViewById(R.id.textView3);
            mTextView4 =itemView.findViewById(R.id.textView4);
            mTextView5 =itemView.findViewById(R.id.textView5);
            carImage =itemView.findViewById(R.id.carImage);
            bookBT =itemView.findViewById(R.id.bookBT);
        }

    }

    private void goToCarBookResultActivity(int position) {
        if(!startDate.equals("")) {
            Intent myIntent = new Intent(carBookMainActivity, CarBookResultActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            myIntent.putExtra("position", position);
            myIntent.putExtra("startDate", startDate);
            myIntent.putExtra("endDate", endDate);
            ContextCompat.startActivity(carBookMainActivity, myIntent,new Bundle());
        }
    }



}


