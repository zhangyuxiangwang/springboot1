package com.yi23.springboot.JDK8;

import lombok.*;

/**
 * @Author : 王斌
 * @Date : 2019/1/30 下午3:27
 * @Description 描述
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"index"})
public class Demo {

    private int index;
    private String str;
}
