package com.yi23.springboot.interview;

import com.yi23.springboot.response.DataUtils;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : 王斌
 * @Date : 2019/4/25 下午11:07
 * @Description 使用队列来实现消费者和生产者
 */
public class BlockQueueConsumerTest {
    public static void main(String[] args) throws Exception {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        MyResource myResource = new MyResource<>(blockingQueue);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            try {
                myResource.product("1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AA").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
            try {
                myResource.consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();

        TimeUnit.SECONDS.sleep(10);

        System.out.println(Thread.currentThread().getName() + "叫停");

        myResource.stop();

    }
}

class MyResource<T> {
    private volatile Boolean FLAG = true;
    BlockingQueue<T> blockingQueue;
    public MyResource(BlockingQueue<T> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void product(T t) throws Exception {

        boolean result;
        while (FLAG) {
            result = blockingQueue.offer(t, 2, TimeUnit.MINUTES);
            if (result) {
                System.out.println(Thread.currentThread().getName() + "\t 插入了数据成功" + t);
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入了数据失败" + t);
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 叫停了操作");
    }

    public void consumer() throws Exception {
        T take;
        while (FLAG) {
            take = blockingQueue.take();
            if (DataUtils.isEmpty(take)) {
                System.out.println(Thread.currentThread().getName() + "\t 消费暂停了");
                FLAG = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 取出了数据" + take);
        }
    }
    public void stop() {
        FLAG = false;
    }

}