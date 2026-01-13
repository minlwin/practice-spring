package com.jdc.mailing.domain.entity;

import com.jdc.mailing.domain.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Account extends BaseEntity {

	enum Role {
		Admin, Member
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Role role;
	
	private boolean activated;
}
