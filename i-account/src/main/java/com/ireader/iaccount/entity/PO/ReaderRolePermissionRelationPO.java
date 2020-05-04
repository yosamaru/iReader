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
@Table(name = "R_ROLE_PERMISSION_RELATION")
public class ReaderRolePermissionRelationPO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_ROLE_PERMISSION_RELATION_SEQ")
	@SequenceGenerator(name = "R_ROLE_PERMISSION_RELATION_SEQ", sequenceName = "R_ROLE_PERMISSION_RELATION_SEQ")
	@Column(name = "ROLE_PERMISSION_ID")
	private Long rolePermissionId;
	@Column(name = "R_ROLE_PERMISSION_ID")
	private Long parentRoleId;
	@Column(name = "ROLE_ID")
	private String roleId;
	@Column(name = "PERMISSION_ID")
	private String permissionId;
	@Column(name = "PERMISSION_TYPE")
	private Integer permissionType;
}
