package com.yi23.springboot.response;

/**
 * @Author : 王斌
 * @Date : 2019/3/4 下午4:48
 * @Description 参数的断言 特有的断言,会抛出特定的异常信息
 */
public class ParamAssert {

    private ParamAssert(){}

    /**
     * 如果为空,会抛出参数错误的异常
     *
     * @param obj  需要判断为空的对象
     * @param message 提示的错误信息
     * @see SystemExceptionEnum
     */
    public static void notEmpty(Object obj,String message){
        if(DataUtils.isEmpty(obj)){
            throw new ParamAssertException(message);
        }
    }
}
