package com.ireader.iaccount.entity.PO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 操作日志表
 */
@Getter
@Setter
@Entity
@Table(name = "R_LOG_OPERATE")
public class ReaderLogOperatePO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_LOG_OPERATE_SEQ")
	@SequenceGenerator(name = "R_LOG_OPERATE_SEQ", sequenceName = "R_LOG_OPERATE_SEQ")
	@Column(name = "LOG_OPERATE_ID")
	private Long LogOperateId;
	@Column(name = "OPERATE_TYPE")
	private Long operateType;
	@Column(name = "OPERATE_CONTENT")
	private String operateContent;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "accountId")
	private ReaderAccountPO accountPO;
	@Column(name = "OPERATE_TIME")
	private Long operateTme;
}
