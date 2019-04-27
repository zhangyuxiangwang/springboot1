package com.yi23.springboot.interview;

/**
 * @Author : 王斌
 * @Date : 2019/4/22 上午1:10
 * @Description 这个单例模式能够保证在多线程下只产生一个实例。
 * 原因在于某一个线程执行到第一次检测，读取到到
 *
 * singleTest不为null时，
 * singleTest到引用对象可能没有完成初始化。
 * singleTest = new SingleTest();可以分为一下3步完成(伪代码)
 *
 * 步骤1:memory = allocate()//1.分配对象内存空间
 * 步骤2:allocate(memory)//2.初始化对象
 * 步骤3:singleTest = memory //3.设置singleTest指向刚分配到内存地址，此时singleTest != null
 *        步骤2和步骤3不存在数据依赖关系，而且无论重排序还是重排序后程序到执行结果在单线程中并没有改变，因此这种重排序优化是允许的。memory = allocate()//1.分配对象内存空间 singleTest = memory //3.设置singleTest指向刚分配到内存地址，此时singleTest != null，但是对象还没有初始化完成！allocate(memory)//2.初始化对象
 * 但是指令重排序只会保证串行语义的执行的一致性(单线程)，但并不会关心多线程间的语义一致性。
 * 所以当一条线程访问singleTest不为null时，由于singleTest实例未必已初始化完成，也就造成了线程安全问题。
 */
public class SingleTest {

    private static volatile SingleTest singleTest =null;
    private SingleTest(){
        System.out.println("构造器");
    }

    public static SingleTest getSingleTest(){
        if(singleTest == null){
            synchronized (SingleTest.class){
                if(singleTest==null){
                    singleTest = new SingleTest();
                }
            }
        }
        return singleTest;
    }
}
