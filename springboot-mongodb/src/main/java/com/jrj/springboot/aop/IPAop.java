package com.jrj.springboot.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jrj.springboot.util.IPUtils;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author bin
 * 记录访问ip的
 *
 */
@Aspect
@Slf4j
//@Component
public class IPAop {
	@Before("pointweb()")
	public Object before(JoinPoint point) throws Throwable{

		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String string = IPUtils.getIpAddress(request);
		log.debug("ip:{}",string);
		return "";
	}
	
	@Pointcut("execution(public * com.jrj.springboot.controller..*.*(..))")
	public void pointweb(){}

}
