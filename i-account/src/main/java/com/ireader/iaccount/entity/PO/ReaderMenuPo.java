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

@Getter
@Setter
@Entity
@Table(name = "R_MENU")
public class ReaderMenuPo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_MENU_SEQ")
	@SequenceGenerator(name = "R_MENU_SEQ", sequenceName = "R_MENU_SEQ")
	@Column(name = "MENU_ID")
	private Long menuId;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "R_MENU_ROLE_RELATION", joinColumns =
	@JoinColumn(name = "MENU_ID"), inverseJoinColumns =
	@JoinColumn(name = "ROLE_ID"))
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<ReaderRolePO> rolePOList;
	@Column(name = "MENU_NAME")
	private String menuName;
	@Column(name = "URL")
	private Long url;
	@Column(name = "CREATE_TIME")
	private Date createTime;
	@Column(name = "UPDATE_TIME")
	private Date updateTime;
}
