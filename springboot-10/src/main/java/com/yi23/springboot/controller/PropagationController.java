package com.yi23.springboot.controller;

import com.yi23.auto.AutoSpringbootClass;
import com.yi23.springboot.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : 王斌
 * @Date : 2019/1/25 下午1:40
 * @Description
 */
@RestController
@RequestMapping("/user")
public class PropagationController {

    @Autowired
    AutoSpringbootClass autoSpringbootClass;

    @RequestMapping("/test")
    public Response test(){
        return Response.builder().code(200).message("success").data(autoSpringbootClass.test()).build();
    }

}
