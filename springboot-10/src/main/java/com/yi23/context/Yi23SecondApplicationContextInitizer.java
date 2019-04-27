package com.yi23.context;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * @Author : 王斌
 * @Date : 2019/3/15 下午7:57
 * @Description 描述
 */
public class Yi23SecondApplicationContextInitizer implements ApplicationContextInitializer,Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("Yi23SecondApplicationContextInitizer--init--");
    }

    public Yi23SecondApplicationContextInitizer(){
        System.out.println("Yi23SecondApplicationContextInitizer--构造器");
    }

    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER-2;
    }
}
