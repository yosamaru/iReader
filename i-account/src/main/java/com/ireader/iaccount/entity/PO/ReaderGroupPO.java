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
 * 分组表
 */
@Getter
@Setter
@Entity
@Table(name = "R_GROUP")
public class ReaderGroupPO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_GROUP_SEQ")
	@SequenceGenerator(name = "R_GROUP_SEQ", sequenceName = "R_GROUP_SEQ")
	@Column(name = "GROUP_ID")
	private Long groupId;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "R_ORGANIZE_PERMISSION_RELATION", joinColumns = {
			@JoinColumn(name = "GROUP_ID", referencedColumnName = "groupId")}, inverseJoinColumns = {
			@JoinColumn(name = "PERMISSION_ID", referencedColumnName = "permissionId")})
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<ReaderPermissionPO> permissionPOList;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "R_GROUP_ROLE_RELATION", joinColumns = {
			@JoinColumn(name = "GROUP_ID", referencedColumnName = "groupId")}, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId")})
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<ReaderRolePO> rolePOList;
	@Column(name = "GROUP_NAME")
	private String groupName;
	@Column(name = "GROUP_PARENT_NAME")
	private String groupParentName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "CREATE_TIME")
	private Date createTime;
	@Column(name = "UPDATE_TIME")
	private Date updateTime;
}
