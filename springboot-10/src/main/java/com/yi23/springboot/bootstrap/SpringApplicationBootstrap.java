package com.yi23.springboot.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link SpringApplication} 启动引导类
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since
 */
//@SpringBootApplication
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();

        //设置配置源
        Set<String> sources = new HashSet<>();
        sources.add(Yi23ApplicationConfiguration.class.getName());
        springApplication.setSources(sources);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = springApplication.run(args);

        System.out.println("Demo Bean : "+ context.getBean(Yi23ApplicationConfiguration.class));
    }

    //注解驱动配置Bean源
    @SpringBootApplication
    public static class Yi23ApplicationConfiguration{

    }
}
