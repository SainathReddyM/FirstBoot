package com.msr.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msr.models.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/* add initbinder to pre-process the requests
	 * pre-process every string data to remove white spaces 
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor str= new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, str);
	}
	
	
	@RequestMapping("/showform")
	public String showForm(Model model) {
		model.addAttribute("customer",new Customer());
		return "customer-form";
	}
	
	@RequestMapping("/processform")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult ) {
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}
		return "customer-confirmation";
	}

}
