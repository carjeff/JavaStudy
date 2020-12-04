package com.jeffcar.threadStudey;

/**
 * @author JeffCar
 * @date 11/25/2020 - 11:18 PM
 */

class Window implements Runnable{
    private int ticket =100;

    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}
public class WindowTest {
    public static void main(String[] args) {
        Window window = new Window();

        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }


}
