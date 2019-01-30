package com.yi23.springboot.service.impl;

import com.yi23.springboot.dao.PropagationDao;
import com.yi23.springboot.service.PropagationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @Author : 王斌
 * @Date : 2019/1/25 下午1:23
 * @Description 测试事物
 */
@Service
@Slf4j
public class PropagationServiceImpl implements PropagationService {


    @Autowired
    private PropagationDao propagationDao;


    @Override
    @Transactional(propagation = Propagation.NESTED)
    public Integer updateAllocationOrderDetailOne(Integer id, Integer pid) {
        try {
            propagationDao.updateAllocationOrderDetail(id,pid);
            updateAllocationOrderDetailSeconde(id+1,pid+1);
        }catch (Exception e){
            log.info(e.getMessage(),e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return 1;
    }

    @Override
    @Transactional
    public Integer updateAllocationOrderDetailSeconde(Integer id, Integer pid) {
        try {
            propagationDao.updateAllocationOrderDetail(id,pid);
            int i=1/0;
        }catch (Exception e){
            log.info(e.getMessage(),e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return 1;
    }
}
