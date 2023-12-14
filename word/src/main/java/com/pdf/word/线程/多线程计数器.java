package com.pdf.word.线程;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fulin
 * @since 2023/5/8 10:30
 */
public class 多线程计数器 {

    @SneakyThrows
    public static void main(String[] args) {

        System.out.println("开始考试");
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            service.execute(() -> {
                System.out.println("第" + finalI + 1 + "个考生交卷");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("考试完毕");
        service.shutdown();

    }
}
