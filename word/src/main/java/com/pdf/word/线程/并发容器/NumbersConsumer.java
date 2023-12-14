package com.pdf.word.线程.并发容器;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

/**
 * @author fulin
 * @since 2023/5/6 10:09
 */
@Slf4j
public class NumbersConsumer implements Runnable {
    private final int poisonPill;
    private BlockingQueue<Integer> queue;

    public NumbersConsumer(BlockingQueue<Integer> queue, int poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer number = queue.take();
                if (number.equals(poisonPill)) {
                    return;
                }
                log.info("武大郎-{}号,喝药-编号:{}", Thread.currentThread().getId(), number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
