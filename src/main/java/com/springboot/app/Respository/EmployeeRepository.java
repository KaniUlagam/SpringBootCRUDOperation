package com.springboot.app.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
