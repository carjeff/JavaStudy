package com.jeffcar.oop;

/**
 * @author JeffCar
 * @date 11/20/2020 - 8:21 PM
 *
 * 方法的重载
 * 同一个方法名只要形参不同，就是重载
 *
 */
public class OverLoadTest {
    public void getSum(int i, int j){
        System.out.println(i+j);
    }
    public void getSum(String i, String j){

    }
}
