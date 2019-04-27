package com.yi23.springboot.controller;

import com.yi23.springboot.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : 王斌
 * @Date : 2019/3/22 上午11:41
 * @Description 描述
 */
@RestController
@RequestMapping("/user")
public class CompareFutureTestController {

    @RequestMapping("/test1")
    public Response test(){
        return Response.builder().code(200).message("success").build();
    }
}
