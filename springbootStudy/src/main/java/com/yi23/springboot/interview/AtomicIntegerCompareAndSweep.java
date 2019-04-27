package com.yi23.springboot.interview;

import lombok.Builder;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author : 王斌
 * @Date : 2019/4/22 下午8:42
 * @Description 描述
 */
public class AtomicIntegerCompareAndSweep {

    public static void main(String[] args) {
        User xiaoming = User.builder().age(10).name("xiaoming").build();
        User user = User.builder().age(20).name("小王").build();

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(xiaoming);

        System.out.println(atomicReference.compareAndSet(xiaoming,user)+"\t\n"+atomicReference.get());
        System.out.println(atomicReference.compareAndSet(xiaoming,user)+"\t\n"+atomicReference.get());
    }
}

@Builder
@Data
class User{
    private Integer age;
    private String name;
}
