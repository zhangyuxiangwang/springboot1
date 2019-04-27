package com.yi23.springboot.interview;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : 王斌
 * @Date : 2019/4/24 上午1:01
 * @Description 描述
 * 可重入锁，用ReentrantLock来实现
 *
 */
public class ReentrantLockTest3 {

    public static void main(String[] args) {

        Car car = new Car();
        new Thread(car,"线程1").start();
        new Thread(car,"线程2").start();
    }
}


class Car implements Runnable{

    @Override
    public void run() {
        test();
    }

    Lock lock = new ReentrantLock();

    private void test() {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t test()");
            method();
        }finally {
            lock.unlock();
            lock.unlock();
        }
    }

    private void method() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t method()");
        }finally {
            lock.unlock();
        }
    }
}