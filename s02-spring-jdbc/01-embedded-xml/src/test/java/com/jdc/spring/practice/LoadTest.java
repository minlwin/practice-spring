package com.jdc.spring.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.spring.practtice.model.repo.DivisionRepository;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class LoadTest {
	
	@Autowired
	private DivisionRepository repository;
	
	@Test
	void test() {
		var result = repository.findAll();
		
		assertEquals(15, result.size());
	}

}
