package com.pdf.word.线程;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * @author fulin
 * @since 2023/5/9 13:42
 */
public class AB并行后Join执行C {

    @SneakyThrows
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            Thread a = new Thread(() -> {
                System.out.println("A");
            });
            a.start();
            Thread b = new Thread(() -> {
                System.out.println("B");
            });
            b.start();

            a.join();
            b.join();
            new Thread(() -> {
                System.out.println("C");
            }).start();
        }

    }
}
