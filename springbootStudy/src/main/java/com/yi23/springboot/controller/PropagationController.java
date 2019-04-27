package com.yi23.springboot.controller;

import com.yi23.springboot.bean.Response;
import com.yi23.springboot.service.PropagationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : 王斌
 * @Date : 2019/1/25 下午1:40
 * @Description 测试事物
 */
@RestController
@RequestMapping("/propagetion")
public class PropagationController {

    @Autowired
    PropagationService propagationService;

    @RequestMapping("/nested")
    public Response nested(@RequestParam(value = "id")Integer id, @RequestParam(value = "pid")Integer pid){
        return Response.builder().code(100).message("success").data(propagationService.updateAllocationOrderDetailOne(id,pid)).build();
    }

    @RequestMapping("/new")
    public Response requestNew(@RequestParam(value = "id")Integer id, @RequestParam(value = "pid")Integer pid){
        return Response.builder().code(100).message("success").data(propagationService.updateAllocationOrderDetailOne(id,pid)).build();
    }
}
