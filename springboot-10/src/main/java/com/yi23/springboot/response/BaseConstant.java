package com.yi23.springboot.response;

/**
 * @Author : 王斌
 * @Date : 2019/3/4 下午4:44
 * @Description 系统错误都是以SYSTEM 开头,业务错误禁止使用以SYSTEM 开头
 */
public class BaseConstant {

    /**
     * 公用的参数错误
     */
    public static final String PARAM_ERROR = "PARAM_ERROR";


    /**
     * 系统错误
     */
    public static final String SYSTEM_ERROR = "SYSTEM_ERROR";


    /**
     * 调用权限错误
     */
    public static final String SYSTEM_AUTH_ERROR = "SYSTEM_AUTH_ERROR";

}
