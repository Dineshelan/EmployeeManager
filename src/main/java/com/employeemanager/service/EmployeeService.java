package com.employeemanager.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanager.entity.Employee;
import com.employeemanager.exception.UserNotFoundException;
import com.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	public EmployeeRepository employeeRepo;

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}

	public List<Employee> findAllEmployee() {
		return employeeRepo.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee findEmployeeById(Long id) throws UserNotFoundException {
	
		Employee employee = employeeRepo.findEmployeeById(id);

		if (employee == null) {
			throw new UserNotFoundException("User with ID " + id + " was not found");
		}

		return employee;
	}

	@Transactional
	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}

}
