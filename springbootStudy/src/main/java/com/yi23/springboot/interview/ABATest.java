package com.yi23.springboot.interview;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author : 王斌
 * @Date : 2019/4/23 上午12:17
 * @Description 描述
 */
public class ABATest {

    /**
     * 没有加版本的原子引用
     */
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    /**
     * 加版本号的原子引用
     */
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args)  {
        System.out.println("以下是ABA问题的产生");
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"线程1").start();

        new Thread(()->{
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+
                    "\t"+atomicReference.compareAndSet(100,101)+
                    "\t结果是"+atomicReference.get());
        },"线程2").start();


        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("以下是ABA问题的解决方案");
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"获取的版本号是："+stamp);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101,stamp,stamp+1);
            System.out.println(Thread.currentThread().getName()+"获取的版本号是："+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"获取的版本号是："+atomicStampedReference.getStamp());
        },"线程3").start();
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"获取的版本号是："+stamp);
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---"+atomicStampedReference.compareAndSet(100,101,stamp,stamp+1));
            System.out.println(Thread.currentThread().getName()+"获取的版本号是："+atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"获取的值是："+atomicStampedReference.getReference());

        },"线程4").start();
    }
}
