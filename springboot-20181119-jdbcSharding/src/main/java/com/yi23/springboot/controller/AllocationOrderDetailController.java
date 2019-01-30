package com.yi23.springboot.controller;

import com.yi23.springboot.bean.AllocationOrderDetail;
import com.yi23.springboot.bean.Response;
import com.yi23.springboot.service.AllocationOrderDetailService;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/all")
public class AllocationOrderDetailController {

    @Autowired
    private AllocationOrderDetailService allocationOrderDetailService;

    /**
     * 查询多个值
     * @return
     */
    @RequestMapping("/all")
    public Response getAllocationOrderDetail(){

        return Response.builder().code(200).message("成功").data(allocationOrderDetailService.getAllocationOrderDetail()).build();
    }

    /**
     * 多线程去查询
     * @return
     */
    @RequestMapping("/list1")
    public Response getAllocationOrderDetailList1(){
        return Response.builder().code(200).message("success").data(allocationOrderDetailService.getAllocationOrderDetailList1()).build();
    }

    /**
     * 测试
     * @return
     */
    @RequestMapping("/test")
    public Response getTest(){
        return Response.builder().code(200).message("success").data(allocationOrderDetailService.getTest()).build();
    }

    /**
     * 测试线程
     * @return
     */
    @RequestMapping("/thread")
    public Response getThread(){
        return Response.builder().code(200).message("success").data(allocationOrderDetailService.getThread()).build();
    }

    /**
     * 和上面的方法进行对比
     * @return
     */
    @RequestMapping("/noThread")
    public Response getNoThread(){
        return Response.builder().code(200).message("success").data(allocationOrderDetailService.getNoThread()).build();
    }

    public static void main(String[] args) {
        String str = "1627335184.1";
//        str=str.replace(' ',' ').trim();
//        System.out.println(str);
//        String str2=str.replaceAll(" ","");
//
//        System.out.println(NumberUtils.isNumber(str2));
//
//        Integer integer = NumberUtils.toInt(str);
//        Integer i = NumberUtils.createInteger(str);
//        System.out.println(i);
//        System.out.println(integer);
//        System.out.println(str2);
//        System.out.println();

//        System.out.println(StringUtils.isNumeric("1223131213212312.1"));
//
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isEmpty(" "));
        System.out.println(isOfInteger(str));
        System.out.println(isOfInteger(" 3233439"));
        System.out.println(isOfInteger("s3233439"));
        System.out.println(isOfInteger("-1111111111"));
        System.out.println(isOfInteger("-111111"));
        Integer i =-100;

        System.out.println(isOfInteger1("1").toString());


    }

    public static boolean isInteger(String str){

        if(StringUtils.isNotBlank(str)
                && StringUtils.isNumeric(str)
                && new BigDecimal(""+Integer.MAX_VALUE).compareTo(new BigDecimal(str))>=0){
            return true;
        }
        return false;
    }


    public static boolean isOfInteger(String str){

        return StringUtils.isNotBlank(str)
                && StringUtils.isNumeric(str)
                && new BigDecimal(""+Integer.MAX_VALUE).compareTo(new BigDecimal(str))>=0;
    }



    public static List<Map<String,Integer>> isOfInteger1(String str){

        List<Map<String,Integer>> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        map.put("10",10);
        list.add(map);
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("20",20);
        list.add(map1);

        return list.stream().filter(lists->lists.containsKey("20")).collect(Collectors.toList());
    }
}
