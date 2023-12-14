package com.pdf.word.线程;

import cn.hutool.core.collection.CollectionUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author fulin
 * @since 2023/3/14 11:31
 */
public class 线程池 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(10);

        //service.isTerminated()

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "a";
            }
        };
        List<Future<String>> futures = service.invokeAll(Collections.singleton(callable));

        for (Future<String> future : futures) {
            String s = future.get();
        }

        while (Thread.activeCount()>1) {
            Thread.yield();
        }

    }
}
