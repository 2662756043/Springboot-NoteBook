package com.pdf.word.线程;

import lombok.SneakyThrows;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author fulin
 * @since 2023/5/23 20:44
 */
public class CyclicBarrierPriority {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2,() -> System.out.println("我先执行"));

    @SneakyThrows
    public static void main(String[] args) {

        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println("1");
        }).start();

        cyclicBarrier.await();
        System.out.println("2");

    }
}
