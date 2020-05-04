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
@Table(name = "R_ACCOUNT_GROUP_RELATION")
public class ReaderAccountGroupRelationPO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_ACCOUNT_GROUP_RELATION_SEQ")
	@SequenceGenerator(name = "R_ACCOUNT_GROUP_RELATION_SEQ", sequenceName = "R_ACCOUNT_GROUP_RELATION_SEQ")
	@Column(name = "ACCOUNT_GROUP_ID")
	private Long accountGroupId;
	@Column(name = "account_id")
	private Long accountId;
	@Column(name = "group_id")
	private Long groupId;
}
