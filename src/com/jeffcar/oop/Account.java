package com.jeffcar.oop;

/**
 * @author JeffCar
 * @date 11/21/2020 - 1:45 AM
 */
public class Account {

    private int id;
    private double balance;
    private double annuallnterestRate;


    public Account(int id, double balance, double annuallnterestRate){
        this.annuallnterestRate = annuallnterestRate;
        this.id = id;
        this.balance =balance;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    //取钱
    public void withdraw(double amount){
        if(this.balance < amount){
            System.out.println("钱太少了，取不出");
            return;
        }
        balance -= amount;
        System.out.println("成功取出" + amount);
    }
    //存钱
    public void deposit(double amount){
        if(amount<0){
            System.out.println("存钱失败");
            return;
        }

        balance += amount;
        System.out.println("存钱"+amount+ "成功");
    }
}
