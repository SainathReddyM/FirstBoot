package com.msr.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(HttpServletRequest request, Model model) {
		String name=request.getParameter("personName");
		name=name.toUpperCase();
		model.addAttribute("name", name);
		return "helloworld";
	}
	
	@RequestMapping("/processFormv2")
	public String processForm(@RequestParam("personName") String thename, Model model) {
		thename=thename.toUpperCase();
		model.addAttribute("name", thename);
		return "helloworld";
	}
}
