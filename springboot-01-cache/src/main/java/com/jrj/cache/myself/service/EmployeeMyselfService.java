package com.jrj.cache.myself.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jrj.cache.bean.Employee;
import com.jrj.cache.mapper.EmployeeMapper;

@Service
public class EmployeeMyselfService {

	@Autowired
	private EmployeeMapper employeeMapper;
	/**
	 * Cacheable
	 * 		cacheNames:这个是缓存的名称
	 * 		key：是缓存的key
	 *      keyGenerator 这个缓存的key自动生成
	 *      cacheManager： 缓存管理
	 *      condition：缓存的条件，达到条件就缓存
	 *      unless ：和condition正好相反，达到则不缓存
	 *      sync：这个表示是否异步
	 * 
	 * 
	 */

	@Cacheable(cacheNames={"/emp"})
	public Employee getEmp(Integer id) {
		System.out.println("查询" + id + "号员工");
		return employeeMapper.getEmpById(id);
	}

	public Employee updateEmp(Employee employee) {
		System.out.println("updateEmp:" + employee);
		employeeMapper.updateEmp(employee);
		return employee;
	}

	public void deleteEmp(Integer id) {
		System.out.println("deleteEmp:" + id);
		employeeMapper.deleteEmpById(id);

	}

	public Employee getEmpByLastName(String lastName) {
		return employeeMapper.getEmpByLastName(lastName);
	}

}
