package com.yi23.springboot.bean;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 1、测试老年代，大对象是直接存到老年代的
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 *
 * PretenureSizeThreshold这个参数只对Serial和ParNew有效，对Parallel Scavenge没有作用。
 *
 *
 * 2、测试长期存活的对象将进入老年代
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 *
 * 3、动态对象年龄判定：
 * 当幸存空间的相同年龄的所有对象的和大于等于幸存区的一半，把大于等于这个年龄的对象移到老年代。
 * 4、空间分配担保
 * 就是在minorGC的时候，首先会检查老年代能否存下新生代的所有对象，如果可以，就是安全的，如果不可以，虚拟机会检查HandlePromotionFailure设置是否
 * 允许担保，如果允许的会检查老年代最大可用连续空间是否大于历次晋升到老年代对象的平均值，大于曾是minorGC，尽管有风险。
 * 如果不允许就不允许尝试，直接fullgC
 *
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
 * JDK 6 Update 24之后的规则变为只要老年代的连续空间大于新生代对象总大小或者历次晋升的平均大小就会进行Minor GC，否则将进行Full GC。
 *这个HandlePromotionFailure在JDK1.6以后不起作用了。
 *
 *
 */
public class TestGCOld {

    private static final int Mb1=6 * 1024;

    public static void main(String[] args) throws IOException {

        byte[] allocation1=new byte[4 * Mb1];
//        byte[] allocation2=new byte[4 * Mb1];
//        byte[] allocation3=new byte[4 * Mb1];
//        allocation1=null;
//        byte[] allocation4=new byte[4 * Mb1];
//        byte[] allocation5=new byte[4 * Mb1];
//        byte[] allocation6=new byte[4 * Mb1];
//        allocation4=null;
//        allocation5=null;
//        allocation6=null;
//        byte[] allocation7=new byte[4 * Mb1];
//
//        System.out.println(3145728/1024);
        test();

        System.in.read();

        System.out.println(10240*0.8/1024);
    }



    private static void test(){
        List<TestGCOld> tist=new ArrayList<>();
        for (int i=0;i<1000;i++) {
            TestGCOld testGCOld = new TestGCOld();
            tist.add(testGCOld);
            try{
                Thread.sleep(200);
            }catch (Exception e){

            }


        }
    }

}
