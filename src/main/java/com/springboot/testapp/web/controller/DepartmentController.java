package com.springboot.testapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springboot.testapp.domain.Department;
import com.springboot.testapp.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService service;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addDepartmentForm(Model model) {
		model.addAttribute(new Department());
		return "/departments/departmentDetails";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addDepartmentSubmit(
			@ModelAttribute("department") Department department, Model model) {
		Department created = service.create(department);
		model.addAttribute("successMessage", "Department '" + created.getName() + "' successfully added");
		return "/departments/departmentDetails";
	}
}
