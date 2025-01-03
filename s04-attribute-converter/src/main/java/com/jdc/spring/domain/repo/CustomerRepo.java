package com.jdc.spring.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.spring.domain.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
