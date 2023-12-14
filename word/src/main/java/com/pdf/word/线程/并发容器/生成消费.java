package com.pdf.word.线程.并发容器;

import cn.hutool.core.util.RandomUtil;
import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author fulin
 * @since 2023/5/6 11:02
 */
public class 生成消费 {

    ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {

        生成消费 sc = new 生成消费();

        new Thread(sc.new Producer()).start();
        new Thread(sc.new Consumer()).start();

    }

    //
    class Producer implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                queue.put(RandomUtil.randomInt());
                System.out.println("向队列取中插入一个元素，队列剩余空间"+(10-queue.size()));
            }
        }
    }


    class Consumer implements Runnable{

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                Integer take = queue.take();
                System.out.println("从队列中取出一个元素"+ take);
            }
        }
    }


}
