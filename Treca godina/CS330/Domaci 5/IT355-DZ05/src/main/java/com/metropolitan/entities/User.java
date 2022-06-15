package com.metropolitan.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull
    @Size(min = 1, message = "You can't leave this empty.")
    private String name;

    @NotNull
    @Size(min = 1, message = "You can't leave this empty.")
    private String carModel;

    @NotNull
    @Size(min = 1, message = "You can't leave this empty.")
    private String model;

    @NotNull
    @Size(min = 1, message = "You can't leave this empty.")
    private int numOfDaysRented;

    public User() {
    }

    public User(String name, String carModel, String model, int numOfDaysRented) {
        this.name = name;
        this.carModel = carModel;
        this.model = model;
        this.numOfDaysRented = numOfDaysRented;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumOfDaysRented() {
        return numOfDaysRented;
    }

    public void setNumOfDaysRented(int numOfDaysRented) {
        this.numOfDaysRented = numOfDaysRented;
    }
}
