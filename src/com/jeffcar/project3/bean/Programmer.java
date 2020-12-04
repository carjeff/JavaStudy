package com.jeffcar.project3.bean;

import com.jeffcar.project3.service.Status;

/**
 * @author JeffCar
 * @date 11/24/2020 - 8:41 PM
 */
public class Programmer extends Employee{
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getDetails(){
        return super.toString();
    }
    @Override
    public String toString() {
        return getDetails()+"\t\t程序员\t\t"+status + "\t\t\t\t\t\t\t" + equipment.getDescription();
    }
}
