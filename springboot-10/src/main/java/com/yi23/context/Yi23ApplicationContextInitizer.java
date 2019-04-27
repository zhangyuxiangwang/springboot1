package com.yi23.context;

import ch.qos.logback.classic.util.ContextInitializer;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.Annotation;

/**
 * @Author : 王斌
 * @Date : 2019/3/15 下午5:40
 * @Description 描述
 */
public class Yi23ApplicationContextInitizer implements ApplicationContextInitializer,Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("Yi23ApplicationContextInitizer-- 初始化");
    }

    public Yi23ApplicationContextInitizer(){
        System.out.println("Yi23ApplicationContextInitizer的构造器");
    }

    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER-1;
    }
}
