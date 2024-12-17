package com.jdc.earthdistance.model.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.earthdistance.api.output.ShopDistance;
import com.jdc.earthdistance.model.entity.AgentShop;

public interface AgentShopRepo extends JpaRepository<AgentShop, UUID>{

	@Query(nativeQuery = true, value = """
			select id, shop_name as name, lat, lon, 
			earth_distance(ll_to_earth(:lat, :lon), ll_to_earth(lat, lon)) as distance 
			from agent_shop where earth_distance(ll_to_earth(:lat, :lon), ll_to_earth(lat, lon)) <= :radius
			""")
	List<ShopDistance> searchNearBy(double lat, double lon, double radius);
		
}
