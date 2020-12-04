package com.jeffcar.project3.bean;

/**
 * @author JeffCar
 * @date 11/24/2020 - 9:33 PM
 */
public class Architect extends Designer{
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails()+"\t\t架构师\t\t"+ getStatus() + "\t\t"+getBonus()+"\t\t"+stock+"\t" + getEquipment().getDescription();
    }
}
