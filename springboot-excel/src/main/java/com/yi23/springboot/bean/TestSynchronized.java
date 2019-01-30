package com.yi23.springboot.bean;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.lang3.StringUtils;


import java.math.BigDecimal;

/**
 * 这个可以出现死锁，可以使用命令找到造成死锁的线程是哪一个，
 * jstack pid 定位到那个代码，是什么原因造成了死锁，那行代码。
 * jstack 这个命令是记录线程操作的所有过程（状态），死锁，等待、死循环、等待外部资源等，包括数据库连接等。
 * jps可以查出pid
 * jstat可以查询出gc的一些情况，jstat -gcutil pid ;jstat -gc pid;
 *
 * jinfo pid 可以查询所有配置的信息。
 *
 */
class SynchronizedClass implements Runnable{


    int a,b;
    public  SynchronizedClass(int a,int b){
       this.a=a;
       this.b=b;
    }


    @Override
    public void run() {

        synchronized (Integer.valueOf(a)){
            synchronized (Integer.valueOf(b)){
                System.out.println(a+b);
            }
        }
    }
}

public class TestSynchronized {

    public static void main(String[] args) {

        for (int i=0;i<100;i++){
            new Thread(new SynchronizedClass(1,2)).start();
            new Thread(new SynchronizedClass(2,1)).start();
        }



    }

}
