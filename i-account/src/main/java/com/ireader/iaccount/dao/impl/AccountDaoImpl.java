package com.ireader.iaccount.dao.impl;

import com.ireader.iaccount.dao.AbstractBaseDao;
import com.ireader.iaccount.dao.AccountDao;
import com.ireader.iaccount.entity.PO.ReaderAccountPO;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl extends AbstractBaseDao<ReaderAccountPO, Long> implements
		AccountDao {

	public AccountDaoImpl(EntityManager em) {
		super(ReaderAccountPO.class, em);
	}
}
