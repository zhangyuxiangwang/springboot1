package com.yi23.springboot.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author : 王斌
 * @Date : 2019/3/4 下午4:38
 * @Description 描述
 *   <pre>
 *   注意 isSuccess() 判断是否存在code值,如果存在code表示这次请求存在错误,需要调用方根据返回的code进行处理
 *   </pre>
 */
@Data
public class BaseResponseVO<T extends Serializable > implements Serializable {

    /**
     * 业务返回的code,用来做业务判断,必须是大写加下划线分割
     * <p>
     * 业务错误禁止使用以SYSTEM开头
     * <p>
     * <p>
     * 例如  FREE_PURCHASE_SUCCESS
     * <p>
     * 有一些通用性错误代码 {@linkplain BaseConstant}
     */
    private String code;

    /**
     * 返回的信息
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 额外数据,比如错误信息的时候,返回的并不是 T 类型的数据
     */
    private Map<String,String> extraData;


    public BaseResponseVO(T data) {
        this.data = data;
    }

    public BaseResponseVO(String code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public BaseResponseVO(String code, String msg, Map<String, String> extraData) {
        this.code = code;
        this.message = msg;
        this.extraData = extraData;
    }

    public BaseResponseVO(String code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }
    /**
     * 判断是否执行成功
     * 就是判断code不为空,表示成功
     */
    public boolean isSuccess() {
        int strLen;
        if (code != null && (strLen = code.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(code.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }
}
