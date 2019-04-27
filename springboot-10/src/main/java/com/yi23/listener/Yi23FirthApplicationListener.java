package com.yi23.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Author : 王斌
 * @Date : 2019/3/16 下午1:29
 * @Description 描述
 */
public class Yi23FirthApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        System.out.printf("After 上下文内容id:%s,timestamp:%s.",
                applicationEvent.getApplicationContext().getId(), applicationEvent.getTimestamp());
    }
}
