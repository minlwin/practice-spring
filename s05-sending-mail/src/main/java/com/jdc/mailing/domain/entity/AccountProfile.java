package com.jdc.mailing.domain.entity;

import com.jdc.mailing.domain.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class AccountProfile extends BaseEntity {

	@Id
	private Integer id;
	@Column(nullable = false)
	private int version;

	@OneToOne
	@MapsId("id")
	private Account account;

	private String profileImage;
	
}
