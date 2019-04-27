package com.yi23.springboot.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 自定义高优先级{@link ApplicationContextInitializer}初始化加载器
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloYi23ApplicationContextInitializer
        implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        //可实现如下
//        applicationContext.setEnvironment(new ConfigurableEnvironment() {
//        });
//        applicationContext.setParent();
//        applicationContext.addApplicationListener();
        System.out.println("高优先级初始化加载class : "
                + applicationContext.getId());
    }
}
