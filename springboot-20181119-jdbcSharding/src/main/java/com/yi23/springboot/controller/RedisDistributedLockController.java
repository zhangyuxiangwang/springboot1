package com.yi23.springboot.controller;

import com.yi23.springboot.bean.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : 王斌
 * @Date : 2019/3/26 下午4:59
 * @Description 描述
 */
@RestController
@RequestMapping("/all")
public class RedisDistributedLockController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;


    @RequestMapping("/redis")
    public Response getUser(){
        String name=stringRedisTemplate.opsForValue().get("stockNum");

        stringRedisTemplate.opsForValue().set("number","90");

        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object xiao = valueOperations.get("number");
        return Response.builder()
                .code(200)
                .message("成功")
                .data(name+"--"+xiao).build();
    }
}
