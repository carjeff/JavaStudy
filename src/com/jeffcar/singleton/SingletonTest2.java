package com.jeffcar.singleton;

/**
 * @author JeffCar
 * @date 11/23/2020 - 12:47 AM
 *
 * 单例模式的懒汉式实现
 */
public class SingletonTest2 {
}


class Order{
    //
    private Order(){

    }

    //
    private static Order instance = null;


    public static Order getInstance(){
        if(instance == null){
            instance = new Order();
        }
        return instance;
    }
}