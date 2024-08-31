package com.mooi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mooi.dao.CustomerHandler;
import com.mooi.entity.CustomerEntity;
import com.mooi.restcontrollers.CustomerRestController;

@Controller
public class MainController {
	@Autowired
	CustomerHandler customerHandler;
	@Autowired
	CustomerRestController customerRestController;
	
	@GetMapping("/")
	public String home(Model m) {
//		m.addAttribute("allcustomer", customerRestController.getAllCust());
		return "home";
	}

	@GetMapping("/crm")
	public String crm(Model m) {
		m.addAttribute("allcustomer", customerRestController.getAllCust());
		return "index";
	}

	@GetMapping("/add")
	public String addProfile(Model m) {
		CustomerEntity newCustomer = new CustomerEntity();
		
		m.addAttribute("newCustomer", newCustomer);
		return "addprofile";
	}

	@PostMapping("/add")
	public String saveProfile(@ModelAttribute("newCustomer") CustomerEntity newCustomer) {

		System.out.println(newCustomer);

		customerRestController.addcust(newCustomer);

		return "redirect:/crm";
	}
	
	@GetMapping("/crm/{id}")
	public String deletecust(@PathVariable Long id) {
		System.out.println(id+"delete");
		customerRestController.deletecust(id);
		return "redirect:/crm";
	}
	
	@GetMapping("/edit/{id}")
	public String editProfile(@PathVariable Long id ,Model m) {
		CustomerEntity editCustomer = new CustomerEntity();
		editCustomer = customerRestController.getCust(id);
		System.out.println(editCustomer.getId());
		System.out.println(editCustomer.toString());
		m.addAttribute("editCustomer", editCustomer);
		return "editcustomer";
	}
	@PostMapping("/edit/{id}")
	public String editProfile(@ModelAttribute("editCustomer") CustomerEntity editCustomer ) {
		customerRestController.updatecust(editCustomer);
		System.out.println(editCustomer.getId());
		return "redirect:/crm";
	}
	// Task CODE
	
	
	


}
