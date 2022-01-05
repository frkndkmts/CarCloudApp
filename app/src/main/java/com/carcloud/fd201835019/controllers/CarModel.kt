package com.carcloud.fd201835019.controllers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CarModel(
    @Expose
    @SerializedName("carName")
    var carName: String = "",
    @Expose
    @SerializedName("carLocation")
    var carLocation: String = "",
    @Expose
    @SerializedName("kmFree")
    var kmFree: String = "",
    @Expose
    @SerializedName("kmPrice")
    var kmPrice: String = "",
    @Expose
    @SerializedName("carPrice")
    var carPrice: String = ""
)
