package com.yi23.springboot.dao;

import com.yi23.springboot.bean.AllocationOrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface AllocationOrderDetailDao {

    /**
     * 查询多个值
     * @return
     */
    public List<AllocationOrderDetail> getAllocationOrderDetail();

    /**
     * 多线程去查询
     * @return
     */
    public List<AllocationOrderDetail> getAllocationOrderDetailList1(Map<String, String> map);

    public List<Map<String,Object>> getTest();
}
