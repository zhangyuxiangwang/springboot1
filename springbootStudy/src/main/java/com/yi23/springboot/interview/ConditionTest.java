package com.yi23.springboot.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : 王斌
 * @Date : 2019/4/25 下午10:29
 * @Description
 */
public class ConditionTest {

    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            for (int i=0;i<5;i++){
                data.test5();
            }

        }, "线程1：").start();
        new Thread(() -> {
            for (int i=0;i<5;i++){
                data.test10();
            }

        }, "线程2：").start();
        new Thread(() -> {
            for (int i=0;i<5;i++){
                data.test15();
            }

        }, "线程3：").start();
    }
}

class Data {

    private Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    Condition condition1 = lock.newCondition();

    Condition condition2 = lock.newCondition();

    private Integer flag = 1;

    public void test5() {
        lock.lock();
        try {
            while (flag != 1) {
                condition.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t 打印了" + i + "次");
            }
            flag = 2;
            condition1.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void test10() {
        lock.lock();
        try {
            while (flag != 2) {
                condition1.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t 打印了" + i + "次");
            }
            flag = 3;
            condition2.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void test15() {
        lock.lock();
        try {
            while (flag != 3) {
                condition2.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t 打印了" + i + "次");
            }
            flag = 1;
            condition.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

}
