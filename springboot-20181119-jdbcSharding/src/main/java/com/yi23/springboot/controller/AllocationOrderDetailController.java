package com.yi23.springboot.controller;

import com.yi23.springboot.bean.AllocationOrderDetail;
import com.yi23.springboot.bean.Response;
import com.yi23.springboot.service.AllocationOrderDetailService;
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



}
