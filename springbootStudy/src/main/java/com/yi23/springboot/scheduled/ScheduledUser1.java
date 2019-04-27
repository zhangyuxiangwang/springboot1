package com.yi23.springboot.scheduled;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 测试定时任务，他们是默认是串型执行的,使用ScheduledThreadPoolExecutor来执行的，只有一个线程。
 * 可以配置com.yi23.springboot.scheduled.configschedlued.ScheduledConfig这个类，来增加线程数来达到并行执行定时任务。
 */
@Component
@Slf4j
@EnableAsync
public class ScheduledUser1 {

//
//    @Scheduled(cron = "0/1 * * * * ?")
//    public void userSchudledCache(){
//        log.info("定时任务一:-------------");
//    }
//
//    @Scheduled(cron = "0/1 * * * * ?")
//    public void userSchudled(){
//        log.info("定时任务er:-------------");
//    }
//
//    @Scheduled(fixedRate = 5000)
//    public void userSchudle(){
//        log.info("定时任务san:-------------");
//    }

}
