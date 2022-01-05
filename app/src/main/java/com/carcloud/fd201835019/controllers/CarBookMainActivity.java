package com.carcloud.fd201835019.controllers;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.carcloud.fd201835019.R;
import com.carcloud.fd201835019.helpers.Constants;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Date;

public class CarBookMainActivity extends AppCompatActivity {

    private RecyclerView carBookRV;
    private TextView startDateTV;
    private TextView endDateTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_carbook);
        setSupportActionBar(findViewById(R.id.my_toolbar));
        carBookRV = findViewById(R.id.carBookRV);
        startDateTV = findViewById(R.id.startDateTV);
        endDateTV = findViewById(R.id.endDateTV);
        changeAdapterData();

        startDateTV.setOnClickListener((view)-> {
            showDatePicker();
        });

        endDateTV.setOnClickListener((view)-> {
            showDatePicker();
        });


    }


    private void showDatePicker() {

        MaterialDatePicker<Pair<Long, Long>> dateRangePicker = MaterialDatePicker.Builder.dateRangePicker()
                .setTitleText("Select dates")
                .build();
        dateRangePicker.addOnPositiveButtonClickListener((view)-> {
            startDateTV.setText(new Date(view.first).toString().substring(0,10));
            endDateTV.setText(new Date(view.second).toString().substring(0,10));
            changeAdapterData();
        });
        dateRangePicker.show(super.getSupportFragmentManager(), "tag");
    }


    private void changeAdapterData() {
        carBookRV.setLayoutManager(new LinearLayoutManager(this));
        carBookRV.setAdapter(new CarBookAdapter(
                Constants.getCarModels(),
                super.getApplicationContext(),
                startDateTV.getText().toString(),
                endDateTV.getText().toString()
        ));
        carBookRV.getAdapter().notifyDataSetChanged();
    }

}
