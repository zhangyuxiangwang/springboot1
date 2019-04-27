package com.yi23.springboot.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : 王斌
 * @Date : 2019/4/25 下午9:00
 * @Description 生产者消费者
 */
public class Consumer {

    public static void main(String[] args) {
        ShareData product = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                product.product();
            }

        }, "生产者").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                product.consumer();
            }
        }, "消费者").start();
    }
}

class Product {
    //传统模式的生产者消费者

    Integer count = 0;

    public synchronized void product() {

        while (count > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count++;
        System.out.println("生产一个:" + count);
        notify();
    }

    public synchronized void consumer() {

        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费一个count:" + count);
        count--;
        notify();
    }

}

class ShareData {
    Integer data = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void product() {

        lock.lock();
        try {
            while (data > 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            data++;
            System.out.println("生产一个:" + data);
            condition.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void consumer() {
        lock.lock();
        try {
            while (data <= 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费一个count:" + data);
            data--;
            condition.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

}
