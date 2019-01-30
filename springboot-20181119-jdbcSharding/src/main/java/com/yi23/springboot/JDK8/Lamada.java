package com.yi23.springboot.JDK8;

import com.yi23.springboot.bean.AllocationOrderDetail;
import org.assertj.core.util.Lists;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author : 王斌
 * @Date : 2019/1/29 下午2:04
 * @Description 测试一些lamada表达式
 */
public class Lamada {

    public static void main(String[] args) {

        Map<String, Object> result = null;

        result.put("hhh",88);

//        mapAndFlatMap();
//        testPeek();
    }

    public static void testSkipAndLimit(){
        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);

        System.out.println("sum is:"+nums.stream().
                filter(num -> num != null).distinct().mapToInt(num -> num * 2)
                .peek(System.out::println).skip(2).limit(4).sum());
        System.out.println("sum is:"+nums.stream().
                filter(num -> num != null).distinct().mapToInt(num -> num * 2)
                .peek(System.out::println).limit(4).sum());
        System.out.println("sum is:"+nums.stream().
                filter(num -> num != null).distinct().mapToInt(num -> num * 2)
                .peek(System.out::println).skip(2).sum());
        System.out.println("sum is:"+nums.stream().
                filter(num -> num != null).distinct().mapToInt(num -> num * 2)
                .peek(System.out::println).sum());
    }

    public static void mapAndFlatMap(){
        /**获取单词，并且去重**/
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world",
                "hello world welcome");

        //map和flatmap的区别
        list.stream().map(item -> Arrays.stream(item.split(" "))).distinct()
                .collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------- ");
        list.stream().flatMap(item -> Arrays.stream(item.split(" ")))
                .distinct().collect(Collectors.toList()).forEach(System.out::println);

        //实际上返回的类似是不同的
        List<Stream<String>> listResult = list.stream().map(item -> Arrays.stream(item.split(" ")))
                .distinct().collect(Collectors.toList());
        List<String> listResult2 = list.stream().flatMap(item -> Arrays.stream(item.split(" ")))
                .distinct().collect(Collectors.toList());

        System.out.println("---------- ");

        //也可以这样
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("================================================");

        /**相互组合**/
        List<String> list2 = Arrays.asList("hello", "hi", "你好");
        List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2))
                .collect(Collectors.toList()).forEach(System.out::println);
        list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2))
                .collect(Collectors.toList()).forEach(System.out::println);

        //实际上返回的类似是不同的
        List<Stream<String>> list2Result = list2.stream()
                .map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        List<String> list2Result2 = list2.stream()
                .flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());

        List<String> collect = list2.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);

        List<String> collect1 = list3.stream()
                .peek(item -> item="hao").collect(Collectors.toList());
        collect1.forEach(System.out::println);

    }

    public static void testPeek(){
        AllocationOrderDetail build = AllocationOrderDetail.builder().build();

        List<AllocationOrderDetail> list=new ArrayList<>();
        list.add(build);
        list.stream().peek(allocationOrderDetail -> {
            allocationOrderDetail.setId(100);
        }).forEach(System.out::println);

        List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
        List<String> collect1 = list3.stream()
                .peek(item ->{
                    item.substring(1);
                }).collect(Collectors.toList());
        collect1.forEach(System.out::println);
    }



}
