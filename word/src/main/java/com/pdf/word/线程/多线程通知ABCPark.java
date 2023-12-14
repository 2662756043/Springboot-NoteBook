package com.pdf.word.线程;

import lombok.SneakyThrows;

import java.util.concurrent.locks.LockSupport;

/**
 * 多线程打印 五次 ABCABC......
 *
 * @author fulin
 * @since 2023/5/9 10:43
 */
public class 多线程通知ABCPark {


    private volatile String flag = "A";

    @SneakyThrows
    public static void main(String[] args) {

        多线程通知ABCPark abc = new 多线程通知ABCPark();
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                LockSupport.park();
                System.out.println("A");
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                LockSupport.park();
                System.out.println("B");
            }
        });
        Thread threadC = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                LockSupport.park();
                System.out.println("C");
            }
        });
        threadA.setName("A");
        threadB.setName("B");
        threadC.setName("C");
        threadA.start();
        threadB.start();
        threadC.start();


        int num = 0;
        while (threadA.isAlive() || threadB.isAlive() || threadC.isAlive()) {

            if (num % 3 == 0) {
                LockSupport.unpark(threadA);
            }
            if (num % 3 == 1) {
                LockSupport.unpark(threadB);
            }
            if (num % 3 == 2) {
                LockSupport.unpark(threadC);
            }
            num++;
            Thread.sleep(1);
        }

    }


}
