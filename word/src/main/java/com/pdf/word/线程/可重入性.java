package com.pdf.word.线程;

/**
 * @author fulin
 * @since 2023/5/4 17:29
 */
public class 可重入性 {

    static int num = 0;

    public static void main(String[] args) {

        可重入性 ke = new 可重入性();

        while (num < 9) {
            ke.ss();
        }
    }

    public synchronized void ss() {
        System.out.println("获取锁的对象是" + this);
        ss1();
    }


    public synchronized void ss1() {
        System.out.println("获取锁次数" + num);
        num++;
    }

}
