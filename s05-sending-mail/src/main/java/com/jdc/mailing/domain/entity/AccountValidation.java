package com.jdc.mailing.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class AccountValidation {

	@Id
	private Integer id;
	
	@OneToOne
	@MapsId("id")
	private Account account;
	
	@Column(nullable = false)
	private String verificationCode;
	
	@Column(nullable = false)
	private LocalDateTime exipiredAt;
	
	private LocalDateTime verifiedAt;

}
