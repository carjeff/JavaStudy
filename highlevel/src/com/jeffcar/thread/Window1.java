package com.jeffcar.thread;

import static java.lang.Thread.sleep;

/**
 *
 *  实现Runnable 接口
 * @author JeffCar
 * @date 11/27/2020 - 1:03 AM
 */
public class Window1 {

    public static void main(String[] args) {
        Win2 w1 = new Win2();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Win2 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){

            synchronized (this){
                if (ticket >0 ){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖票， 票号为："+ ticket);
                    ticket--;
                }
            }

        }
    }
}
