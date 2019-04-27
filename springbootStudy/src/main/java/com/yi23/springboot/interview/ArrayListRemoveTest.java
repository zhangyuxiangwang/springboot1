package com.yi23.springboot.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @Author : 王斌
 * @Date : 2019/4/23 下午8:19
 * @Description 描述
 */
public class ArrayListRemoveTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
            System.out.println(item);
        }

        System.out.println("---");

        List<String> lists =new ArrayList<>();
        lists.add("1");
        lists.add("2");
        List<String> collect = lists.stream().filter("2"::equals).collect(Collectors.toList());
        System.out.println(collect);
    }
}
