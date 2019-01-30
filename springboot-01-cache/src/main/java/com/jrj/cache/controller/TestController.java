package com.jrj.cache.controller;
import com.jrj.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @Autowired
    DeptService deptService;

    @RequestMapping("/test")
    public String test1(){

        deptService.maps().stream().forEach(x-> System.out.println(x.get("name")));
        return "success";
    }

    @RequestMapping("insert")
    public String insert(){
        deptService.insert("wangbin");
        return "insert";
    }
}
