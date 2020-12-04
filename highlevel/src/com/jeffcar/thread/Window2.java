package com.jeffcar.thread;

/**
 *
 * 继承thread类
 *
 * @author JeffCar
 * @date 11/27/2020 - 1:03 AM
 */

public class Window2 {

    public static void main(String[] args) {
        Win win = new Win();
        Win w1 = new Win();
        Win w2 = new Win();
        win.start();
        w1.start();
        w2.start();

    }
}

class Win extends Thread{
    private static int ticket = 100;
    static Object object = new Object(); //关键  必须加上static 表示唯一对象
    public Win(){
        super();
    }

    @Override
    public void run() {

        while (true){

            synchronized (object){  //或者这里直接可以用 Win.class  唯一类
                if (ticket >0 ){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(currentThread().getName()+"卖票， 票号为："+ ticket);
                    ticket--;
                }
            }

        }

    }
}
