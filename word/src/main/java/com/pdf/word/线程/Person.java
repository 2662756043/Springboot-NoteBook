package com.pdf.word.线程;

/**
 * @author fulin
 * @since 2023/4/14 9:49
 */
public class Person implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        //while (true) {
        //        synchronized (Abc.class) {
        //            if (ticket > 0) {
        //                System.out.println(Thread.currentThread().getName() + "卖出第" + ticket + "张票,剩余" + --ticket);
        //            }
        //        }
        //    try {
        //        Thread.sleep(200);
        //    } catch (InterruptedException e) {
        //        throw new RuntimeException(e);
        //    }
        //
        //}

        while (true) {
            if (ticket<=0) {
                break;
            }
            try {
                Thread.sleep(222);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "卖出第" + ticket + "张票,剩余" + --ticket);
        }
    }
}
