package com.yi23.springboot.interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author : 王斌
 * @Date : 2019/4/25 下午11:49
 * @Description 描述
 */
public class MyTheadPoolDemo {

    public static void main(String[] args) {

        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

        ExecutorService executorService = Executors.newCachedThreadPool();

        ExecutorService executorService1 = Executors.newFixedThreadPool(4);

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();


    }
}
