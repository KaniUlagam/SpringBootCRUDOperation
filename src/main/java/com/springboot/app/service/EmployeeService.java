package com.springboot.app.service;

import java.util.List;

import com.springboot.app.Entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(Long id);
	
	Employee createUser(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployeeById(Long id);

}
