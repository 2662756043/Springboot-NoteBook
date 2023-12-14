package com.pdf.word.线程;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author fulin
 * @since 2023/5/9 13:42
 */
public class AB并行后park执行C {

    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            AtomicInteger atomicInteger = new AtomicInteger(2);

            Thread c = new Thread(() -> {
                LockSupport.park();
                System.out.println("C");
            });
            c.start();

            new Thread(() -> {
                System.out.println("A");
                while (atomicInteger.decrementAndGet() == 0) {
                    LockSupport.unpark(c);
                }
            }).start();
            new Thread(() -> {
                System.out.println("B");
                while (atomicInteger.decrementAndGet() == 0) {
                    LockSupport.unpark(c);
                }
            }).start();
        }
    }
}
