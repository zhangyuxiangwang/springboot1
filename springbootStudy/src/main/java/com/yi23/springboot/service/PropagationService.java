package com.yi23.springboot.service;

/**
 * @Author : 王斌
 * @Date : 2019/1/25 下午1:22
 * @Description 测试事物
 */
public interface PropagationService {

    /**
     * 更新1
     * @param id
     * @param pid
     */
    Integer updateAllocationOrderDetailOne(Integer id,Integer pid);

    /**
     * 跟新2
     * @param id
     * @param pid
     */
    Integer updateAllocationOrderDetailSeconde(Integer id, Integer pid);


}
