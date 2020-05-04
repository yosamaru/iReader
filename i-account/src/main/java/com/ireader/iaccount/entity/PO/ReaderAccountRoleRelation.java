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
@Table(name = "R_ACCOUNT_ROLE_RELATION")
public class ReaderAccountRoleRelation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_ACCOUNT_ROLE_RELATION_SEQ")
	@SequenceGenerator(name = "R_ACCOUNT_ROLE_RELATION_SEQ", sequenceName = "R_ACCOUNT_ROLE_RELATION_SEQ")
	@Column(name = "ACCOUNT_ROLE_ID")
	private Long accountRoleId;
	@Column(name = "ACCOUNT_ID")
	private Long accountId;
	@Column(name = "ROLE_ID")
	private Long roleId;
}
