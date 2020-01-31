package com.msr.springdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.msr.springdemo.dao.CustomerDao;
import com.msr.springdemo.entity.Customer;
import com.msr.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> customers=customerService.getCustomers();
		theModel.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/addCustomerForm")
	public String addCustomer(Model theModel) {
		Customer theCustomer= new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "add-customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("customerId") int id, Model theModel) {
		Customer theCustomer= customerService.getCustomerById(id);
		theModel.addAttribute("customer", theCustomer);
		return "add-customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomerById(id);
		return "redirect:/customer/list";
	}
}
