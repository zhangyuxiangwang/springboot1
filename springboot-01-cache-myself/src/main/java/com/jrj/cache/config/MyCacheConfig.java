package com.jrj.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 
 * @author 
 *
 */
@Configuration
public class MyCacheConfig {

	/**
	 * KeyGenerator,自定义key的生成
	 * @return
	 */
	@Primary
	@Bean
	public KeyGenerator myKeyGenerator(){
		return new KeyGenerator(){

			@Override
			public Object generate(Object target, Method method, Object... params) {
				String name=target.toString()+method.getName()+Arrays.asList(params).toString();
				return name;
			}
			
		};
	}
	
	
}
