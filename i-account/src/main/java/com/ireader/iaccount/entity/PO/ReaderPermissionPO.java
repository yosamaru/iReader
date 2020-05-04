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
@Table(name = "R_PERMISSION")
public class ReaderPermissionPO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_PERMISSION_SEQ")
	@SequenceGenerator(name = "R_PERMISSION_SEQ", sequenceName = "R_PERMISSION_SEQ")
	@Column(name = "PERMISSION_ID")
	private Long permissionId;
	@Column(name = "PARENT_PERMISSION_ID")
	private Long parentPermissionId;
	@Column(name = "PERMISSION_NAME")
	private String permissionName;
	@Column(name = "DESCRIPTION")
	private String description;

}
