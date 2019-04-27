package com.yi23.springboot.bootstrap;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring Framework 应用事件引导类
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since
 */
public class SpringApplicationEventBootStrap {
    public static void main(String[] args) {
        //创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //注册应用事件监听器
        context.addApplicationListener(event -> {
            System.out.println("监听到事件：" + event);
        });

        //激活应用上下文
        context.refresh();
        context.publishEvent("Hello Isaac.");

        context.publishEvent(new ApplicationEvent("hello-yi23") {
            //TODO
        });

        //关闭应用上下文
        context.close();
    }
}
