package com.pdf.word.线程;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author fulin
 * @since 2023/5/23 16:19
 */
public class ForkJoin使用 extends RecursiveTask<Integer> {


    private static int yuzhi = 10;
    private Integer start;
    private Integer end;


    public ForkJoin使用(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        Integer res = 0;

        if ((end - start) <= 10) {
            for (Integer i = start; i <= end; i++) {
                res += i;
            }
        } else {

            Integer middle = (start + end) / 2;
            ForkJoin使用 forkJoin使用 = new ForkJoin使用(start, middle);
            ForkJoin使用 forkJoin使用1 = new ForkJoin使用(middle + 1, end);

            ForkJoinTask<Integer> fork = forkJoin使用.fork();
            ForkJoinTask<Integer> fork1 = forkJoin使用1.fork();
            try {
                res = fork.get() + fork1.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        return res;
    }


    @SneakyThrows
    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoin使用 forkJoin = new ForkJoin使用(1, 100);

        ForkJoinTask<Integer> submit = forkJoinPool.submit(forkJoin);

        Integer integer = submit.get();

        System.out.println(integer);

    }
}
