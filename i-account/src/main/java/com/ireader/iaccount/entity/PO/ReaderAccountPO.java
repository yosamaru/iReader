package com.ireader.iaccount.entity.PO;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 用户表
 */
@Getter
@Setter
@Entity
@Table(name = "R_ACCOUNT")
public class ReaderAccountPO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_ACCOUNT_SEQ")
	@SequenceGenerator(name = "R_ACCOUNT_SEQ", sequenceName = "R_ACCOUNT_SEQ")
	@Column(name = "ACCOUNT_ID")
	private Long accountId;
	@OneToOne
	@JoinColumn(name = "ORGANIZE_ID")
	private ReaderOrganizePO organizePO;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "R_ACCOUNT_PERMISSION_RELATION", joinColumns =
	@JoinColumn(name = "ACCOUNT_ID"), inverseJoinColumns =
	@JoinColumn(name = "ROLE_ID"))
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<ReaderPermissionPO> permissionPOList;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "R_ACCOUNT_GROUP_RELATION", joinColumns =
	@JoinColumn(name = "ACCOUNT_ID"), inverseJoinColumns =
	@JoinColumn(name = "GROUP_ID"))
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<ReaderGroupPO> groupPOList;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "R_ACCOUNT_ROLE_RELATION", joinColumns =
	@JoinColumn(name = "ACCOUNT_ID"), inverseJoinColumns =
	@JoinColumn(name = "ROLE_ID"))
	private List<ReaderRolePO> rolePOList;
	@Column(name = "LOGIN_ACCOUNT", unique = true, updatable = true)
	private String loginAccount;
	@Column(name = "LOGIN_PASSWORD")
	private String loginPassword;
	@Column(name = "ACCOUNT_NAME")
	private String accountName;
	@Column(name = "TELEPHONE")
	private Integer telephone;
	@Column(name = "LOGIN_TIME")
	private Date loginTime;
	@Column(name = "LAST_LOGIN_TIME")
	private Date lastLoginTime;
	@Column(name = "CREATE_TIME")
	private Date createTime;
	@Column(name = "UPDATE_TIME")
	private Date updateTime;
}
