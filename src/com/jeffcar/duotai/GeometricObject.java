package com.jeffcar.duotai;

/**
 * @author JeffCar
 * @date 11/22/2020 - 10:20 AM
 */
public class GeometricObject {

    private String color;
    private double weight;

    public GeometricObject(String color, double weight){
        this.color = color;
        this.weight = weight;
    }

    public GeometricObject(){

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double findArea(){
        return 0;
    }
}
