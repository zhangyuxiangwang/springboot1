package com.jrj.springboot.service.impl;

import com.jrj.springboot.bean.Response;
import com.jrj.springboot.service.UserService;
import org.redisson.RedissonClient;
import org.redisson.core.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author : 王斌
 * @Date : 2019/3/28 上午10:06
 * @Description 描述
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedissonClient redissonClient;

    @Override
    public Response resultResponse() {

        RLock lock = redissonClient.getLock("lock");

        try {
            lock.lock(1000,TimeUnit.MINUTES);
            stringRedisTemplate.opsForValue().get("stockNum");
        }finally {
            lock.unlock();
        }

        return null;
    }
}
