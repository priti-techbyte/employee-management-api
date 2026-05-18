/**
 * 
 */
package com.specmart.manage.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.specmart.manage.employee.entity.Employee;

/**
 * 
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
