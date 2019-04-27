package com.yi23.springboot.response;

import lombok.Data;

/**
 * @Author : 王斌
 * @Date : 2019/3/4 下午5:06
 * @Description 描述
 */
@Data
public class SystemException extends RuntimeException {

    /**
     * 异常的枚举类
     */
    private SystemExceptionEnum systemExceptionEnum;

    /**
     * 错误的信息
     */
    private String message;

    private Object data;

    public SystemException(SystemExceptionEnum systemExceptionEnum,String message){
        super(message);
        this.message=message;
        this.systemExceptionEnum=systemExceptionEnum;
    }

    public SystemException(SystemExceptionEnum systemExceptionEnum,String message,Object data){
        super(message);
        this.message=message;
        this.systemExceptionEnum=systemExceptionEnum;
        this.data=data;
    }
}
