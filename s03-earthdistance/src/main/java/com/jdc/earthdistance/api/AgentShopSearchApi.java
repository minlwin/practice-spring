package com.jdc.earthdistance.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.earthdistance.api.output.ShopDistance;
import com.jdc.earthdistance.model.repo.AgentShopRepo;

@RestController
@RequestMapping("shops/nearby")
public class AgentShopSearchApi {
	
	@Autowired
	private AgentShopRepo repo;

	@GetMapping
	List<ShopDistance> search(@RequestParam double lat, @RequestParam double lon, @RequestParam double radius) {
		return repo.searchNearBy(lat, lon , radius);
	}

}
