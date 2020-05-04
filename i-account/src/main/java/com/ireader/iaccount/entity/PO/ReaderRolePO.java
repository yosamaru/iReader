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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 角色
 */
@Getter
@Setter
@Entity
@Table(name = "R_ROLE")
public class ReaderRolePO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_ROLE_SEQ")
	@SequenceGenerator(name = "R_ROLE_SEQ", sequenceName = "R_ROLE_SEQ")
	@Column(name = "ROLE_ID")
	private Long roleId;
	@Column(name = "PARENT_ROLE_ID")
	private Long parentRoleId;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "R_ROLE_PERMISSION_RELATION", joinColumns = {
			@JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId")}, inverseJoinColumns = {
			@JoinColumn(name = "PERMISSION_ID", referencedColumnName = "permissionId")})
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<ReaderPermissionPO> permissionPOList;
	@Column(name = "ROLE_NAME")
	private String roleName;
	@Column(name = "description")
	private String description;
	@Column(name = "CREATE_TIME")
	private Date createTime;
	@Column(name = "UPDATE_TIME")
	private Date updateTIme;
}
