package com.pdf.word.线程;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author fulin
 * @since 2023/5/23 9:01
 */
public class 多线程处理顺序集合 {


    @SneakyThrows
    public static void main(String[] args) {

        List<Future<Integer>> resultList = new ArrayList<>();

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Future<Integer> submit = service.submit(new MyCallAbale(i));
            resultList.add(submit);
        }

        service.shutdown();

        Integer res = 0;
        for (Future<Integer> integerFuture : resultList) {
            Integer integer = integerFuture.get();
            System.out.println(integer);
            res += integer;
        }

        System.out.println(res);

    }

    static class MyCallAbale implements Callable<Integer> {

        private Integer num;

        public MyCallAbale(Integer num) {
            this.num = num;
        }

        @Override
        public Integer call() throws Exception {
            Integer res = 0;
            for (Integer i = num * 10+1; i <= (num + 1) * 10; i++) {
                res += i;
            }
            return res;
        }
    }
}
