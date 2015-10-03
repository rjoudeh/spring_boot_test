package com.springboot.testapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.springboot.testapp.domain.Department;

public interface DepartmentRepository extends
		PagingAndSortingRepository<Department, Integer> {

	@Query("SELECT d FROM Department d "
			+ " LEFT JOIN d.employees e " 
			+ "GROUP BY d.departmentId "
			+ "ORDER BY COUNT(e) DESC")
	public List<Department> findDepartmentsOrderByEmployeesCount();
}
