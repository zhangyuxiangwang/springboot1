package com.yi23.springboot.interview;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author : 王斌
 * @Date : 2019/4/24 下午11:11
 * @Description 描述
 */
public class CyclibarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
            System.out.println("既然人都到齐了，我们就开始开会吧...");
        });

        for (int i=0;i<5;i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t等待其他学生开会...");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "同学" + i).start();
        }

    }
}
