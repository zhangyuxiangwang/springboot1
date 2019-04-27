package com.yi23.auto;

import com.yi23.listener.SmartMyslefListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @Author : 王斌
 * @Date : 2019/3/16 下午3:05
 * @Description 描述
// */
//@Target({ElementType.ANNOTATION_TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Conditional(ConditionalOnClass.class)
//public @interface MyselfConditon {
//    Class<?>[] value() default {};
//    String[] name() default {};
//}
