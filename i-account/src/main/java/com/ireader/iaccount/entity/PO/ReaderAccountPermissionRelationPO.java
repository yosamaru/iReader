package com.ireader.iaccount.entity.PO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "R_ACCOUNT_PERMISSION_RELATION")
public class ReaderAccountPermissionRelationPO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_ACCOUNT_PERMISSION_SEQ")
	@SequenceGenerator(name = "R_ACCOUNT_PERMISSION_SEQ", sequenceName = "R_ACCOUNT_PERMISSION_SEQ")
	@Column(name = "ACCOUNT_PERMISSION_ID")
	private Long accountPermissionId;
	@Column(name = "ACCOUNT__ID")
	private Long accountId;
	@Column(name = "ROLE_ID")
	private Long roleId;

}
