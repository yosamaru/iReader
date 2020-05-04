package com.ireader.iaccount.service.impl;

import com.ireader.iaccount.dao.AccountDao;
import com.ireader.iaccount.entity.PO.ReaderAccountPO;
import com.ireader.iaccount.service.AccountService;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountDao accountDao;

	@Override
	public Optional getAccount(Long accountId) {
		return accountDao.findById(accountId);
	}

	@Override
	public Optional getAccountByLoginAccount(String loginAccount) {
		ReaderAccountPO readerAccountPO = new ReaderAccountPO();
		readerAccountPO.setLoginAccount(loginAccount);
		Example<ReaderAccountPO> accountPOExample = Example.of(readerAccountPO);
		return accountDao.findOne(accountPOExample);
	}
}
