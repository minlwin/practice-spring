package com.jdc.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.domain.entity.Customer;
import com.jdc.spring.domain.service.CustomerService;

@SpringBootTest
class S04AttributeConverterApplicationTests {
	
	@Autowired
	private CustomerService service;

	@Test
	void contextLoads() {
		
		var entity = new Customer();
		entity.setName("Zaw Min Lwin");
		entity.setEmail("minlwin@gmail.com");
		entity.setPhone("09782003098");
		entity.setNrcNumber("12/DAGAYA(N)016769");
		
		var id = service.create(entity);
		
		var output = service.findById(id);
		
		assertEquals(entity.getNrcNumber(), output.getNrcNumber());
	}

}
