package com.carcloud.fd201835019.controllers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarModel {

    @Expose
    @SerializedName("carName")
    private String carName;

    @Expose
    @SerializedName("carLocation")
    private String carLocation;

    @Expose
    @SerializedName("kmFree")
    private String kmFree;

    @Expose
    @SerializedName("kmPrice")
    private String kmPrice;

    @Expose
    @SerializedName("carPrice")
    private String carPrice;

    public CarModel() {
    }

    public CarModel(String carName, String carLocation, String kmFree, String kmPrice, String carPrice) {
        this.carName = carName;
        this.carLocation = carLocation;
        this.kmFree = kmFree;
        this.kmPrice = kmPrice;
        this.carPrice = carPrice;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarLocation() {
        return carLocation;
    }

    public void setCarLocation(String carLocation) {
        this.carLocation = carLocation;
    }

    public String getKmFree() {
        return kmFree;
    }

    public void setKmFree(String kmFree) {
        this.kmFree = kmFree;
    }

    public String getKmPrice() {
        return kmPrice;
    }

    public void setKmPrice(String kmPrice) {
        this.kmPrice = kmPrice;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }
}
