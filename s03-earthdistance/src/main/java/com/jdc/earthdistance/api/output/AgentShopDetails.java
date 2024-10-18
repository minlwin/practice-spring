package com.jdc.earthdistance.api.output;

import java.util.UUID;

public record AgentShopDetails(
		UUID id,
		String shopName,
		String ownerName,
		String phone,
		double lat,
		double lon) {

}
