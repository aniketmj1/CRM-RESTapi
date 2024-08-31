package com.mooi.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mooi.dao.CustomerHandler;
import com.mooi.dao.TaskHandler;
import com.mooi.entity.CustomerEntity;
import com.mooi.entity.TaskEntity;

@RestController
public class CustomerRestController {

	@Autowired
	CustomerHandler customerHandler;

	@GetMapping("/customers")
	public List<CustomerEntity> getAllCust() {

		return customerHandler.getAllCustomer();

	}

	@GetMapping("/customers/{id}")
	public CustomerEntity getCust(@PathVariable("id") Long id) {

		return customerHandler.getCustomer(id);

	}

	@PostMapping("/customers")
	public CustomerEntity addcust(@RequestBody CustomerEntity c) {
		return customerHandler.addCustmer(c);
	}

	@PutMapping("/customers")
	public CustomerEntity updatecust(@RequestBody CustomerEntity c) {
		CustomerEntity tempC = new CustomerEntity();
		tempC.setFirstName(c.getFirstName());
		tempC.setLastName(c.getLastName());
		tempC.setEmail(c.getEmail());
		tempC.setPhoneNo(c.getPhoneNo());
		tempC.setId(c.getId());
		return customerHandler.addCustmer(tempC);
	}

	@DeleteMapping("/customers/{id}")
	public List<CustomerEntity> deletecust(@PathVariable("id") Long id) {
		customerHandler.deleteCustomer(id);
		return customerHandler.getAllCustomer();
	}

}
