package com.jdc.spring.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.domain.entity.Customer;
import com.jdc.spring.domain.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo repo;

	@Transactional
	public int create(Customer customer) {
		return repo.save(customer).getId();
	}
	
	@Transactional(readOnly = true)
	public Customer findById(int id) {
		return repo.findById(id).orElseThrow();
	}
}
