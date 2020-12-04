package com.jeffcar.project3.bean;

/**
 * @author JeffCar
 * @date 11/24/2020 - 9:31 PM
 */
public class Designer extends Programmer{
    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails()+"\t\t设计师\t\t"+ getStatus() + "\t\t"+bonus+"\t\t\t\t" + getEquipment().getDescription();
    }
}
