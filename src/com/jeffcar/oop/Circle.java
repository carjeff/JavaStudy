package com.jeffcar.oop;

/**
 * @author JeffCar
 * @date 11/20/2020 - 11:13 PM
 */
public class Circle {

    public static void main(String[] args){
        Circle circle = new Circle();
        PassObject passObject = new PassObject();
        passObject.printAreas(circle,5);
    }
    double radius;

    public double findArea(double r){
        return 3.14*r*r;
    }

}

class PassObject{

    public void printAreas(Circle c, int time){
        for (int i = 0; i < time; i++) {
            System.out.println(i+1);

            System.out.println(c.findArea(i+1));
        }

    }

}
