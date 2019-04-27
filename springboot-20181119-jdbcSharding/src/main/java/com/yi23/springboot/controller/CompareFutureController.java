package com.yi23.springboot.controller;

import com.yi23.springboot.bean.Response;
import com.yi23.springboot.service.AllocationOrderDetailService;
import com.yi23.springboot.service.PropagationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : 王斌
 * @Date : 2019/3/22 上午11:45
 * @Description 描述
 */
@RestController
@RequestMapping("/future")
public class CompareFutureController {
    @Autowired
    PropagationService propagationService;

    @Autowired
    private AllocationOrderDetailService allocationOrderDetailService;


    @RequestMapping("/nested")
    public Response nested(){
        return Response.builder().code(100).message("success").data(allocationOrderDetailService.getAllocationOrderDetailListFuture()).build();
    }



}
