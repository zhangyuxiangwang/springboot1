package com.yi23.springboot.interview;

/**
 * @Author : 王斌
 * @Date : 2019/4/24 上午12:46
 * @Description 描述
 * 可重入锁 这个掩饰Synchroized是可重入锁
 */
public class RentrantLockTest2 {

    public static void main(String[] args) {
        Phone phone = new  Phone();

        new Thread(()->{
            phone.sendSMS();
        },"线程1") .start();

        new Thread(()->{
            phone.sendSMS();
        },"线程2") .start();
    }
}

class Phone{
    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getName()+"\t sendSMS()");
        sendEmail();
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"\t sendEmail()");
    }
}