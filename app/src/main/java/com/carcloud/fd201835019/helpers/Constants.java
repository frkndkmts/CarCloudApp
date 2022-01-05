package com.carcloud.fd201835019.helpers;

import com.carcloud.fd201835019.R;
import com.carcloud.fd201835019.controllers.CarModel;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static List<CarModel> getCarModels() {
        List<CarModel> carModels = new ArrayList<>();
        carModels.add(new CarModel(
                "RENAULT Clio", "Maltepe/Istanbul",
                "10", "5 tl", "100 tl"
        ));

        carModels.add(new CarModel(
                "OPEL Insignia", "Tuzla/Istanbul",
                "10", "7 tl", "150 tl"
        ));
        carModels.add(new CarModel(
                "RENAULT Megane", "Kartal/Istanbul",
                "10", "6 tl", "130 tl"
        ));
        carModels.add(new CarModel(
                "RENAULT Megane", "Kartal/Istanbul",
                "10", "6 tl", "130 tl"
        ));
        carModels.add(new CarModel(
                "PEUGOET 301", "Pendik/Istanbul",
                "10", "5.5 tl", "110 tl"
        ));
        carModels.add(new CarModel(
                "HONDA Civic", "Kadıkoy/Istanbul",
                "10", "8 tl", "160 tl"
        ));
        carModels.add(new CarModel(
                "VOLKSWAGEN Polo", "Beşiktaş/Istanbul",
                "10", "6 tl", "120 tl"
        ));
        carModels.add(new CarModel(
                "HYUNDAI Accent Blue ", "Bostancı/Istanbul",
                "10", "7 tl", "140 tl"
        ));
        return carModels;
    }

    public static List<Integer> getCarImages() {
        List<Integer> carModelImages = new ArrayList<>();
        carModelImages.add(R.drawable.car1);
        carModelImages.add(R.drawable.car2);
        carModelImages.add(R.drawable.car3);
        carModelImages.add(R.drawable.car4);
        carModelImages.add(R.drawable.car5);
        carModelImages.add(R.drawable.car6);
        carModelImages.add(R.drawable.car7);
        carModelImages.add(R.drawable.car7);
        return carModelImages;
    }


}
