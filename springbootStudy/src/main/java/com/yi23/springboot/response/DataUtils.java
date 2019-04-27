package com.yi23.springboot.response;


import com.alibaba.fastjson.JSONObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : 王斌
 * @Date : 2019/3/4 下午4:51
 * @Description 工具类
 */
public class DataUtils {

    /**
     * 判断对象是否为Empty
     * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj){
        if(obj == null){
            return true;
        }
        if(obj == ""){
            return true;
        }
        if(obj instanceof String){
            return ((String)obj).trim().length() == 0;
        }
        if(obj instanceof Collection<?>){
            return ((Collection<?> )obj).size() == 0;
        }
        if(obj instanceof Map<?,?>){
            return ((Map<?,?>)obj).size() == 0;
        }

        return false;
    }

    /**
     * 判断对象是否为NotEmpty(!null或元素>0)<br>
     * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
     *
     * @param obj 待检查对象
     * @return boolean 返回的布尔值
     */
    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }

    /**
     * 将json转换为 map
     *
     * @param objStr
     * @return
     */
    public static Map<String, String> json2Map(String objStr) {
        Map<String, String> data = new HashMap<>();
        JSONObject jsonObject = JSONObject.parseObject(objStr);
        for (Object key : jsonObject.keySet()) {
            String value = jsonObject.getString(key.toString());
            if (isNotEmpty(value)) {
                data.put(key.toString(), value);
            }
        }
        return data;
    }
}
