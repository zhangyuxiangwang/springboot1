package com.yi23.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * @Author : 王斌
 * @Date : 2019/3/16 下午2:06
 * @Description 描述
 */
public class SmartMyslefListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        System.out.println("SmartMyslefListener--supportsEventType---");
        return false;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("SmartMyslefListener--onApplicationEvent---"+applicationEvent.getTimestamp());
    }
}
