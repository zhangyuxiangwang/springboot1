package com.yi23.springboot.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author : 王斌
 * @Date : 2019/4/25 下午11:40
 * @Description 描述
 */
public class CallableAndFutureTasktest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> future = new FutureTask<>(new Calculation());

        new Thread(future,"线程1").start();

        Integer integer = future.get();//是阻塞的
        System.out.println(integer);

    }
}

class Calculation implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t 进来计算...");
        return 100;
    }
}
