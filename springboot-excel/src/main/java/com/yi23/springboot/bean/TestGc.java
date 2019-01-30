package com.yi23.springboot.bean;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * 这个遏制y是给gc设置一些参数，Xms 是设置设置堆堆最大的内存大小，Xmx
 * 是设置堆最小的值，Xmn是设置年轻代的大小。
 */
public class TestGc {

    private static final int  _1MB=1024*1024;

    public static void main(String[] args) {
        byte[] allocation1 ,allocation2,allocation3,allocation4;

        allocation1=new byte[2 * _1MB ];
        allocation2=new byte[2 * _1MB ];
        allocation3=new byte[2 * _1MB ];
        allocation4=new byte[4 * _1MB ];
    }
}
