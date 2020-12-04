package com.jeffcar.threadStudey;

/**
 *
 * 创建多线程方式二  实现Runnable接口
 * @author JeffCar
 * @date 11/25/2020 - 11:09 PM
 */


class MThread implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<100;i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
public class ThreadTest1 {

    public static void main(String[] args) {
        MThread mThread = new MThread();

        Thread thread = new Thread(mThread);
        thread.start();
    }
}
