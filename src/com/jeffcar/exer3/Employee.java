package com.jeffcar.exer3;

/**
 * @author JeffCar
 * @date 11/23/2020 - 2:52 PM
 */
public abstract class Employee {

    private String name;
    private int number;
    private MyDate birthday;

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public abstract int earnings();

    @Override
    public String toString() {
        return "Employee:["+name+" "+number+" "+birthday.toDateString()+"]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}
