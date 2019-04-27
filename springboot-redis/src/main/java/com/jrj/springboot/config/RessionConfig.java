package com.jrj.springboot.config;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.SingleServerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : 王斌
 * @Date : 2019/3/27 下午5:16
 * @Description 描述
 */
@Configuration
public class RessionConfig {

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://localhost:6379");

        return Redisson.create(config);
    }
}
