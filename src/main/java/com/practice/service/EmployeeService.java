package com.practice.service;

import java.util.List;

import com.practice.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Long id, Employee emp);
	void deleteEmployee(Long id);
}
