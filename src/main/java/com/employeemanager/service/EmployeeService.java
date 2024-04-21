package com.employeemanager.service;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanager.entity.Employee;
import com.employeemanager.exception.UserNotFoundException;
import com.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private final EmployeeRepository employeeRepo;

	public EmployeeService(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

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

	public Employee findEmployeeById(Long id) {
		try {
			if (id == null) {
				throw new UserNotFoundException("User by id " + id + " was not found");
			} else {
				return (employeeRepo.findEmployeeById(id));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}

}
