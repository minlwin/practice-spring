package com.jdc.spring.domain.entity;

import com.jdc.spring.domain.EncryptionConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	private String phone;
	private String email;
	
	@Convert(converter = EncryptionConverter.class)
	@Column(nullable = false)
	private String nrcNumber;
}
