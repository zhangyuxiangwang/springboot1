package com.yi23.springboot.response;

import lombok.Data;

/**
 * @Author : 王斌
 * @Date : 2019/3/4 下午5:03
 * @Description 描述
 */
@Data
public class ParamAssertException extends  SystemException{


    public  ParamAssertException(String message){
        super(SystemExceptionEnum.PARAM_ERROR,message);
    }
}
