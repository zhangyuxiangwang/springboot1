package com.yi23.event;

import java.util.EventObject;

/**
 * @Author : 王斌
 * @Date : 2019/3/16 下午3:57
 * @Description 描述
 */
public class DoorEvent extends EventObject {

    private final String key;
    private final String value;

    public DoorEvent(Object source,String key , String value) {
        super(source);
        this.key=key;
        this.value=value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
