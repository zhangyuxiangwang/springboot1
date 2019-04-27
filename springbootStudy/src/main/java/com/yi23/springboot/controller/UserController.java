package com.yi23.springboot.controller;

import com.yi23.springboot.bean.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("getMassage")
    public Response getUser(){
        return Response.builder()
                .code(200)
                .message("成功")
                .data(00).build();
    }
}
