package com.pdf.word.线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fulin
 * @since 2023/4/28 11:26
 */
class ReorderExample {
    int a = 0;
     volatile boolean flag = false;

    public void writer() {
        a = 1;                   //1
        flag = true;             //2
    }

    public void reader() {
        if (flag) {                //3
            int i = a * a;        //4
            System.out.println("结果是: " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 100; i++) {
            ReorderExample reorderExample = new ReorderExample();
            service.execute(() -> {
                reorderExample.reader();
            });
            Thread.sleep(200);
            service.execute(() -> {
                reorderExample.writer();
            });
            //new Thread(() -> {
            //    reorderExample.writer();
            //}).start();
            //
            //new Thread(() -> {
            //    reorderExample.reader();
            //}).start();


        }


    }
}

