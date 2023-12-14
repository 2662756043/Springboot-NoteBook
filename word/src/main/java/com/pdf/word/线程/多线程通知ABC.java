package com.pdf.word.线程;

import lombok.SneakyThrows;

/**
 * 多线程打印 五次 ABCABC......
 * @author fulin
 * @since 2023/5/9 10:43
 */
public class 多线程通知ABC {


    private volatile String flag = "A";

    public static void main(String[] args) {

        多线程通知ABC abc = new 多线程通知ABC();

        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                abc.printA();
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                abc.printB();
            }
        });
        Thread threadC = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                abc.printC();
            }
        });

        threadA.setName("A");
        threadB.setName("B");
        threadC.setName("C");

        threadA.start();
        threadB.start();
        threadC.start();
    }

    @SneakyThrows
    private synchronized void printA() {
        while (!flag.equals("A")) {
            this.wait();
        }
        flag = "B";
        System.out.println("A");
        this.notifyAll();
    }

    @SneakyThrows
    private synchronized void printB() {
        while (!flag.equals("B")) {
            this.wait();
        }
        flag = "C";
        System.out.println("B");
        this.notifyAll();
    }


    @SneakyThrows
    private synchronized void printC() {
        while (!flag.equals("C")) {
            this.wait();
        }
        flag = "A";
        System.out.println("C");
        this.notifyAll();
    }

}
