package com.jeffcar.lock;

/**
 * @author JeffCar
 * @date 11/27/2020 - 11:51 AM
 */


class Account{
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized void deposite(int amt){
        balance = balance + amt;

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"：存钱成功。余额为：" + balance);
    }

}

class Customer extends Thread{
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0; i<3; i++){

            account.deposite(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("储户1");
        c2.setName("储户2");


        c1.start();
        c2.start();
    }
}
