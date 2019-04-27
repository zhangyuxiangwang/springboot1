package com.yi23.springboot.service;

import com.yi23.springboot.bean.AllocationOrderDetail;

import java.util.List;
import java.util.Map;

public interface AllocationOrderDetailService {

    /**
     * 查询多个值
     * @return
     */
    public List<AllocationOrderDetail> getAllocationOrderDetail();

    /**
     * 多线程去查询
     * @return
     */
    public List<AllocationOrderDetail> getAllocationOrderDetailList1();

    public List<Map<String,Object>> getTest();

    List<AllocationOrderDetail> getThread();

    List<AllocationOrderDetail> getNoThread();

    /**
     *
     * @return
     */
    List<AllocationOrderDetail> getAllocationOrderDetailListFuture();
}
