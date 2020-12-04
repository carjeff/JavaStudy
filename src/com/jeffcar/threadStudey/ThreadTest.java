package com.jeffcar.threadStudey;

/**
 * @author JeffCar
 * @date 11/25/2020 - 10:04 PM
 */
public class ThreadTest {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        mythread.start();
    }
}

class Mythread extends Thread {
    @Override
    public void run() {
        for (int i =0; i<100; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
