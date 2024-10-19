package com.jdc.earthdistance.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.earthdistance.api.input.AgentShopForm;
import com.jdc.earthdistance.api.output.AgentShopInfo;
import com.jdc.earthdistance.model.repo.AgentShopRepo;

@RestController
@RequestMapping("shops/manage")
public class AgentShopManagementApi {
	
	@Autowired
	private AgentShopRepo repo;

	@GetMapping
	List<AgentShopInfo> findAll() {
		return repo.findAll().stream().map(AgentShopInfo::from).toList();
	}
	
	@PostMapping
	UUID create(@Validated @RequestBody AgentShopForm form, BindingResult result) {
		return repo.save(form.entity()).getId();
	}
}
