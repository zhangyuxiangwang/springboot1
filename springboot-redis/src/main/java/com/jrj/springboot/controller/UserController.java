package com.jrj.springboot.controller;

import com.jrj.springboot.bean.Response;
import com.jrj.springboot.config.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Config;
import org.redisson.RedissonClient;
import org.redisson.SingleServerConfig;
import org.redisson.client.codec.StringCodec;
import org.redisson.core.RBucket;
import org.redisson.core.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author : 王斌
 * @Date : 2019/3/26 下午6:32
 * @Description 描述
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    RedissonClient redissonClient;

    @RequestMapping("test")
    public Response getUser(){
        return Response.builder()
                .code(200)
                .message("成功")
                .data(00).build();
    }

    @RequestMapping("redis")
    public Response getRedis(){

        //redisson配置
        Config config = new Config();
        SingleServerConfig singleSerververConfig = config.useSingleServer();
        singleSerververConfig.setAddress("127.0.0.1:6379");
        //redisson客户端
        RedissonClient redissonClient = RedisUtils.getInstance().getRedisson(config);
        RBucket<Object> rBucket = RedisUtils.getInstance().getRBucket(redissonClient, "key");
        //rBucket.set("wangnian");
        System.out.println(rBucket.get());

        while (true) {
            RLock lock = redissonClient.getLock("lock");
            //第一个参数代表等待时间，第二是代表超过时间释放锁，第三个代表设置的时间制
            lock.lock();
            try {
                lock.tryLock(0, 1, TimeUnit.SECONDS);
                System.out.println("执行");
                return Response.builder()
                        .code(200)
                        .message("成功")
                        .data(00).build();
            }catch (Exception e){
                return Response.builder()
                        .code(200)
                        .message("成功")
                        .data(00).build();
            }finally {
                lock.unlock();
            }
        }
    }

    @RequestMapping("ression")
    public Response ression(){

        RLock lock = redissonClient.getLock("lock");

        try{
            lock.lock();

        }catch (Exception e){

        }finally {
            lock.unlock();
        }

        return Response.builder()
                .code(200)
                .message("成功")
                .data(00).build();
    }

}
