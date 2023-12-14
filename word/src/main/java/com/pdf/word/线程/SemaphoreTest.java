package com.pdf.word.线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author fulin
 * @since 2023/5/24 10:08
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data");
                        System.out.println(s.availablePermits());
                        //System.out.println(s.drainPermits());
                        s.release();
                        System.out.println(s.availablePermits());
                    } catch (InterruptedException e) {
                    }
                }
            });
        }
        threadPool.shutdown();
    }

}
