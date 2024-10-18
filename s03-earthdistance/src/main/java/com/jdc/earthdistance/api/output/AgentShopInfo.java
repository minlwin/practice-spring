package com.jdc.earthdistance.api.output;

import java.util.UUID;

public record AgentShopInfo(
		UUID id,
		String shopName,
		String ownerName,
		double lat,
		double lon) {

}
