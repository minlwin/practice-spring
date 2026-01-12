package com.jdc.mailing.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

@Data
@Entity
public class AccountProfileHistory {

	@EmbeddedId
	private AccountProfileHistoryPk id;
	
	@ManyToOne
	@MapsId("id")
	private AccountProfile profile;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	
}
