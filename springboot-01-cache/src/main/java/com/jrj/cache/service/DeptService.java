package com.jrj.cache.service;

import com.jrj.cache.bean.Department;
import com.jrj.cache.mapper.DepartmentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;
import sun.applet.resources.MsgAppletViewer;

import java.util.List;
import java.util.Map;


@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

//    @Qualifier("deptCacheManager")
//    @Autowired
//    RedisCacheManager deptCacheManager;


    /**
     *  缓存的数据能存入redis；
     *  第二次从缓存中查询就不能反序列化回来；
     *  存的是dept的json数据;CacheManager默认使用RedisTemplate<Object, Employee>操作Redis
     *
     *
     * @param id
     * @return
     */
//    @Cacheable(cacheNames = "dept",cacheManager = "deptCacheManager")
//    public Department getDeptById(Integer id){
//        System.out.println("查询部门"+id);
//        Department department = departmentMapper.getDeptById(id);
//        return department;
//    }

    // 使用缓存管理器得到缓存，进行api调用
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentMapper.getDeptById(id);

        //获取某个缓存
      //  Cache dept = deptCacheManager.getCache("dept");
       // dept.put("dept:1",department);

        return department;
    }


    public List<Map<String ,Object>> maps(){

        return departmentMapper.maps();
    }

    public Integer insert(String name){
        return departmentMapper.insert(name);
    }


}
