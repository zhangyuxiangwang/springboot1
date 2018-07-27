package com.jrj.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;
/**
 * 这个类是记录每个方法的执行时间的
 * @author bin.wang
 * 2018.7.27
 *
 */
@Aspect
//@Component
@Slf4j
public class AopTimeMethod {
	
	@Pointcut("execution(public * com.jrj.springboot..*.*(..))")
	public void pointCut(){}
	
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable{
		
		StopWatch stop=new StopWatch();
		try {
			stop.start(point.getSignature().getName());
			return point.proceed();
		} finally {
			stop.stop();
			log.debug(stop.prettyPrint());
		}
	}
	


}
