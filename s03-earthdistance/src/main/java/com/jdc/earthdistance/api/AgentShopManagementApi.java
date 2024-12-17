package com.jdc.earthdistance.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.earthdistance.api.input.AgentShopForm;
import com.jdc.earthdistance.api.output.AgentShopInfo;
import com.jdc.earthdistance.model.entity.AgentShop;
import com.jdc.earthdistance.model.repo.AgentShopRepo;

@RestController
@RequestMapping("shops/manage")
public class AgentShopManagementApi {
	
	@Autowired
	private AgentShopRepo repo;

	@GetMapping
	@Transactional(readOnly = true)
	List<AgentShopInfo> findAll() {
		return repo.findAll().stream().map(AgentShopInfo::from).toList();
	}
	
	@PostMapping
	@Transactional
	UUID create(@Validated @RequestBody AgentShopForm form, BindingResult result) {
		return repo.save(form.entity()).getId();
	}
	
	@PostMapping("upload")
	@Transactional
	int upload(@RequestParam MultipartFile file) {
		
		try (var br = new BufferedReader(new InputStreamReader(file.getInputStream()))){
			
			String line = null;
			var list = new ArrayList<AgentShop>();
			while(null != (line = br.readLine())) {
				var array = line.split("\t");
				var entity = new AgentShop();
				entity.setShopName(array[0]);
				entity.setOwnerName(array[1]);
				entity.setPhone(array[2]);
				entity.setLat(Double.valueOf(array[3]));
				entity.setLon(Double.valueOf(array[4]));
				list.add(entity);
			}
			
			if(!list.isEmpty()) {
				return repo.saveAll(list).size();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
