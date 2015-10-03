package com.springboot.testapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.testapp.domain.Department;
import com.springboot.testapp.repository.DepartmentRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository repository;

//	@Autowired
//	DepartmentEmployeesRepository departmentEmployeesRepository;

	@Override
	public Department create(Department Department) {
		return repository.save(Department);
	}

	@Override
	public Department delete(int id) throws RuntimeException {
		Department deletedDepartment = repository.findOne(id);
		if (deletedDepartment == null)
			throw new RuntimeException();

		repository.delete(id);
		return deletedDepartment;
	}

	@Override
	public List<Department> findAll() {
		return (List<Department>) repository.findAll();
	}

	@Override
	public Department update(Department department) throws RuntimeException {
		Department updatedDepartment = repository.findOne(department
				.getDepartmentId());
		if (updatedDepartment == null)
			throw new RuntimeException();

		updatedDepartment.setName(department.getName());
		updatedDepartment.setManager(department.getManager());
		updatedDepartment.setLocation(department.getLocation());

		return repository.save(department);
	}

	@Override
	public Department findById(int id) {
		return repository.findOne(id);
	}

	@Override
	public List<Department> findAllGroupByDepartment() {
		return (List<Department>) repository.findAll();
	}

	@Override
	public List<Department> findDepartmentsOrderByEmployeesCount() {
		List<Department> result = repository.findDepartmentsOrderByEmployeesCount();
		return result;
	}
}
