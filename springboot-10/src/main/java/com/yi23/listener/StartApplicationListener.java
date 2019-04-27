package com.yi23.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author : 王斌
 * @Date : 2019/3/16 下午2:03
 * @Description 描述
 */
public class StartApplicationListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.err.println("StartApplicationListener---启动监听事件----ApplicationEvent----");
    }
}
