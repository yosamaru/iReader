package com.ireader.iaccount.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseDao<T, ID> extends JpaRepository<T, ID>,
		JpaSpecificationExecutor<T>,
		PagingAndSortingRepository<T, ID> {


}
