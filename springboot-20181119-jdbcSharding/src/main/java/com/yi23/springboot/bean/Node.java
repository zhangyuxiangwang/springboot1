package com.yi23.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : 王斌
 * @Date : 2019/3/22 下午1:16
 * @Description 描述
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Node {

    private Integer nodeId;

    private Node next;

}
