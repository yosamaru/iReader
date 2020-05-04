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

/**
 * 组角色表
 */
@Getter
@Setter
@Entity
@Table(name = "R_GROUP_ROLE_RELATION")
public class ReaderGroupRoleRelationPO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_GROUP_PERMISSION_SEQ")
	@SequenceGenerator(name = "R_GROUP_PERMISSION_SEQ", sequenceName = "R_GROUP_PERMISSION_SEQ")
	@Column(name = "GROUP_ROLE_ID")
	private Long groupRoleId;
	@Column(name = "GROUP_ID")
	private Long groupId;
	@Column(name = "ROLE_ID")
	private Long roleId;
}
