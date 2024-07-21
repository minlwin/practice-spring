package com.jdc.spring.practice.model.repo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdc.spring.practtice.model.domain.Division;
import com.jdc.spring.practtice.model.repo.DivisionRepository;

@Repository
public class DivisionRepositoryBean implements DivisionRepository{
	
	private JdbcTemplate template;
	
	public DivisionRepositoryBean(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Division> findAll() {
		return template.query("select * from division", 
				new BeanPropertyRowMapper<>(Division.class));
	}

}
