package com.jeffcar.oop;

/**
 * @author JeffCar
 * @date 11/21/2020 - 1:53 AM
 */
public class CustomerTest {

    public static void main(String[] args){
        Customer customer = new Customer("Jane","Smith");
        Account account = new Account(1000,2000,1.23);
        customer.setAccount(account);

        account.deposit(100);
        account.withdraw(960);
        account.withdraw(2000);

    }
}
