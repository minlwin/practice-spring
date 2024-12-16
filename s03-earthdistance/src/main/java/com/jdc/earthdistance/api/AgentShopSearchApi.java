package com.jdc.earthdistance.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.earthdistance.api.input.AgentShopSearch;
import com.jdc.earthdistance.api.output.AgentShopInfo;
import com.jdc.earthdistance.model.service.AgentShopService;

@RestController
@RequestMapping("shops/nearby")
public class AgentShopSearchApi {
	
	private AgentShopService service;

	@GetMapping
	List<AgentShopInfo> search(AgentShopSearch search) {
		return service.search(search);
	}

}
