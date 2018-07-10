package com.jrj.cache.service;

import com.jrj.cache.bean.Employee;
import com.jrj.cache.mapper.EmployeeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
/**
 * 缓存必须要看的一个类就是
 * 		CacheAutoConfiguration
 * 
 * @CacheConfig(cacheNames="emp")
 * 		这个注解的作用标注在类上面：
 *      cacheNames：缓存的名称，下面的方法上就可以不用在指定了
 *      keyGenerator：key的生成器
 *      cacheManager：缓存管理的
 * 
 * @author Administrator
 *
 */
@CacheConfig(cacheNames="emp")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * @Cacheable(他可以标注在类上和方法上)有一下属性：
     * 			cacheNames|value：这两个都是指定那个缓存名称的
     * 			key：是指定缓存的key(与keyGenerator，他们两个只能是使用一个)
     * 			keyGenerator：key的生成策略，自己可以实现
     * 			condition：条件到达缓存
     * 			unless：条件到达不缓存
     * 			sync：异步
     * 			cacheManager：缓存管理
     * 			cacheResolver：缓存解析
     * 			
     * @param id
     * @return
     */
    @Cacheable(value = {"emp"},keyGenerator="myKeyGenerator")
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

  
    @CachePut(key = "#result.id")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp:"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

   
    @CacheEvict(value="emp",beforeInvocation = true)
    public void deleteEmp(Integer id){
        System.out.println("deleteEmp:"+id);
        //employeeMapper.deleteEmpById(id);
        int i = 10/0;
    }

  
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }




}
