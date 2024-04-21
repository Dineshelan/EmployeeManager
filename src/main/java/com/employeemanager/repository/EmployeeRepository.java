package com.employeemanager.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanager.entity.Employee;

public interface EmployeeRepository extends JpaRepository <Employee,Long> {
	void deleteEmployeeById(Long id);

	Employee findEmployeeById(Long id);

}
