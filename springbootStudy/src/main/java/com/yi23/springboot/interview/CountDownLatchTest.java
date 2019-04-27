package com.yi23.springboot.interview;

import java.util.concurrent.CountDownLatch;

/**
 * @Author : 王斌
 * @Date : 2019/4/24 下午10:26
 * @Description 描述
 */
public class CountDownLatchTest {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(5);

        System.out.println("我要锁门了");

        for (int i=0;i<5;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t班长等我出去在锁门...");
                countDownLatch.countDown();//每次减1
            },"同学"+i).start();
        }
        try {
            countDownLatch.await();//只有当countDownLatch.getCount()等于0当时候才会释放，
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我锁门了");
    }
}
