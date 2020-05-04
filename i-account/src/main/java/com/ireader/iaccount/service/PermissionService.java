package com.ireader.iaccount.service;

import com.ireader.iaccount.entity.PO.ReaderPermissionPO;
import java.util.List;
import java.util.Optional;

public interface PermissionService {

	Optional getPermission(Long permissionId);

	List<ReaderPermissionPO> listPermissionByAccountId(Long accountId);
}
