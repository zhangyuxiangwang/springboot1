package com.yi23.springboot.interview;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : 王斌
 * @Date : 2019/4/24 上午12:11
 * @Description 描述
 */
public class RentrantLockTest {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock(true);
    }
}
