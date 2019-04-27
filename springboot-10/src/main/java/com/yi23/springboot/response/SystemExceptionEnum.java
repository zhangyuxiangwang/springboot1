package com.yi23.springboot.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author : 王斌
 * @Date : 2019/3/4 下午5:07
 * @Description 描述
 */
@Getter
@AllArgsConstructor
public enum  SystemExceptionEnum {
    /**
     * 不可预知的错误，在整个拦截器最外层进行拦截
     */
    SERVICE_ERROR(106),

    /**
     * 业务的参数错误
     */
    PARAM_ERROR(105),

    /**
     * 重复的错误，目前业务端在用，已知的情况是重复支付 返回
     */
    REPEAT_ERROR(110),

    /**
     * 没有权限访问
     */
    NO_PERMISSION(10000),;


    private int value;
}
