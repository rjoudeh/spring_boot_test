package com.springboot.testapp.service;

import java.util.List;

import com.springboot.testapp.domain.Employee;

public interface EmployeeService {
	public Employee create(Employee employee);

	public Employee delete(int id) throws RuntimeException;

	public List<Employee> findAll();

	public Employee update(Employee employee) throws RuntimeException;

	public Employee findById(int id);
	
	public List<Employee> findAllSortBySalaryDesc();

}
