package com.mooi.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mooi.entity.CustomerEntity;
import java.util.List;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	
	public void deleteById(Long id);
	
	public CustomerEntity getById(Long id);

	 


}
