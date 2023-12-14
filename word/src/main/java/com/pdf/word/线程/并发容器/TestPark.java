package com.pdf.word.线程.并发容器;

import cn.hutool.core.util.RandomUtil;
import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author fulin
 * @since 2023/5/6 17:03
 */
public class TestPark {

    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(5);

    @SneakyThrows
    public static void main(String[] args) {

        TestPark testPark = new TestPark();

        // 多线程 验证take 阻塞现象
        new Thread(() -> {
            try {
                testPark.arrayBlockingQueue.take();
                System.out.println("take成功");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        Thread.sleep(2000);

        new Thread(() -> {
            //arrayBlockingQueue.take();
            for (int i = 0; i < 6; i++) {
                try {
                    testPark.arrayBlockingQueue.put(RandomUtil.randomInt());
//                    testPark.arrayBlockingQueue.add(RandomUtil.randomInt());
//                    boolean offer = testPark.arrayBlockingQueue.offer(RandomUtil.randomInt());
//                    System.out.println(offer);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(testPark.arrayBlockingQueue.size());
        }).start();
    }
}
