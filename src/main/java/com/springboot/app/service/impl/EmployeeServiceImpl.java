package com.springboot.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.Entity.Employee;
import com.springboot.app.Respository.EmployeeRepository;
import com.springboot.app.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {

		Optional<Employee> empId = employeeRepository.findById(id);

		return empId.get();
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub

		employeeRepository.deleteById(id);

	}

	@Override
	public Employee createUser(Employee employee) {
		
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		Employee exEmp = employeeRepository.findById(employee.getEmpId()).get();
		exEmp.setFirstName(employee.getFirstName());
		exEmp.setLastName(employee.getLastName());
		exEmp.setHireDate(employee.getHireDate());
		exEmp.setSalary(employee.getSalary());
		return employeeRepository.save(employee);
	}

}
