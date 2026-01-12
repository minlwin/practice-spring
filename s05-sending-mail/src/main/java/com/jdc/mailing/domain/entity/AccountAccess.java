package com.jdc.mailing.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AccountAccess {
	
	enum AccessType {
		Login, Logout, PasswordChange, ProfileUpdate
	}

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String username;
	private String ipAddress;
	private LocalDateTime accessedAt;
	
	private AccessType accessType;
	private boolean successful;
	private String message;
}
