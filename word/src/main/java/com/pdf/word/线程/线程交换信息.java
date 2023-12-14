package com.pdf.word.线程;

import lombok.SneakyThrows;

import java.util.concurrent.Exchanger;

/**
 * @author fulin
 * @since 2023/5/8 10:09
 */
public class 线程交换信息 {


    @SneakyThrows
    public static void main(String[] args) {

        Exchanger<String> stringExchanger = new Exchanger<>();

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                System.out.println(Thread.currentThread().getName() + "我接受到了消息: " + stringExchanger.exchange("你好"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.setName("第一个");
        thread.start();

        Thread.sleep(2000);
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                System.out.println(Thread.currentThread().getName() + "我接受到了消息: " + stringExchanger.exchange("hello"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.setName("第二个");
        thread1.start();

    }
}
