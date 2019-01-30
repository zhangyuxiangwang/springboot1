package com.yi23.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 配置线程池
 */
@Configuration
public class ThreadPoolConfiguration {

    /**
     * 核心线程数，
     */
    private final Integer corePoolSize=100;

    /**
     * 最大线程数
     */
    private final Integer maxPoolSize=200;
    /**
     * 在线程池空闲时，且线程数大于核心线程数的时候，大于这个时间的时候，就销毁了。
     */
    private final Integer keepAliveSeconds=300;

    /**
     * 最大队列数量
     */
    private final Integer queueCapacity=500;

    @Bean(initMethod = "initialize",destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        threadPoolTaskExecutor.setThreadNamePrefix("Thread-wangbin-");
        return threadPoolTaskExecutor;
    }

}
