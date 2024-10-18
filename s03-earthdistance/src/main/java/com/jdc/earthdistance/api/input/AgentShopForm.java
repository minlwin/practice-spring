package com.jdc.earthdistance.api.input;

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
}
