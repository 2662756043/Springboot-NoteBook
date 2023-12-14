package com.pdf.word.线程.并发容器;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author fulin
 * @since 2023/5/6 10:08
 */

@Slf4j
public class NumbersProducer implements Runnable {
    private final int poisonPill;
    private final int poisonPillPerProducer;
    private BlockingQueue<Integer> numbersQueue;

    public NumbersProducer(BlockingQueue<Integer> numbersQueue,
                           int poisonPill,
                           int poisonPillPerProducer) {
        this.numbersQueue = numbersQueue;
        this.poisonPill = poisonPill;
        this.poisonPillPerProducer = poisonPillPerProducer;
    }

    @Override
    public void run() {
        try {
            generateNumbers();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void generateNumbers() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            numbersQueue.put(ThreadLocalRandom.current().nextInt(100));
            log.info("潘金莲-{}号,给武大郎的泡药！", Thread.currentThread().getId());
        }
        for (int j = 0; j < poisonPillPerProducer; j++) {
            numbersQueue.put(poisonPill);
            log.info("潘金莲-{}号,往武大郎的药里放入第{}颗毒丸！", Thread.currentThread().getId(), j + 1);
        }
    }
}