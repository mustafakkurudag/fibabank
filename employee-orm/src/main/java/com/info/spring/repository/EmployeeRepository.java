package com.info.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.info.spring.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Query("SELECT e FROM Employee e WHERE e.department.departmentId = :departmentId")
	List<Employee> findEmployeesByDepartmentId(@Param("departmentId") long departmentId);
}
