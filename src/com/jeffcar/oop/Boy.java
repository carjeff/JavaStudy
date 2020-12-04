package com.jeffcar.oop;

/**
 * @author JeffCar
 * @date 11/21/2020 - 1:32 AM
 */
public class Boy {
    private String name;
    private int age;

    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void marry(Girl girl){
        System.out.println("i want to marry" + girl.getName());
    }

    public void shout(){
        if(this.age >=22){
            System.out.println("可以结婚");
        }else {
            System.out.println("再等等");
        }
    }
}
