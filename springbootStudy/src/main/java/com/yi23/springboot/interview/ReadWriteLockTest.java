package com.yi23.springboot.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author : 王斌
 * @Date : 2019/4/24 下午9:53
 * @Description 描述
 * ReentrantReadWriteLock  读写锁
 */

public class ReadWriteLockTest {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();

        for (int i=0;i<5;i++){
            final int temp=i;
            new Thread(()->{
                myCache.write(temp+"",temp+"");
            },"write线程"+i).start();
        }


        for (int i=0;i<5;i++){
            final int temp=i;
            new Thread(()->{
                myCache.read(temp+"");
            },"read线程"+i).start();
        }
    }
}

class MyCache{

    private volatile Map<String,Object> map = new HashMap<>(16);

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void read(String key){

        reentrantReadWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在读++++");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读完了++++"+result);
        }catch (Exception e){

        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    public void write(String key,Object object){

        reentrantReadWriteLock.writeLock().lock();

        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写---"+key);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,object);
            System.out.println(Thread.currentThread().getName()+"\t 写完了----");
        }catch (Exception e){

        }finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

}
