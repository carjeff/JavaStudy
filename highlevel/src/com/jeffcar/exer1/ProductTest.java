package com.jeffcar.exer1;

/**
 *
 * 生产者消费者问题!
 * @author JeffCar
 * @date 11/27/2020 - 4:18 PM
 */

class Clerk{
    private int productNum = 0;


    public synchronized void create() {
        notify();
        if(productNum < 20 ){
            System.out.println(Thread.currentThread().getName()+"生产第"+productNum + "个产品");
            productNum++;
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume() {
        notify();
        if (productNum>0){
            System.out.println(Thread.currentThread().getName()+"消费第"+productNum+"个产品");
            productNum--;
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor extends Thread{
    private Clerk clerk;
    public Productor(Clerk clerk){
        this.clerk = clerk;

    }

    @Override
    public void run() {
        System.out.println("生产者开始生产.....");
        while (true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.create();
        }

    }
}

class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;

    }

    @Override
    public void run() {
        System.out.println("消费者开始消费.....");
        while (true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consume();
        }

    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);

        productor.setName("生产者：");
        consumer.setName("消费者: ");
        productor.start();
        consumer.start();
    }
}
