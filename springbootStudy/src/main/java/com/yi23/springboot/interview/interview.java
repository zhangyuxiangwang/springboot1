package com.yi23.springboot.interview;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author : 王斌
 * @Date : 2019/4/21 下午11:11
 * @Description 测试Volatile关键字的可见性
 */
public class interview {
    public static void main(String[] args) {
        testAmoic();
    }

    /**
     * volatile可见性验证的代码
     */
    public static void testVolatileSee() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "come in");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.add();
            System.out.println(Thread.currentThread().getName() + "update mydata number:" + myData.number);
        }, "线程1---").start();
        while (myData.number == 0) {
        }
        System.out.println(myData.number + "结束了");
    }

    /**
     * volatile验证原子性
     */
    public static void testAmoic() {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.plusAdd();
                    myData.addAtomicInteger();
                }
            }, String.valueOf(i)).start();
        }


        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(myData.number + "---volatile不保证原子性" + myData.atomicInteger);
    }

}


class MyData {
    volatile Integer number = 0;

    public void add() {
        this.number = 60;
    }

    public void plusAdd() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomicInteger() {
        atomicInteger.getAndIncrement();
    }

    AtomicReference<MyData> atomicReference =new AtomicReference<>();
}
