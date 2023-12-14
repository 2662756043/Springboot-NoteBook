package com.pdf.word.线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fulin
 * @since 2023/4/27 17:42
 */
public class volatileTest {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        final volatileTest test = new volatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                for (int j = 0; j < 1000; j++)
                    test.increase();
            }).start();

            //service.execute(() -> {
            //    System.out.println(Thread.currentThread().getName());
            //    for (int j = 0; j < 1000; j++)
            //        test.increase();
            //});
        }
        //service.shutdown();
        while (Thread.activeCount() > 1)  //保证前面的线程都执行完
            Thread.yield();
        //while (service.isTerminated()) {
        //    break;
        //}
        System.out.println("inc output:" + test.inc);
    }
}

