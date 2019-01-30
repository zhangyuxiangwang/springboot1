package com.yi23.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    /**
     * 返回信息的说明
     */
    private String message;
    /**
     * 返回消息码
     */
    private Integer code;
    /**
     * 消息的内容
     */
    private Object data;
}
