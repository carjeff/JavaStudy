package com.jeffcar.oop;

/**
 * @author JeffCar
 * @date 11/21/2020 - 1:41 AM
 */
public class BoyGirlTest {
    public static void main(String[] args){
        Boy boy = new Boy("罗密欧",21);
        boy.shout();

        Girl girl = new Girl("朱丽叶",18);
        girl.marry(boy);
    }
}
