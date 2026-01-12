package com.jdc.mailing.domain.entity;

import java.time.LocalDateTime;

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
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String verificationCode;
	@Column(nullable = false)
	private LocalDateTime generatedAt;
	private LocalDateTime verifiedAt;

}
