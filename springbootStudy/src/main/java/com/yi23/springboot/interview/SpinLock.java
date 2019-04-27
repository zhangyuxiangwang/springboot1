package com.yi23.springboot.interview;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author : 王斌
 * @Date : 2019/4/24 上午1:29
 * @Description 描述
 * 实现一个自旋锁
 */
public class SpinLock {

    public static void main(String[] args) {

        SpinLockDome spinLockDome = new SpinLockDome();

        new Thread(()->{
            spinLockDome.myLock();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDome.myUnLock();
        },"线程1").start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            spinLockDome.myLock();
            spinLockDome.myUnLock();
        },"线程2").start();

    }
}

class SpinLockDome{

    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    //加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"\t come lock");
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }
    //解锁
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"\t come in unlock");
        atomicReference.compareAndSet(thread,null);

    }
}