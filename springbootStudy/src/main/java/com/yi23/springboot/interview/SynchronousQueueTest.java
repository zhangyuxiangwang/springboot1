package com.yi23.springboot.interview;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author : 王斌
 * @Date : 2019/4/25 下午8:52
 * @Description 描述  SynchronousQueue同步队列
 */
public class SynchronousQueueTest {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(()->{

            System.out.println(Thread.currentThread().getName()+"\t put 1");
            try {
                blockingQueue.put("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t put 2");
            try {
                blockingQueue.put("2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t put 3");
            try {
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"put线程").start();

        new Thread(()->{

            try {
                Thread.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t take 1:"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t take 2:"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t take 3:"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"take线程").start();
    }
}
