package com.springboot.testapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.testapp.domain.Department;
import com.springboot.testapp.domain.Employee;
import com.springboot.testapp.service.DepartmentService;
import com.springboot.testapp.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		setDepartmentsListToModel(model);
		return "/employees/employeeDetails";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployeeSubmit(
			@ModelAttribute("employee") Employee employee, Model model) {
		Employee created = employeeService.create(employee);
		setDepartmentsListToModel(model);
		model.addAttribute("successMessage", "Employee '" + created.getName() + "' added successfully!");
		return "/employees/employeeDetails";
	}

	private void setDepartmentsListToModel(Model model) {
		List<Department> deps = departmentService.findAll();
		model.addAttribute("deps", deps);

	}
}
