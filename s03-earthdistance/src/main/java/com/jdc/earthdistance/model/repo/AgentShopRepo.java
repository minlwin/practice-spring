package com.jdc.earthdistance.model.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.earthdistance.model.entity.AgentShop;

public interface AgentShopRepo extends JpaRepository<AgentShop, UUID>{

}
