package com.jeffcar.exer3;

/**
 * @author JeffCar
 * @date 11/23/2020 - 2:58 PM
 */
public class SalariedEmployee extends Employee{
    private int monthlySalary;

    public SalariedEmployee(String name, int number, MyDate birthday, int monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }
    public SalariedEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }
    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public int earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee:["+super.toString()+"]";
    }
}
