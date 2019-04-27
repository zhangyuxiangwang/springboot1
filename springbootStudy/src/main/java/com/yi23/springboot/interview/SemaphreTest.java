package com.yi23.springboot.interview;

import java.util.concurrent.Semaphore;

/**
 * @Author : 王斌
 * @Date : 2019/4/24 下午11:33
 * @Description 描述
 */
public class SemaphreTest {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i=0;i<6;i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢到了车位...");
                    Thread.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t停了3秒钟就走了...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }, "车" + i).start();
        }

    }
}
