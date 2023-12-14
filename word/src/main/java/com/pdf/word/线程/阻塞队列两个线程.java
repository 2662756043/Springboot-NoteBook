package com.pdf.word.线程;

import cn.hutool.core.util.RandomUtil;
import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 两个线程打印 ABAB....
 *
 * @author fulin
 * @since 2023/5/9 11:07
 */
public class 阻塞队列两个线程 {


    @SneakyThrows
    public static void main(String[] args) {

        BlockingQueue<Object> blockingDeque = new ArrayBlockingQueue<>(1);

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    blockingDeque.put(RandomUtil.randomChinese());
                    System.out.print("A");
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    blockingDeque.take();
                    System.out.print("B");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        System.out.println();
    }
}
