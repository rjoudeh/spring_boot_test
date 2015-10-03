package com.springboot.testapp.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author rjoudeh
 *
 */

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "employee_id")
	@GeneratedValue
	private Integer employeeId;
	
	private String name;
	private Double salary;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "marital_status")
	private String maritalStatus;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer id) {
		this.employeeId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * Format salary
	 * @return
	 */
	public String getFormatedSalary() {
		BigDecimal bigDecimal = new BigDecimal(getSalary());
		return NumberFormat.getCurrencyInstance().format(bigDecimal);
	}
}
