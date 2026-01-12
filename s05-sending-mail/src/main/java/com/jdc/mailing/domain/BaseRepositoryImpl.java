package com.jdc.mailing.domain;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.jdc.mailing.domain.dto.PageResult;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

	private final EntityManager entityManager;

	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public <R> List<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc) {
		return entityManager.createQuery(queryFunc.apply(entityManager.getCriteriaBuilder())).getResultList();
	}

	@Override
	public <R> PageResult<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc,
			Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc, int page, int size) {
		var count = entityManager.createQuery(countFunc.apply(entityManager.getCriteriaBuilder()))
				.getSingleResult();
		
		var query = entityManager.createQuery(queryFunc.apply(entityManager.getCriteriaBuilder()));
		query.setFirstResult((page - 1) * size);
		query.setMaxResults(size);
			
		return PageResult.<R>builder()
				.page(page)
				.size(size)
				.total(count)
				.contents(query.getResultList())
				.build();
	}

	@Override
	public <R> Optional<R> findOne(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc) {
		return Optional.ofNullable(
				entityManager.createQuery(queryFunc.apply(entityManager.getCriteriaBuilder())).getSingleResult());
	}

}
