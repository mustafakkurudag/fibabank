package com.info.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.info.spring.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
