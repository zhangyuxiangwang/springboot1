package com.yi23.springboot.configuration;

import com.yi23.springboot.interceptor.MybatisInterptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 把mybatis插件注册到容器中
 */
@Configuration
public class MybatisLogInterceptorConfig {

    @Bean
    public MybatisInterptor mybatisLogInterceptor(){
        return new MybatisInterptor();
    }
}
