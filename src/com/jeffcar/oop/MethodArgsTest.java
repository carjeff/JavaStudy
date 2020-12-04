package com.jeffcar.oop;

/**
 * @author JeffCar
 * @date 11/20/2020 - 8:34 PM
 *
 *
 * 可变个数形参的方法
 *
 *
 */
public class MethodArgsTest {
    public static void main(String[] args){
        MethodArgsTest test = new MethodArgsTest();
        test.show(12);
        test.show("12","3333");
    }

    public void show(int i){

    }
    public void show(String str){

    }

    public void show(String... strs){
        System.out.println("可变形参");
    }
//    public void show(String[] strs){
//
//    }
    // 不能用数组，数组和可变形参不能共存

//    public void show(String... strs, int i){
//
//    }
    //这个是错的，可变个数形参只能一个，并且为末尾
    public void show(int i, int j, String... strs){

    }
}
