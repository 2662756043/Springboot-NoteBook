package com.pdf.word.线程;

import lombok.Data;
import lombok.SneakyThrows;

/**
 * @author fulin
 * @since 2023/4/28 11:25
 */
@Data
public class 可见性 {

    private volatile boolean flag = true;

    public void read() {
        while (flag) {
            //System.out.println("还没成功");
        }
        System.out.println("修改成功");
    }

    public void write() {
        System.out.println("111");
        flag = false;
    }

    @SneakyThrows
    public static void main(String[] args) {

        可见性 ke = new 可见性();

        new Thread(ke::read).start();
        Thread.sleep(2000);
        new Thread(ke::write).start();

    }

}
