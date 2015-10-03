package com.springboot.testapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springboot.testapp.domain.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
	
}
