package com.yi23.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

/**
 * @Author : 王斌
 * @Date : 2019/3/22 上午11:23
 * @Description 描述
 */
public class FristApplicationContextAware implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Resource name = applicationContext.getResource("name");
        System.out.println(name+"----FristApplicationContextAware--");
    }
}
