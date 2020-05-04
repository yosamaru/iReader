package com.ireader.iaccount.dao.impl;

import com.ireader.iaccount.dao.AbstractBaseDao;
import com.ireader.iaccount.dao.PermissionDao;
import com.ireader.iaccount.entity.PO.ReaderPermissionPO;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionDaoImpl extends AbstractBaseDao<ReaderPermissionPO, Long> implements
		PermissionDao {

	public PermissionDaoImpl(EntityManager em) {
		super(ReaderPermissionPO.class, em);
	}
}
