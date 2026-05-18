/**
 * 
 */
package com.specmart.manage.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specmart.manage.employee.entity.Employee;
import com.specmart.manage.employee.repository.EmployeeRepository;

/**
 * 
 */
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return repository.findAll();
	}
}
