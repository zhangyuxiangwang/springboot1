package com.yi23.springboot.scheduled.configschedlued;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 通过配置上这个就可以使定时任务能并行的执行任务了。
 */

@Configuration
public class ScheduledConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(taskExecutor());

    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskExecutor(){
        return Executors.newScheduledThreadPool(100);
    }
}
