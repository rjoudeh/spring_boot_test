package com.springboot.testapp.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.testapp.domain.Department;
import com.springboot.testapp.domain.Employee;
import com.springboot.testapp.service.DepartmentService;
import com.springboot.testapp.service.EmployeeService;

/**
 * 
 * @author Rania
 * 
 */
@Controller
@RequestMapping("/reports")
public class ReportsController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "/index")
	public ModelAndView allReports() {
		ModelAndView result = new ModelAndView("/reports/allReports");
		return result;
	}

	@RequestMapping(value = "/departmentsAndEmployees")
	public String departmentsAndEmployee(Model model) {
		List<Department> result = (List<Department>) departmentService
				.findAllGroupByDepartment();
		model.addAttribute("result", result);
		return "/reports/departmentsAndEmployees";
	}

	@RequestMapping(value = "/departmentsSortedByEmployeesCount")
	public String departmentsSortedByEmployeesCount(Model model) {
		List<Department> result = departmentService.findDepartmentsOrderByEmployeesCount();
		model.addAttribute("result", result);
		return "/reports/departmentsSortedByEmployeesCount";
	}

	@RequestMapping(value = "/employeesSortedBySalary")
	public String employeesSortedBySalary(Model model) {
		List<Employee> result = employeeService.findAllSortBySalaryDesc();

		model.addAttribute("employees", result);
		return "/reports/employeesSortedBySalary";
	}

}
