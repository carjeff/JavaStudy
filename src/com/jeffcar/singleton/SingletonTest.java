package com.jeffcar.singleton;

/**
 * @author JeffCar
 * @date 11/23/2020 - 12:42 AM
 *
 *
 *
 */
public class SingletonTest {
    public static void main(String[] args){
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println("饿汉式");
        System.out.println(bank1 == bank2);
    }
}

//饿汉式
class Bank{
    //1.私有化类的构造器, 避免在类外构造对象

    private Bank(){

    }
    //2.内部创建类的对象
    //4.私有化
    private static Bank instance = new Bank();

    //3.提供公共的静态方法，返回类的对象
    public static Bank getInstance(){
        return instance;
    }
}