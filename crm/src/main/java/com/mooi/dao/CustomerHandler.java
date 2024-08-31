package com.mooi.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooi.entity.CustomerEntity;
import com.mooi.services.CustomerRepository;


@Service
public class CustomerHandler {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public   List<CustomerEntity> getAllCustomer()	
	{
		return this.customerRepository.findAll();		
	}
	
	public CustomerEntity getCustomer(Long id) 
	{
		return this.customerRepository.getById(id);
		
	}
	
	public CustomerEntity addCustmer(CustomerEntity c)
	{
		return this.customerRepository.save(c);
	}
	
	public void deleteCustomer(Long id)
	{
		
		customerRepository.deleteById(id);
		
	}
	

}
