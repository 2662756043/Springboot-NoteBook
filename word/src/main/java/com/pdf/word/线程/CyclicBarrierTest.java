package com.pdf.word.线程;

import lombok.SneakyThrows;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author fulin
 * @since 2023/5/23 20:26
 */
public class CyclicBarrierTest{


    /**
     * int 入参   其参数表示屏障拦截的线程数量，
     * 每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞
     * 只有线程的阻塞数量(到达屏障的数量) 与int 入参相当的时候,线程才会进入就绪状态,开始执行
     */
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

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
            System.out.println("我是子线程");
        }).start();

        cyclicBarrier.await();
        System.out.println("我是主线程");

    }
}
