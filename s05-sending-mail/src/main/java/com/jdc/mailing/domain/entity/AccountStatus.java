package com.jdc.mailing.domain.entity;

import java.time.LocalDateTime;

import com.jdc.mailing.domain.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class AccountStatus extends BaseEntity {

	@Id
	private Integer id;

	@OneToOne
	@MapsId("id")
	private Account account;

	private boolean online;
	private String lastLoginIp;
	private LocalDateTime lastLogin;
	private LocalDateTime lastLogout;

}
