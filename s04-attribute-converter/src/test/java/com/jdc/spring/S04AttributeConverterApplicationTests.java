package com.jdc.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.domain.EncryptionConverter;

@SpringBootTest
class S04AttributeConverterApplicationTests {
	
	@Autowired
	private EncryptionConverter converter;

	@Test
	void contextLoads() {
		
		var original = "1234567890123456";
		var encrypted = converter.convertToDatabaseColumn(original);
		
		System.out.println(encrypted);
		
		var decrypted = converter.convertToEntityAttribute(encrypted);
		
		System.out.println(decrypted);
	}

}
