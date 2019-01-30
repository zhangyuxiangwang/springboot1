package com.yi23.springboot.bean;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;


public class TestArrayUtils {


    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(list));

        Map<String,Object> map = new HashMap<>();
        System.out.println(MapUtils.isEmpty(map));
    }
}
