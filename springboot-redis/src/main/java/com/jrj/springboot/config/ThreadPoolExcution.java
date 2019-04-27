package com.jrj.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Author : 王斌
 * @Date : 2019/3/28 上午10:13
 * @Description 配置线程池
 */
@Configuration
public class ThreadPoolExcution {

    @Bean(initMethod = "initialize",destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor threadPoolExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // ==最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(100);
        // ==核心线程数
        threadPoolTaskExecutor.setCorePoolSize(50);
        // ==等待线程数
        threadPoolTaskExecutor.setQueueCapacity(500);
        // ==在没有使用的情况下存活的时间
        threadPoolTaskExecutor.setKeepAliveSeconds(6000);
        // ==当超过存活时间
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
        threadPoolTaskExecutor.setThreadNamePrefix("wangbin-thread-");
        return threadPoolTaskExecutor;
    }
}
