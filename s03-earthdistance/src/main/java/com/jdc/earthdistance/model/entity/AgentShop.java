package com.jdc.earthdistance.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AgentShop {

	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(nullable = false)
	private String shopName;

	@Column(nullable = false)
	private String ownerName;

	@Column(nullable = false)
	private String phone;

	@Column(nullable = false)
	private double lat;
	
	@Column(nullable = false)
	private double lon;
}
