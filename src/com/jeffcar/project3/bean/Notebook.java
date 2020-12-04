package com.jeffcar.project3.bean;

/**
 * @author JeffCar
 * @date 11/24/2020 - 8:36 PM
 */
public class Notebook implements Equipment {
    private String model;
    private double price;

    public Notebook() {
    }

    public Notebook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model+"("+price+")";
    }
}
