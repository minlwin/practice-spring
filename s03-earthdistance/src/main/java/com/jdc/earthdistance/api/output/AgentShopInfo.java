package com.jdc.earthdistance.api.output;

import java.util.UUID;

import com.jdc.earthdistance.model.entity.AgentShop;

public record AgentShopInfo(
		UUID id,
		String shopName,
		String ownerName,
		double lat,
		double lon) {

	public static AgentShopInfo from(AgentShop shop) {
		return new AgentShopInfo(shop.getId(), shop.getShopName(), shop.getOwnerName(), shop.getLat(), shop.getLon());
	}
}
