package com.pdf.word.线程;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fulin
 * @since 2023/5/4 9:23
 */
@Data
public class 多线程问题 implements Runnable {



    //public static int num = 0;
    //private synchronized void add() {
    //    for (int i = 0; i < 500; i++) {
    //        num++;
    //    }
    //}
    //public volatile int num = 0;
    AtomicInteger num = new AtomicInteger(0);
    private void add() {
        for (int i = 0; i < 500; i++) {
            num.getAndIncrement();
            //num++;
        }
    }

    @Override
    public void run() {
        add();
    }

    public static void main(String[] args) {


        for (int i = 0; i < 1000; i++) {
            多线程问题 pro = new 多线程问题();

            Thread thread = new Thread(pro);
            thread.setName("第一个线程");

            Thread thread1 = new Thread(pro);
            thread1.setName("第二个线程");

            thread1.start();
            thread.start();
            while (Thread.activeCount() > 1) {
                Thread.yield();
            }
            System.out.println(pro.num.get());
            //System.out.println(pro.getNum());
        }
    }

}
