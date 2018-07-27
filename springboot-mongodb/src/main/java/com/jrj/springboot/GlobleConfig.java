package com.jrj.springboot;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import lombok.Data;
import lombok.ToString;
/**
 * @ConfigurationProperties这个注解，要把配置文件里面的东西配置进来需要
 * 和@EnableConfigurationProperties一起使用
 * @author Administrator
 *
 */
@Data
@ToString
@ConfigurationProperties(prefix="my.data")
public class GlobleConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int time;
	private int age;
	private String name;
	private String sex;
}
