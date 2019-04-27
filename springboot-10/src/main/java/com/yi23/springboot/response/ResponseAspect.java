package com.yi23.springboot.response;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author : 王斌
 * @Date : 2019/3/4 下午5:29
 * @Description 描述
 */
@Aspect
@Slf4j
public class ResponseAspect {

    @Pointcut("execution(com.yi23.springboot.response.BaseResponseVO com.yi23.*...*(..) )")
    private void andRPCResponseMethod() {
    }

    @Around("andRPCResponseMethod()")
    public Object handleRPCResponseMethod(ProceedingJoinPoint pjp) {
        try {
            return pjp.proceed();
        } catch (SystemException yi23ParamEx) {
            log.debug("yi23 message {}", yi23ParamEx.getMessage());
            return new BaseResponseVO(BaseConstant.PARAM_ERROR, yi23ParamEx.getMessage());
        } catch (Throwable ex) {
            log.error("error", ex);
            return new BaseResponseVO(BaseConstant.SYSTEM_ERROR, "服务器繁忙...");
        }
    }
}
