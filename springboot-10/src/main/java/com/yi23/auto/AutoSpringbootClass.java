package com.yi23.auto;

/**
 * @Author : 王斌
 * @Date : 2019/3/15 下午5:20
 * @Description 描述
 *
 * 第一种自动装配，就是加上@Component 和@Configuration 在spring.factories里面配置上，启动就可以了
 */
@MyComponent
public class AutoSpringbootClass {

    public AutoSpringbootClass() {
        System.out.println("AutoSpringbootClass--");
    }

    public String test(){
        return "AutoSpringbootClass--getBean";
    }
}
