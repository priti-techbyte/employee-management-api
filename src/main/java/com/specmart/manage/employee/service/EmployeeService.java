/**
 * 
 */
package com.specmart.manage.employee.service;

import java.util.List;
import java.util.Optional;

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
	
	public Employee getEmployeeById(Long id) {
		Optional<Employee> employee = repository.findById(id);
		return employee.orElseThrow(() -> 
			new RuntimeException("Employee not found with id: "+id));
	}
	
	public String deleteEmployee(Long id) {
		repository.deleteById(id);
		return "Employee deleted successfully";
	}
	
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		Employee existingEmployee = repository.findById(id).orElse(null);

		if(existingEmployee != null) {
			existingEmployee.setName(updatedEmployee.getName());
			existingEmployee.setEmail(updatedEmployee.getEmail());
			existingEmployee.setSalary(updatedEmployee.getSalary());
			existingEmployee.setDepartment(updatedEmployee.getDepartment());
			
			return repository.save(existingEmployee);
		}
		return null;
	}
}
