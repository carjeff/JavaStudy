package com.jeffcar.exer3;

/**
 * @author JeffCar
 * @date 11/23/2020 - 5:35 PM
 */
public class HourlyEmployee extends Employee{

    private int wage;
    private int hour;
    public HourlyEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);

    }
    public HourlyEmployee(String name, int number, MyDate birthday, int wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }


    @Override
    public int earnings() {
        return wage*hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee:["+super.toString()+"]";
    }
}
