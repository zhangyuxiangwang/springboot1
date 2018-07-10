package com.atguigu.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfigMyself extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll() //这个的意思是为/下的开启所有的权限
		.antMatchers("/level1/**").hasRole("VIP1")//只有角色是VIP1才能访问level/下的资源
		.antMatchers("/level2/**").hasRole("VIP2")
		.antMatchers("/level3/**").hasRole("VIP3");
		//这个是自动配置的登陆功能，如果没有登录，会跳转到登录页面，没有权限就会跳转到登录页面
		/**
		 * 
		 */
		http.formLogin().loginPage("/userlogin");
		
		//这个是开启自动注销的功能
		http.logout().logoutSuccessUrl("/");
		
		//这个是开启记住我的功能，只要打开他，在每次登录的时候，都会向浏览器发送一个cookie，把登录信息保存到cookie
		//里面，达到记住我的功能
		http.rememberMe().rememberMeParameter("rember");
	}
	
	//注册权限，和角色
	@Autowired
	public void configuration(AuthenticationManagerBuilder  auth){
		try {
			auth.inMemoryAuthentication()
			.withUser("wangbin").password("123456").roles("VIP1","VIP2")
			.and()
			.withUser("wang").password("123456").roles("VIP2","VIP3")
			.and()
			.withUser("bin").password("123456").roles("VIP1","VIP3");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
}
