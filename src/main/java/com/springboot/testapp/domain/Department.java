package com.springboot.testapp.domain;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author rjoudeh
 * 
 */
@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue
	@Column(name = "department_id")
	private Integer departmentId;

	private String name;

	private String location;

	private String manager;
	
	@OneToMany(mappedBy = "department")
	private List<Employee> employees;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	/*
	 * 
	 */
	public int getEmployeesCount() {
		return  employees == null ? 0 : employees.size();
		
	}

	/**
	 * 
	 * @return
	 */
	public double getTotalSalary() {
		double total = 0;
		for (Employee employee : employees) {
			total += employee.getSalary();
		}
		
		return total;
	}
	
	/**
	 * Format total salary 
	 * @return
	 */
	public String getFormatedTotalSalary() {
		BigDecimal bigDecimal = new BigDecimal(getTotalSalary());
		return NumberFormat.getCurrencyInstance().format(bigDecimal);
	}
}
