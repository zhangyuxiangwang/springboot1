package com.yi23.springboot.JDK8;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : 王斌
 * @Date : 2019/1/30 下午3:27
 * @Description 这个类是比较stream、for、foreach的效率问题，
 *
 * 结论：通过上述比较，在共同对Demo遍历100万次的过程中，for循环比forEach快78毫秒，
 * 而forEach又比stream快678毫秒，而for比stream快756毫秒。参考代码量与执行效率，我们不难得出如下结论：
 * 它们的执行效率排序为 ：for > forEach > stream
 * 它们的代码编写量排序为：for < forEach < stream
 */
@Slf4j
public class TestLamadaRatio {


    static List<Demo> demoList = null;
    static List<Integer> traditionList = null;
    static List<Integer> forEachList = null;
    static List<Integer> streamList = null;

    /**
     * 准备数据
     */
    public static void prepareDatabase(){
        demoList = Lists.newArrayList();
        traditionList = Lists.newArrayList();
        forEachList = Lists.newArrayList();
        streamList = Lists.newArrayList();
        String str = "这个是干扰字段;这个是干扰字段;这个是干扰字段;这个是干扰字段;这个是干扰字段;" +
                "这个是干扰字段;这个是干扰字段;这个是干扰字段;这个是干扰字段;这个是干扰字段;这个是干扰字段;" +
                "这个是干扰字段;这个是干扰字段;这个是干扰字段;这个是干扰字段;这个是干扰字段;这个是干扰字段;" +
                "这个是干扰字段;这个是干扰字段;这个是干扰字段;";
        for(int i = 0;i < 1000000;i ++){
            Demo demo = new Demo(i,str);
            demoList.add(demo);
        }
    }

    /**
     * 传统的方式
     * @return
     */
    public static long traditionMethod(){
        Date date = new Date();
        int traditionListLength = traditionList.size();
        for(int i = 0;i < traditionListLength;i ++){
            traditionList.add(demoList.get(i).getIndex());
        }
        Date date2 = new Date();
        return date2.getTime() - date.getTime();
    }

    /**
     * forEach方式
     * @return
     */
    public static long forEachMethod(){
        Date date = new Date();
        demoList.forEach(demo -> {
            forEachList.add(demo.getIndex());
        });
        Date date2 = new Date();
        return date2.getTime() - date.getTime();
    }

    /**
     * stream方式
     * @return
     */
    public static long streamMethod(){
        Date date = new Date();
        streamList = demoList.stream().map(demo -> demo.getIndex()).collect(Collectors.toList());
        Date date2 = new Date();
        return date2.getTime() - date.getTime();
    }

    public static void main(String[] args) {
        prepareDatabase();
        long time1 = traditionMethod();
        long time2 = forEachMethod();
        long time3 = streamMethod();
        log.info("for与forEach比较结果为：" + (time1 - time2));
        log.info("forEach与stream比较结果为：" + (time2 - time3));
        log.info("for与stream比较结果为：" + (time1 - time3));

    }

}
