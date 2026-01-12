package com.jdc.mailing;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jdc.mailing.domain.BaseRepositoryImpl;

@EnableJpaRepositories(
	repositoryBaseClass = BaseRepositoryImpl.class
)
public class DataAccessConfig {

}
