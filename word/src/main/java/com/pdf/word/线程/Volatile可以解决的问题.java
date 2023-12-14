package com.pdf.word.线程;

/**
 * @author fulin
 * @since 2023/5/6 9:12
 */
public class Volatile可以解决的问题 {

    //private boolean flag = true;
        private volatile boolean flag = true;
    private int num = 0;

    public void write() {
        flag = false;
        System.out.println(Thread.currentThread().getName() + "开始执行.....");
        System.out.println(System.currentTimeMillis());
    }

    public void read() {
        System.out.println(Thread.currentThread().getName() + "开始执行.....");
        while (flag) {
            num++;
        }
        System.out.println(Thread.currentThread().getName() + "结束.....");
        System.out.println("跳出循环" + num);
        System.out.println(System.currentTimeMillis());
    }


    public static void main(String[] args) throws InterruptedException {

        Volatile可以解决的问题 handle = new Volatile可以解决的问题();
        new Thread(handle::read).start();
        Thread.sleep(2000);
        new Thread(handle::write).start();
    }
}
