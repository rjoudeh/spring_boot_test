package com.springboot.testapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping(value = "/index")
	public ModelAndView welcome() {
		ModelAndView result = new ModelAndView("index");
		return result;
	}
}
