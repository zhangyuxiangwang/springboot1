package com.yi23.springboot.interview;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author : 王斌
 * @Date : 2019/4/24 下午11:54
 * @Description 描述
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new  ArrayBlockingQueue(3);

       blockingQueue.put("a");
       blockingQueue.put("b");
       blockingQueue.put("c");
        System.out.println("=====");
//       blockingQueue.put("d");

       blockingQueue.take();
       blockingQueue.take();
       blockingQueue.take();
        System.out.println("take=======");
       blockingQueue.take();


    }

    public static void test1(){
        BlockingQueue<String> blockingQueue = new  ArrayBlockingQueue(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }
}
