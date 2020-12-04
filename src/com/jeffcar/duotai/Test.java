package com.jeffcar.duotai;

/**
 * @author JeffCar
 * @date 11/22/2020 - 10:27 AM
 */
public class Test {

    public static void main(String[] args){
        Test test = new Test();
        Circle circle = new Circle(3,"white",1.0);
        test.displayGeometricObject(circle);
    }
    public boolean equalsArea(GeometricObject o1, GeometricObject o2){
        return o1.findArea() == o2.findArea();
    }

    public void displayGeometricObject(GeometricObject o){
        System.out.println("面积为:" + o.findArea());
    }
}
