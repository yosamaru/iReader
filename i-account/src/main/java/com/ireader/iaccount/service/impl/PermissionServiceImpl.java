package com.ireader.iaccount.service.impl;

import com.ireader.iaccount.dao.PermissionDao;
import com.ireader.iaccount.entity.PO.ReaderPermissionPO;
import com.ireader.iaccount.service.PermissionService;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Resource
	private PermissionDao permissionDao;

	@Override
	public Optional getPermission(Long permissionId) {
		return permissionDao.findById(permissionId);
	}

	@Override
	public List<ReaderPermissionPO> listPermissionByAccountId(Long accountId) {
		ReaderPermissionPO permissionPO = new ReaderPermissionPO();
		return null;
	}
}
