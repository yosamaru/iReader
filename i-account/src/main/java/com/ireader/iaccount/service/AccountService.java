package com.ireader.iaccount.service;

import java.util.Optional;

public interface AccountService {

	Optional getAccount(Long accountId);

	Optional getAccountByLoginAccount(String loginAccount);
}
