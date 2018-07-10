package com.jrj.springboot.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyMessageConvert {
	
	/**
	 * 通过配置这个来吧rabbit的默认的jdk序列化改成自己想要的序列化的转换器
	 * @return
	 */
	@Bean
	public MessageConverter createMessageConverter(){
		return new Jackson2JsonMessageConverter();
	}

}
