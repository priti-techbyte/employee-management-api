/**
 * 
 */
package com.specmart.manage.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.specmart.manage.employee.entity.Employee;
import com.specmart.manage.employee.service.EmployeeService;

import jakarta.validation.Valid;

/**
 * 
 */

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@GetMapping
	public List<Employee> getEmployees(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return service.getEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		return service.deleteEmployee(id);
	}
}