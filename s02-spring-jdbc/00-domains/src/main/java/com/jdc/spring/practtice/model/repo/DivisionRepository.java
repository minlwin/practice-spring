package com.jdc.spring.practtice.model.repo;

import java.util.List;

import com.jdc.spring.practtice.model.domain.Division;

public interface DivisionRepository {

	List<Division> findAll();
}
