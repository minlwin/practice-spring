package com.jdc.earthdistance.api.input;

import com.jdc.earthdistance.model.entity.AgentShop;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record AgentShopForm(
		@NotEmpty(message = "Please enter shop name.")
		String shopName, 
		@NotEmpty(message = "Please enter owner name.")
		String ownerName, 
		@NotEmpty(message = "Please enter phone number.")
		String phone, 
		@NotBlank(message = "Please select latitude of shop location.")
		Double lat, 
		@NotBlank(message = "Please select longitude of shop location.")
		Double lon) {
	
	public AgentShop entity() {
		var entity = new AgentShop();
		entity.setShopName(shopName);
		entity.setOwnerName(ownerName);
		entity.setPhone(phone);
		entity.setLat(lat);
		entity.setLon(lon);
		return entity;
	}
}
