package com.pdf.word.线程;

import cn.hutool.core.date.DateUtil;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        //该方法在initialDelay时长后第一次执行任务，以后每隔period时长，再次执行任务。
        // 注意，period是从任务开始执行算起的。开始执行任务后，定时器每隔period时长检查该任务是否完成
        // ，如果完成则再次启动任务，否则等该任务结束后才再次启动任务。
//        scheduledExecutorService.scheduleWithFixedDelay(() -> {
//            System.out.println(DateUtil.now());
//            System.out.println("大家注意了，我要发消息了");
//        },10,1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println(DateUtil.now());
            System.out.println("大家注意了，我要发消息了1");
        },10,1, TimeUnit.SECONDS);

    }
    // 当任务执行时间,查过了定时任务的周期时间
    // 1 scheduleAtFixedRate 不会受到任务执行的时间影响,就是按照周期固化好的时间执行
    // 2 scheduleAtFixedRate 会受到任务执行的时间影响,而是推迟下一个任务执行时间,但是周期频率不会改变

}
