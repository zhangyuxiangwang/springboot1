package com.yi23.springboot.service.impl;

import com.yi23.springboot.bean.AllocationOrderDetail;
import com.yi23.springboot.dao.AllocationOrderDetailDao;
import com.yi23.springboot.service.AllocationOrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
@Slf4j
@Service
public class AllocationOrderDetailServiceImpl implements AllocationOrderDetailService {

    @Autowired
    private AllocationOrderDetailDao allocationOrderDetailDao;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public List<AllocationOrderDetail> getAllocationOrderDetail() {

        return allocationOrderDetailDao.getAllocationOrderDetail();
    }

    @Override
    public List<AllocationOrderDetail> getAllocationOrderDetailList1() {
        Map<String ,String> map = new HashMap<>();
        map.put("limit","10,20");
        try {
            Future<List<AllocationOrderDetail>> submit = threadPoolTaskExecutor.submit(() -> allocationOrderDetailDao.getAllocationOrderDetailList1(map));
            return submit.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> getTest() {
        return allocationOrderDetailDao.getTest();
    }

    @Override
    public List<AllocationOrderDetail> getThread() {
        Map<String,String> map = new HashMap<>();
        CountDownLatch countDownLatch=new CountDownLatch(5);
        List<AllocationOrderDetail> lists=new ArrayList<>();
        for (int i=0;i<5;i++){
            String name=""+(i*5)+",5";
            map.put("limit", name);
//            List<AllocationOrderDetail> list = (List<AllocationOrderDetail>)CompletableFuture.runAsync(
//                    () -> allocationOrderDetailDao.getAllocationOrderDetailList1(map),
//                    threadPoolTaskExecutor).whenComplete((result, item) ->
//                    countDownLatch.countDown());
            List<AllocationOrderDetail> list =
                    null;
            try {
                Future<List<AllocationOrderDetail>> submit = threadPoolTaskExecutor.submit(
                        () -> allocationOrderDetailDao.getAllocationOrderDetailList1(map));
                list = submit.get();
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
            lists=ListUtils.union(lists,list);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return lists;
    }

    @Override
    public List<AllocationOrderDetail> getNoThread() {
        Map<String,String> map = new HashMap<>();
        List<AllocationOrderDetail> lists=new ArrayList<>();
        for (int i=0;i<5;i++) {
            String name = "" + (i * 5) + ",5";
            map.put("limit", name);
            List<AllocationOrderDetail> list = allocationOrderDetailDao.getAllocationOrderDetailList1(map);
            lists = ListUtils.union(lists, list);
        }
        return lists;
    }
}
