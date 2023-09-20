package com.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.Entity.Employee;
import com.springboot.app.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employee = employeeService.getAllEmployee();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    
    @GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
    	
		Employee employee = employeeService.getEmployeeById(id);

		return new ResponseEntity<>(employee, HttpStatus.OK);

	}
    
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
    	
    	Employee employees = employeeService.createUser(employee);
	
    	return new ResponseEntity<>(employees,HttpStatus.CREATED);
    	
    }
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long empid,@RequestBody Employee employee){
    	
    	employee.setEmpId(empid);
    	Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
    
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id){
		
    	 employeeService.deleteEmployeeById(id);
    	 
    	 return new ResponseEntity<>("Employee successfully deleted", HttpStatus.OK);
    	
    }
    
}
