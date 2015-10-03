package com.springboot.testapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.testapp.domain.Employee;
import com.springboot.testapp.repository.EmployeeRepository;

import static com.springboot.testapp.service.ServiceHelper.SortType.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee create(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Employee delete(int id) throws RuntimeException {
		Employee deletedEmployee = repository.findOne(id);
		if (deletedEmployee == null)
			throw new RuntimeException();

		repository.delete(id);
		return deletedEmployee;
	}

	@Override
	public List<Employee> findAll() {
		return (List<Employee>) repository.findAll();
	}

	@Override
	public Employee update(Employee employee) throws RuntimeException {
		Employee updatedEmployee = repository.findOne(employee.getEmployeeId());
		if (updatedEmployee == null)
			throw new RuntimeException();

		updatedEmployee.setName(employee.getName());
		updatedEmployee.setMaritalStatus(employee.getMaritalStatus());
		updatedEmployee.setBirthDate(employee.getBirthDate());
		updatedEmployee.setDepartment(employee.getDepartment());
		updatedEmployee.setSalary(employee.getSalary());

		return repository.save(employee);
	}

	@Override
	public Employee findById(int id) {
		return repository.findOne(id);
	}

	@Override
	public List<Employee> findAllSortBySalaryDesc() {
		Sort sortBySalary = SortHelper.sortByField(DESC, "salary");
		Iterable<Employee> employees = repository.findAll(sortBySalary);
		return (List<Employee>) employees;
	}
}
