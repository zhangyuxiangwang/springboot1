package com.yi23.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Author : 王斌
 * @Date : 2019/1/25 下午1:24
 * @Description 测试事物
 */
@Mapper
@Component
public interface PropagationDao {

    /**
     * 修改值
     * @param id
     * @param pid
     */
    void updateAllocationOrderDetail(@Param("id") Integer id, @Param("pid") Integer pid);
}
