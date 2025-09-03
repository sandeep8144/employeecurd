package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Employee;
import com.practice.service.EmployeeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return empService.saveEmployee(emp);
	}
	
	@GetMapping
    public List<Employee> getAll() {
        return empService.getAllEmployee();
    }
	
	@GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return empService.getEmployeeById(id);
    }
	
	@PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        return empService.updateEmployee(id, emp);
    }
	
	@DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        empService.deleteEmployee(id);
        return "Employee deleted";
    }
	
	@GetMapping("/welcome")
	public String welcome() {
	    return "Welcome to Employee Management System API!";
	}

}
