package com.jdc.earthdistance.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "agent_shop")
public class AgentShop {

	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(nullable = false, name = "shop_name")
	private String shopName;

	@Column(nullable = false, name = "owner_name")
	private String ownerName;

	@Column(nullable = false)
	private String phone;

	@Column(nullable = false)
	private Double lat;
	
	@Column(nullable = false)
	private Double lon;
}
