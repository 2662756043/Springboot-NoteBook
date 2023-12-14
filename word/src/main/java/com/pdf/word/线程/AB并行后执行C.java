package com.pdf.word.线程;

import java.util.concurrent.CountDownLatch;

/**
 * @author fulin
 * @since 2023/5/9 13:42
 */
public class AB并行后执行C {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(() -> {
            System.out.println("A");
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println("B");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("C");
        }).start();
    }
}
