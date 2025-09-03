package com.practice.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Employee;
import com.practice.repository.EmployeeRepository;
import com.practice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public Employee saveEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return empRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
	}

	@Override
	public Employee updateEmployee(Long id, Employee emp) {
		Employee existing = getEmployeeById(id);
		existing.setName(emp.getName());
		existing.setEmail(emp.getEmail());
		existing.setMobile(emp.getMobile());
		existing.setDepartment(emp.getDepartment());
		existing.setSalary(emp.getSalary());
		return empRepo.save(existing);
	}

	@Override
	public void deleteEmployee(Long id) {
		empRepo.deleteById(id);
	}

}
