package com.yi23.springboot.interview;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author : 王斌
 * @Date : 2019/4/23 上午12:43
 * @Description 集合类不安全之并发修改异常
 */
public class ArrayListException {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> lists = new Vector<>();
        List<String> list1 = Collections.synchronizedList(new ArrayList<>());
        List<String> list2 = new CopyOnWriteArrayList<>();

        for (int i=0;i<30;i++){

            new Thread(()->{
                list2.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list2);
            }).start();
        }
    }
}
