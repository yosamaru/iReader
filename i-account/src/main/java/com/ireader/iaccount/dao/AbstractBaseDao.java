package com.ireader.iaccount.dao;

import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public abstract class AbstractBaseDao<T, ID> extends SimpleJpaRepository<T, ID> implements
		BaseDao<T, ID> {

	EntityManager entityManager;

	public AbstractBaseDao(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.entityManager = em;
	}


}
