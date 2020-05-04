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
@Table(name = "R_ORGANIZE_PERMISSION_RELATION")
public class ReaderGroupPermissionRelationPO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_GROUP_PERMISSION_SEQ")
	@SequenceGenerator(name = "R_GROUP_PERMISSION_SEQ", sequenceName = "R_GROUP_PERMISSION_SEQ")
	@Column(name = "GROUP_PERMISSION_ID")
	private Long groupPermissionId;
	@Column(name = "GROUP_ID")
	private Long groupId;
	@Column(name = "PERMISSION_ID")
	private String permissionId;
	@Column(name = "PERMISSION_TYPE")
	private Integer permissionType;
}
