package com.springboot.testapp.service;

import java.util.List;
import java.util.Map;

import com.springboot.testapp.domain.Department;

public interface DepartmentService {
	public Department create(Department Department);

	public Department delete(int id) throws RuntimeException;

	public List<Department> findAll();

	public Department update(Department Department) throws RuntimeException;

	public Department findById(int id);
		
	public List<Department> findAllGroupByDepartment();
	
	public List<Department> findDepartmentsOrderByEmployeesCount();
	
}
