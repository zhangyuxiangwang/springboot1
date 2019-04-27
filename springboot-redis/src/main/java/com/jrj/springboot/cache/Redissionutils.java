package com.jrj.springboot.cache;

import lombok.extern.slf4j.Slf4j;
import org.redisson.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.core.RBucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author : 王斌
 * @Date : 2019/3/28 上午10:08
 * @Description 描述
 */
@Component
@Slf4j
public class Redissionutils {

    @Autowired
    static RedissonClient redissonClient;

    public static Boolean existsKey(String key) {
        Boolean isExists = redissonClient.getBucket(key, StringCodec.INSTANCE).isExists();
        if (isExists) {
            log.info("anti_repeat_key {} 已存在", key);
            return true;
        } else {
            RBucket<String> rBucket = redissonClient.getBucket(key, StringCodec.INSTANCE);
            rBucket.set("", 1, TimeUnit.MINUTES);
            log.info("anti_repeat_key {} 不存在,已添加成功", key);
            return false;
        }
    }

}
