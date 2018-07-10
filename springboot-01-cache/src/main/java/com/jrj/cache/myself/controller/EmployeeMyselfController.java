package com.jrj.cache.myself.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jrj.cache.bean.Employee;
import com.jrj.cache.myself.service.EmployeeMyselfService;

@RestController
public class EmployeeMyselfController {

	@Autowired
	EmployeeMyselfService employeeService;

	@GetMapping("/myself/emp/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {
		Employee employee = employeeService.getEmp(id);
		return employee;
	}

	@GetMapping("/myself/emp")
	public Employee update(Employee employee) {
		Employee emp = employeeService.updateEmp(employee);

		return emp;
	}

	@GetMapping("/myself/delemp")
	public String deleteEmp(Integer id) {
		employeeService.deleteEmp(id);
		return "success";
	}

	@GetMapping("/myself/emp/lastname/{lastName}")
	public Employee getEmpByLastName(@PathVariable("lastName") String lastName) {
		return employeeService.getEmpByLastName(lastName);
	}

}
